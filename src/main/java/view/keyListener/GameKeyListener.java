package view.keyListener;

import domain.board.controller.BoardController;
import domain.config.constant.key.KeyType;
import domain.config.controller.KeyConfigController;

import java.awt.event.*;

public class GameKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(BoardController.getInstance().isPause()) return ;
        if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_DOWN)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_LEFT)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_RIGHT)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_ROTATE)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_DOWN)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_LEFT)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_RIGHT)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_ROTATE)) {

        } else if(e.getKeyCode() == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE)) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
