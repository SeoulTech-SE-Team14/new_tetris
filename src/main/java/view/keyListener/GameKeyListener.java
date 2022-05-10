package view.keyListener;

import domain.board.controller.BoardController;
import domain.board.entity.Board;
import domain.config.constant.key.KeyType;
import domain.config.controller.KeyConfigController;

import java.awt.event.*;

public class GameKeyListener implements KeyListener {

    private Board player1;
    private Board player2;

    public GameKeyListener() {}
    public GameKeyListener(Board player1, Board player2) {
        this.player1 = player1;
        this.player2 = player2;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(BoardController.getInstance().isPause()) return ;
        if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_DOWN)) {
            BoardController.getInstance().moveDown(player1);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_LEFT)) {
            BoardController.getInstance().moveLeft(player1);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_RIGHT)) {
            BoardController.getInstance().moveRight(player1);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_ROTATE)) {
            BoardController.getInstance().rotate(player1);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE)) {
            BoardController.getInstance().moveDownAtOnce(player1);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_DOWN)) {
            BoardController.getInstance().moveDown(player2);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_LEFT)) {
            BoardController.getInstance().moveLeft(player2);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_RIGHT)) {
            BoardController.getInstance().moveRight(player2);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_ROTATE)) {
            BoardController.getInstance().rotate(player2);
        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE)) {
            BoardController.getInstance().moveDownAtOnce(player2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
