package view.keyListener.game.multi;

import java.awt.event.*;

import view.frame.game.multi.MultiGameFrame;
import view.frame.game.multi.MultiGamePauseFrame;

public class MultiGamePauseListener extends KeyAdapter {
    
    private MultiGamePauseFrame frame;
    private MultiGameFrame gameFrame;

    public MultiGamePauseListener(MultiGamePauseFrame frame, MultiGameFrame gameFrame) {
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
            case 0: frame.dispose(); gameFrame.restart(); break;
            case 1: frame.dispose(); gameFrame.gameExit();  break;
        }
    }
}
