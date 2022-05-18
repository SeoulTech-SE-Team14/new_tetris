package view.abstractComponent.panel.game;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import domain.block.controller.BlockController;
import domain.board.controller.BoardController;

import domain.board.entity.Board;
import domain.config.controller.BlockColorConfigController;
import domain.config.controller.DifficultyConfigController;
import domain.config.entity.BlockColorConfig;
import domain.config.entity.DifficultyConfig;
import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.DrillItem;

import domain.board.constant.BoardComponent;
import domain.board.constant.map.BoardColorMap;

import global.matrix.IntMatrixUtil;

import java.awt.*;

public class NextBlockPanel extends JPanel {
    private LineBorder lineBorder = new LineBorder(Color.WHITE);

    private BlockController blockController = BlockController.getInstance();
    private DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();
    private BlockColorConfigController blockColorConfigController = BlockColorConfigController.getInstance();

    private Block nextBlock;
    private DifficultyConfig difficultyConfig;
    private BlockColorConfig blockColorConfig;

    private int squareWidth;
    private int squareHeight;

    public Block getNextBlock() {
        return nextBlock;
    }

    public NextBlockPanel() {
        squareWidth = (int) getSize().getWidth() / 4;
        squareHeight = (int) getSize().getHeight() / 4;

        reset();

        setBackground(new Color(BoardColorMap.getColor(BoardComponent.EMPTY)));
        setPreferredSize(new Dimension(300, 300));
        setBorder(lineBorder);
    }

    public NextBlockPanel(int width, int height) {
        squareWidth = (int) (width / 4.0);
        squareHeight = (int) (height / 4.0);

        reset();

        setBackground(new Color(BoardColorMap.getColor(BoardComponent.EMPTY)));
        setBorder(lineBorder);
    }

    public void reset() {
        blockColorConfig = blockColorConfigController.getCurrentConfig();
        difficultyConfig = difficultyConfigController.getCurrentConfig();

        nextBlock = blockController.getRandomBlock(difficultyConfig);
    }

    public void updateNextBlock() {
        nextBlock = blockController.getRandomBlock(difficultyConfig);
    }

    public void updateNextItem() {
        nextBlock = blockController.getRandomItem(difficultyConfig);
    }

    private int squareWidth() {
        return squareWidth;
    }
    private int squareHeight() {
        return squareHeight;
    }

    // draw method
    private void drawText(Graphics g, int x, int y, Color color, String shape) {
        int fontSize = (int)(squareWidth());
        g.setColor(color);
        g.setFont(new Font("Serif", Font.BOLD, fontSize));
        g.drawString(shape, x * squareWidth(), (int)((y + 1) * squareWidth() * .74));
    }

    public void drawNextBlock(Graphics g) {
        int[][] blockShape = nextBlock.getShape();
        int count = IntMatrixUtil.countNotZeroValue(blockShape);
        int[][] nextBlockPos = IntMatrixUtil.findAllNotZeroValuePos(blockShape, count);

        for (int i = 0; i < count; i++) {

            int nx = nextBlockPos[i][0];
            int ny = nextBlockPos[i][1];

            Color color = new Color(blockController.getBlockColor(nextBlock, blockColorConfig));
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

            drawText(g, ny, nx + 2, color, shape);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawNextBlock(g);
    }
    @Override
    public void repaint() {
        super.repaint();
    }
}
