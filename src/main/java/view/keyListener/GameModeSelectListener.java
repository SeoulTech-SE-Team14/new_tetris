package view.keyListener;

import java.awt.event.*;

import view.frame.GameFrame;
import view.frame.GameModeSelectFrame;
import view.frame.IndexFrame;
import view.frame.MultiGameFrame;

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
            case 0: frame.dispose(); new GameFrame(0); break; // 일반
            case 1: frame.dispose(); new GameFrame(1); break; // 아이템
            case 2: frame.dispose(); new MultiGameFrame(); break; // 듀얼
            case 3: frame.dispose(); new IndexFrame(); break;
        }
    }
}
