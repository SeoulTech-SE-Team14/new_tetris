package view.abstractComponent.panel.game;

import javax.swing.JPanel;
import java.awt.*;
import java.util.List;

import domain.block.controller.BlockController;
import domain.board.controller.BoardController;

import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.DrillItem;
import domain.board.entity.Board;

import global.matrix.IntMatrixUtil;

public class BoardPanel extends JPanel {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 20;

    private BoardController boardController = BoardController.getInstance();
    private Board board;
    // 패널 크기 조절할 수 있게 매개변수로 받는다.
    public BoardPanel(int panelWidth, int panelHeight) {
        this.PANEL_WIDTH = panelWidth;
        this.PANEL_HEIGHT = panelHeight;
        initBoard();
        initPanel();
    }

    public Board getBoard() {
        return board;
    }

    private void initBoard() {
        board = new Board();
        boardController.init(board);
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

    // draw method
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
                if (tBoard[r][c][0] == Board.TYPE_LINE_REMOVER) {
                    shape = "L";
                }
                else  {
                    shape = "O";
                }
                drawText(g, c, (r - 4), color, shape);
            }
        }
    }
    public void drawNowBlock(Graphics g) {
        Block nowBlock = board.getNowBlock();
        int[][] nowBlockPos = boardController.findCurBlockPosInBoard(board);
        int lineRemoverIdx = boardController.findLineRemover(nowBlock);
        int count = IntMatrixUtil.countNotZeroValue(nowBlock.getShape());

        for (int i = 0; i < count; i++) {
            int x = nowBlockPos[i][1];
            int y = nowBlockPos[i][0] - 4;

            // 수정 필요
            Color color = new Color(BlockController.getInstance().getBlockColor(nowBlock));
            String shape;
            if(nowBlock instanceof BombItem) {
                shape = "B";
            }
            else if(nowBlock instanceof DrillItem) {
                shape = "D";
            }
            else if(i == lineRemoverIdx) {
                shape = "L";
            }
            else {
                shape = "O";
            }
            drawText(g, x, y, color, shape);
        }
    }
    public void drawDeletedLine(Graphics g) {
        List<Integer> toDelete = BoardController.getInstance().findFullLine(board);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawNowBlock(g);
        drawDeletedLine(g);
    }
}
