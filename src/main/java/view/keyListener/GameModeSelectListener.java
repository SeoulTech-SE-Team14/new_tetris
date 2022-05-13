package view.keyListener;

import java.awt.event.*;

import view.frame.GameFrame;
import view.frame.GameModeSelectFrame;
import view.frame.IndexFrame;

public class GameModeSelectListener extends KeyAdapter {
    
    private GameModeSelectFrame frame;

    public GameModeSelectListener(GameModeSelectFrame frame) {
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
            case 0: frame.dispose(); new GameFrame(); break;
            case 1: frame.dispose(); new GameFrame(); break;
            case 2: frame.dispose(); new GameFrame(); break;
            case 3: frame.dispose(); new IndexFrame(); break;
        }
    }
}
