package view.abstractComponent.panel.game;

import javax.swing.JPanel;

import domain.block.entity.Block;

public class NextBlockPanel extends JPanel {

    protected Block nextBlock;

    public Block getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }
}
