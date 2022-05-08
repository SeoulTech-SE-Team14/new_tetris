package view.abstractComponent.panel.game;

import javax.swing.JPanel;

import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.DrillItem;
import domain.board.controller.BoardController;
import domain.board.entity.Board;
import global.matrix.IntMatrixUtil;
import view.abstractComponent.frame.DefaultFrame;

import java.awt.*;

public class BoardPanel extends JPanel {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int BOARD_WIDTH;
    private final int BOARD_HEIGHT;

    private BoardController boardController = BoardController.getInstance();

    public BoardPanel(int panelWidth, int panelHeight, int boardWidth, int boardHeight) {
        this.PANEL_WIDTH = panelWidth;
        this.PANEL_HEIGHT = panelHeight;
        this.BOARD_WIDTH = boardWidth;
        this.BOARD_HEIGHT = boardHeight;

        initBoard();
        initPanel();
    }

    private void initBoard() {
        boardController.init();
    }

    private void initPanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setFocusable(true);
        //addKeyListener(new GameKeyListener());
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
        int fontSize = (int)(squareWidth());
        g.setColor(color);
        g.setFont(new Font("Serif", Font.BOLD, fontSize));
        g.drawString(shape, x * squareWidth(), (int)((y + 1) * squareWidth() * .74));
    }

    public void drawBoard(Graphics g) {
        int[][][] tBoard = boardController.getBoard().getBoard();

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
                //drawText(g, c, (r - 4), color, "O");
                //drawSquare(g, c * squareWidth(), (r - 4) * squareHeight(), color);
            }
        }
    }

    public void drawNowBlock(Graphics g) {
        Block nowBlock = boardController.getBoard().getNowBlock();
        int[][] nowBlockPos = boardController.findCurBlockPosInBoard();
        int lineRemoverIdx = boardController.findLineRemover(nowBlock);
        int count = IntMatrixUtil.countNotZeroValue(nowBlock.getShape());

        for (int i = 0; i < count; i++) {
            int x = nowBlockPos[i][1];
            int y = nowBlockPos[i][0] - 4;

            // 수정 필요
            Color color = new Color(nowBlock.getColor());
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

            //drawSquare(g, x * squareWidth(), y * squareHeight(), color);
            //drawText(g, x, y, color, "O");
            drawText(g, x, y, color, shape);
        }
    }

//    public void drawDeletedLine(Graphics g) {
//        if (GameFrame.toDelete != null) {
//            for (int y : GameFrame.toDelete) {
//                for (int x = 0; x < 10; x++) {
//                    int xPos = x * squareWidth();
//                    int yPos = (y - 4) * squareHeight();
//
//                    Color color = new Color(board.getBoard()[y][x][Board.COLOR] / 2);
//
//                    drawSquare(g, xPos, yPos, color);
//                }
//            }
//        }
//    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBoard(g);
        drawNowBlock(g);
    }

    public static void main(String[] args) {

        DefaultFrame frame = new DefaultFrame();
        GridLayout gl = new GridLayout(1, 1);
        frame.setLayout(gl);
        frame.add(new BoardPanel(300, 300, 4, 4));
        frame.setVisible(true);
    }
}
