package view.abstractComponent.panel.game;

import javax.swing.JPanel;
import java.awt.*;
import java.util.List;

import domain.block.controller.BlockController;
import domain.board.controller.BoardController;

import domain.block.entity.Block;
import domain.board.entity.Board;
import domain.config.controller.BlockColorConfigController;
import domain.config.controller.DifficultyConfigController;
import domain.config.entity.BlockColorConfig;
import domain.config.entity.DifficultyConfig;
import global.matrix.IntMatrixUtil;

public class BoardPanel extends JPanel {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 20;

    private BoardController boardController = BoardController.getInstance();
    private BlockController blockController = BlockController.getInstance();
    private BlockColorConfigController blockColorConfigController = BlockColorConfigController.getInstance();
    private DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();

    private BlockColorConfig blockColorConfig;
    private DifficultyConfig difficultyConfig;
    private Board board;
    private Block nowBlock;

    public BoardPanel(int panelWidth, int panelHeight) {
        this.PANEL_WIDTH = panelWidth;
        this.PANEL_HEIGHT = panelHeight;
        reset();
        initPanel();
    }

    public Board getBoard() {
        return board;
    }

    public Block getNowBlock() {
        return nowBlock;
    }

    public void reset() {
        blockColorConfig = blockColorConfigController.getCurrentConfig();
        difficultyConfig = difficultyConfigController.getCurrentConfig();

        board = new Board();
        nowBlock = blockController.getRandomBlock(difficultyConfig);
    }

    public void updateNowBlock(Block block) {
        nowBlock = block;

        board.setCurX(3);
        board.setCurY(4);
    }

    public int update() {
        int deletedLines = 0;
        deletedLines = boardController.findFullLine(board).size();

        if (doHitWall()) {
            transformBlockToBoard();
        } else {
            boardController.deleteFullLine(board);
            moveDown();
        }

        return deletedLines;
    }

    public void moveDown() {
        boardController.moveDown(board, nowBlock);
    }

    public void moveLeft() {
        boardController.moveLeft(board, nowBlock);
    }

    public void moveRight() {
        boardController.moveRight(board, nowBlock);
    }

    public boolean doHitWall() {
        return boardController.doHitWall(board, nowBlock);
    }

    public int moveDownAtOnce() {
        int count = 0;

        while (!doHitWall()) {
            moveDown(); count++;
        }

        return count;
    }

    public void transformBlockToBoard() {
        int color = blockController.getBlockColor(nowBlock, blockColorConfig);
        boardController.transformBlockToBoard(board, nowBlock, color);
    }

    public boolean isGameOver() {
        return boardController.isGameOver(board);
    }

    private void initPanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setFocusable(true);
    }

    private int squareWidth() {
        return (int) getSize().getWidth() / BOARD_WIDTH;
    }
    private int squareHeight() {
        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }

    private void drawSquare(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
    }

    private void drawText(Graphics g, int x, int y, Color color, String shape) {
        int fontSize = squareWidth();
        g.setColor(color);
        g.setFont(new Font("Serif", Font.BOLD, fontSize));
        g.drawString(shape, x * squareWidth(), (int)((y + 1) * squareWidth() * .74));
    }

    public void drawBoard(Graphics g) {
        int[][][] tBoard = board.getBoard();

        for (int r = 4; r < 24; r++) {
            for (int c = 0; c < 10; c++) {
                Color color = new Color(tBoard[r][c][Board.COLOR]);
                String shape;

                if (tBoard[r][c][Board.TYPE] == Board.TYPE_LINE_REMOVER)
                    shape = "L";
                else if (tBoard[r][c][Board.TYPE] == Board.TYPE_BOMB)
                    shape = "B";
                else if (tBoard[r][c][Board.TYPE] == Board.TYPE_BONUS_SCORE)
                    shape = "S";
                else if (tBoard[r][c][Board.TYPE] == Board.TYPE_DRILL)
                    shape = "D";
                else if (tBoard[r][c][Board.TYPE] == Board.TYPE_WEIGHT)
                    shape = "W";
                else  {
                    shape = "O";
                }

                drawText(g, c, (r - 4), color, shape);
            }
        }
    }

    public void drawNowBlock(Graphics g) {
        int[][] blockShape = nowBlock.getShape();
        int count = IntMatrixUtil.countNotZeroValue(blockShape);
        int[][] nowBlockPos = IntMatrixUtil.findAllNotZeroValuePos(blockShape, count);
        int[][] nowBlockPosInBoard = boardController.findNowBlockPosInBoard(board, nowBlock);

        for (int i = 0; i < count; i++) {

            int nx = nowBlockPos[i][0];
            int ny = nowBlockPos[i][1];

            Color color = new Color(blockController.getBlockColor(nowBlock, blockColorConfig));
            String shape;
            
            if (blockShape[nx][ny] == Board.TYPE_LINE_REMOVER)
                    shape = "L";
            else if (blockShape[nx][ny] == Board.TYPE_BOMB)
                shape = "B";
            else if (blockShape[nx][ny] == Board.TYPE_BONUS_SCORE)
                shape = "S";
            else if (blockShape[nx][ny] == Board.TYPE_DRILL)
                shape = "D";
            else if (blockShape[nx][ny] == Board.TYPE_WEIGHT)
                shape = "W";
            else
                shape = "O";

            int bx = nowBlockPosInBoard[i][1];
            int by = nowBlockPosInBoard[i][0] - 4;

            drawText(g, bx, by, color, shape);
        }
    }

    public void drawDeletedLine(Graphics g) {
        List<Integer> toDelete = boardController.findFullLine(board);
        if (!toDelete.isEmpty()) {
            for (int y : toDelete) {
                for (int x = 0; x < 10; x++) {
                    int xPos = x * squareWidth();
                    int yPos = (y - 4) * squareHeight();
                    Color color = new Color(board.getBoard()[y][x][Board.COLOR] / 2);
                    drawSquare(g, xPos, yPos, color);
                }
            }
        }
    }

    public void rotate() {
        boardController.rotate(board, nowBlock);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawBoard(g);
        drawNowBlock(g);
        drawDeletedLine(g);
    }

    @Override
    public void repaint() {
        super.repaint();
    }
}
