package view.keyListener;

import java.awt.event.*;

import view.abstractComponent.panel.game.GamePanel;
import view.frame.GameFrame;
import view.frame.GamePauseFrame;

public class GamePauseListener extends KeyAdapter {

    private GamePauseFrame frame;
    private GameFrame gameFrame;

    public GamePauseListener(GamePauseFrame frame, GameFrame gameFrame) {
        this.frame = frame;
        this.gameFrame = gameFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP: frame.shiftUpFocusIndex(); break;
            case KeyEvent.VK_DOWN: frame.shiftDownFocusIndex(); break;
            case KeyEvent.VK_ENTER: setConfig(); break;
        }
    }

    public void setConfig() {

        switch (frame.getFocusIndex()) {
            case 0: frame.dispose(); gameFrame.getGamePanel().restart(); break;
            case 1: frame.dispose(); gameFrame.gameExit();  break;
        }
    }
    
}
