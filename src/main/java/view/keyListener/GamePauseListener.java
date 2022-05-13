package view.keyListener;

import java.awt.event.*;

import view.frame.GamePauseFrame;

public class GamePauseListener extends KeyAdapter {

    private GamePauseFrame frame;

    public GamePauseListener(GamePauseFrame frame) {
        this.frame = frame;
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
            case 0: frame.dispose(); break;
            case 1: frame.dispose(); break;
        }
    }
    
}
