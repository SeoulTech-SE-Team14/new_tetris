package view.keyListener.game.single;

import java.awt.event.*;

import domain.config.constant.key.KeyType;
import domain.config.controller.KeyConfigController;
import domain.config.entity.KeyConfig;
import view.abstractComponent.panel.game.GamePanel;
import view.frame.game.GameFrame;
import view.frame.game.GamePauseFrame;

public class SingleGameKeyListener extends KeyAdapter {

    private GameFrame gameFrame;
    private GamePanel gamePanel;

    private KeyConfigController keyConfigController = KeyConfigController.getInstance();
    private KeyConfig keyConfig;

    public SingleGameKeyListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.gamePanel = gameFrame.getGamePanel();

        keyConfig = keyConfigController.getCurrentConfig();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gamePanel.isGameOver())
            gameFrame.gameExit();
        if (gamePanel.isPause()) return;

        int keyCode = e.getKeyCode();

        if (keyCode == keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN))
            gamePanel.moveDown();
        else if (keyCode == keyConfig.get(KeyType.P1_BLOCK_MOVE_DOWN_AT_ONCE))
            gamePanel.moveDownAtOnce();
        else if (keyCode == keyConfig.get(KeyType.P1_BLOCK_MOVE_LEFT))
            gamePanel.moveLeft();
        else if (keyCode == keyConfig.get(KeyType.P1_BLOCK_MOVE_RIGHT))
            gamePanel.moveRight();
        else if (keyCode == keyConfig.get(KeyType.P1_BLOCK_ROTATE))
            gamePanel.rotate();
        else if (keyCode == KeyEvent.VK_ESCAPE) {
            gamePanel.pause();
            new GamePauseFrame(gameFrame);
        }
    }
    
}
