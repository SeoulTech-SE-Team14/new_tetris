package view.keyListener.game.multi;

import java.awt.event.*;

import domain.config.constant.key.KeyType;
import domain.config.controller.KeyConfigController;
import domain.config.entity.KeyConfig;
import view.abstractComponent.panel.game.GamePanel;
import view.frame.game.multi.MultiGameFrame;
import view.frame.game.multi.MultiGamePauseFrame;

public class MultiGameKeyListener extends KeyAdapter {
    
    private MultiGameFrame frame;
    private GamePanel p1GamePanel;
    private GamePanel p2GamePanel;

    private KeyConfigController keyConfigController = KeyConfigController.getInstance();
    private KeyConfig keyConfig;

    public MultiGameKeyListener(MultiGameFrame frame) {
        this.frame = frame;
        p1GamePanel = frame.getP1GamePanel();
        p2GamePanel = frame.getP2GamePanel();

        keyConfig = keyConfigController.getCurrentConfig();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (p1GamePanel.isGameOver() || p2GamePanel.isGameOver())
            frame.gameExit();
        if (p1GamePanel.isPause()) return;

        int keyCode = e.getKeyCode();

        if (keyCode == keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN))
            p1GamePanel.moveDown();
        else if (keyCode == keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE))
            p1GamePanel.moveDownAtOnce();
        else if (keyCode == keyConfig.get(KeyType.P1_BLOCK_MOVE_LEFT))
            p1GamePanel.moveLeft();
        else if (keyCode == keyConfig.get(KeyType.P1_BLOCK_MOVE_RIGHT))
            p1GamePanel.moveRight();
        else if (keyCode == keyConfig.get(KeyType.P1_BLOCK_ROTATE))
            p1GamePanel.rotate();
        else if (keyCode == KeyEvent.VK_ESCAPE) {
            frame.pause();
            new MultiGamePauseFrame(frame);
        }

        else if (keyCode == keyConfig.get(KeyType.P2_BLOCK_MOVE_DOWN))
            p2GamePanel.moveDown();
        else if (keyCode == keyConfig.get(KeyType.P2_BLOCK_MOVE_DOWN_AT_ONCE))
            p2GamePanel.moveDownAtOnce();
        else if (keyCode == keyConfig.get(KeyType.P2_BLOCK_MOVE_LEFT))
            p2GamePanel.moveLeft();
        else if (keyCode == keyConfig.get(KeyType.P2_BLOCK_MOVE_RIGHT))
            p2GamePanel.moveRight();
        else if (keyCode == keyConfig.get(KeyType.P2_BLOCK_ROTATE))
            p2GamePanel.rotate();
    }
}
