package view.keyListener;

import domain.board.controller.BoardController;
import domain.config.constant.key.KeyType;
import domain.config.controller.KeyConfigController;
import view.abstractComponent.panel.game.GamePanel;
import view.frame.GameFrame;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class GameKeyListener implements KeyListener {

    private GameFrame frame;
    private GamePanel player1;
    private GamePanel player2;

    private static final int INIT_INTERVAL = 1000;

    public GameKeyListener() {}
    public GameKeyListener(GameFrame frame, GamePanel player1) {
        this.frame = frame;
        this.player1 = player1;
        frame.addKeyListener(this);
    }
    public GameKeyListener(GameFrame frame, GamePanel player1, GamePanel player2) {
        this.frame = frame;
        this.player1 = player1;
        this.player2 = player2;
        frame.addKeyListener(this);
    }
    private void update(int keyCode, GamePanel player) {
        if(BoardController.getInstance().isPause()) return ;
        if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_DOWN)) {
            BoardController.getInstance().moveDown(player.getBoardPanel().getBoard());
            List<Integer> delete = BoardController.getInstance().findFullLine(player.getBoardPanel().getBoard());
            if(!delete.isEmpty()) {
                BoardController.getInstance().deleteFullLine(player.getBoardPanel().getBoard(), delete);
                // effect
            }
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_LEFT)) {
            BoardController.getInstance().moveLeft(player.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_RIGHT)) {
            BoardController.getInstance().moveRight(player.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_ROTATE)) {
            BoardController.getInstance().rotate(player.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE)) {
            BoardController.getInstance().moveDownAtOnce(player.getBoardPanel().getBoard());
            List<Integer> delete = BoardController.getInstance().findFullLine(player.getBoardPanel().getBoard());
            if(!delete.isEmpty()) {
                BoardController.getInstance().deleteFullLine(player.getBoardPanel().getBoard(), delete);
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(player1 != null) {
            update(e.getKeyCode(), player1);
        }
        if(player2 != null) {
            update(e.getKeyCode(), player2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
