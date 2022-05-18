package view.keyListener.game;

import java.awt.event.*;

import view.frame.IndexFrame;
import view.frame.game.GameFrame;
import view.frame.game.GameModeSelectFrame;
import view.frame.game.multi.MultiGameFrame;
import view.frame.game.multi.MultiGameSelectFrame;

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
            case 0: frame.dispose(); new GameFrame(); break; // 일반
            case 1: frame.dispose(); new GameFrame("Item"); break; // 아이템
            case 2: frame.dispose(); new MultiGameSelectFrame(); break; // 듀얼
            case 3: frame.dispose(); new IndexFrame(); break;
        }
    }
}
