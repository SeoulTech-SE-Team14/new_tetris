package view.keyListener.game.multi;

import view.frame.game.GameModeSelectFrame;
import view.frame.game.multi.MultiGameFrame;
import view.frame.game.multi.MultiGameSelectFrame;

import java.awt.event.*;

public class MultiGameSelectListener  extends KeyAdapter {
    
    private MultiGameSelectFrame frame;

    public MultiGameSelectListener(MultiGameSelectFrame frame) {
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
            case 0: frame.dispose(); new MultiGameFrame(); break; // 일반
            case 1: frame.dispose(); new MultiGameFrame("Item"); break; // 아이템
            case 2: frame.dispose(); new MultiGameFrame(30); break; // 듀얼
            case 3: frame.dispose(); new GameModeSelectFrame(); break;
        }
    }
}
