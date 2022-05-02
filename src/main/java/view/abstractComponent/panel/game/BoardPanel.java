package view.abstractComponent.panel.game;

import javax.swing.JPanel;

import domain.block.entity.Block;
import domain.board.entity.Board;

public class BoardPanel extends JPanel {
    
    private Board board;
    private Block currentBlock;


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Block getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(Block currentBlock) {
        this.currentBlock = currentBlock;
    }
}
