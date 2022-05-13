package view.keyListener;

import java.awt.event.*;
import java.util.List;

import domain.board.controller.BoardController;
import domain.config.controller.KeyConfigController;

import domain.config.constant.key.KeyType;

import view.abstractComponent.panel.game.GamePanel;

public class GameKeyListener implements KeyListener {
    private GamePanel player1;
    private GamePanel player2;

    public GameKeyListener() {}
    public GameKeyListener(GamePanel player1) {
        this.player1 = player1;
    }
    public GameKeyListener(GamePanel player1, GamePanel player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if(BoardController.getInstance().isPause()) return ;
        int keyCode = e.getKeyCode();

        if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_DOWN)) {
            BoardController.getInstance().moveDown(player1.getBoardPanel().getBoard());
            List<Integer> delete = BoardController.getInstance().findFullLine(player1.getBoardPanel().getBoard());
            if(!delete.isEmpty()) {
                BoardController.getInstance().deleteFullLine(player1.getBoardPanel().getBoard(), delete);
            }
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_LEFT)) {
            BoardController.getInstance().moveLeft(player1.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_RIGHT)) {
            BoardController.getInstance().moveRight(player1.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_ROTATE)) {
            BoardController.getInstance().rotate(player1.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE)) {
            BoardController.getInstance().moveDownAtOnce(player1.getBoardPanel().getBoard());
            List<Integer> delete = BoardController.getInstance().findFullLine(player1.getBoardPanel().getBoard());
            if(!delete.isEmpty()) {
                BoardController.getInstance().deleteFullLine(player1.getBoardPanel().getBoard(), delete);
            }
        }

        if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_DOWN)) {
            BoardController.getInstance().moveDown(player2.getBoardPanel().getBoard());
            List<Integer> delete = BoardController.getInstance().findFullLine(player2.getBoardPanel().getBoard());
            if(!delete.isEmpty()) {
                BoardController.getInstance().deleteFullLine(player2.getBoardPanel().getBoard(), delete);
            }
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_LEFT)) {
            BoardController.getInstance().moveLeft(player2.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_RIGHT)) {
            BoardController.getInstance().moveRight(player2.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_ROTATE)) {
            BoardController.getInstance().rotate(player2.getBoardPanel().getBoard());
        } else if(keyCode == KeyConfigController.getInstance().getCurrentConfig().get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE)) {
            BoardController.getInstance().moveDownAtOnce(player2.getBoardPanel().getBoard());
            List<Integer> delete = BoardController.getInstance().findFullLine(player2.getBoardPanel().getBoard());
            if(!delete.isEmpty()) {
                BoardController.getInstance().deleteFullLine(player2.getBoardPanel().getBoard(), delete);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
