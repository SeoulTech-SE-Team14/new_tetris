package view.abstractComponent.panel.game;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import domain.block.controller.BlockController;
import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.DrillItem;
import domain.board.constant.BoardComponent;
import domain.board.constant.map.BoardColorMap;
import domain.board.controller.BoardController;
import domain.board.entity.Board;
import global.matrix.IntMatrixUtil;

import java.awt.*;

public class NextBlockPanel extends JPanel {
    private LineBorder lineBorder = new LineBorder(Color.WHITE);
    private Board board;
    public NextBlockPanel() {
        board = BoardController.getInstance().getBoard();
        setBackground(new Color(BoardColorMap.getColor(BoardComponent.EMPTY)));
        setPreferredSize(new Dimension(300, 300));
        setBorder(lineBorder);
    }
    private int squareWidth() {
        return (int) getSize().getWidth() / 4;
    }
    private int squareHeight() {
        return (int) getSize().getHeight() / 4;
    }

    // draw method
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
    public void drawNextBlock(Graphics g) {
        int[][] nextBlockPos = IntMatrixUtil.findAllNotZeroValuePos(board.getPrevBlock().getShape(), IntMatrixUtil.countNotZeroValue(board.getPrevBlock().getShape()));
        int[] center = IntMatrixUtil.findNearestCenter(board.getPrevBlock().getShape());

        for (int i = 0; i < IntMatrixUtil.countNotZeroValue(board.getPrevBlock().getShape()); i++) {
            nextBlockPos[i][0] = 1 + (nextBlockPos[i][0] - center[0]);
            nextBlockPos[i][1] = 1 + (nextBlockPos[i][1] - center[1]);
        }

        for (int i = 0; i < IntMatrixUtil.countNotZeroValue(board.getPrevBlock().getShape()); i++) {
            int x = nextBlockPos[i][1];
            int y = nextBlockPos[i][0];

            Block nextBlock = board.getPrevBlock();
            Color color = new Color(BlockController.getInstance().getBlockColor(nextBlock));
            String shape;
            int lineRemoverIdx = BoardController.getInstance().findLineRemover(nextBlock);
            if (nextBlock instanceof BombItem) {
                shape = "B";
            }
            else if (nextBlock instanceof DrillItem) {
                shape = "D";
            }
            else if (i == lineRemoverIdx) {
                shape = "L";
            }
            else {
                shape = "O";
            }

            drawText(g, x, y, color, shape);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawNextBlock(g);
    }
}
