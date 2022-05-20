package view.keyListener;

import java.awt.event.*;

import view.frame.IndexFrame;
import view.frame.config.ConfigFrame;
import view.frame.game.GameFrame;
import view.frame.game.multi.MultiGameSelectFrame;
import view.frame.score.ScoreBoardFrame;

public class IndexKeyListener extends KeyAdapter {
    
    private IndexFrame frame;

    public IndexKeyListener(IndexFrame frame) {
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
            case 1: frame.dispose(); new GameFrame("Item"); break;
            case 2: frame.dispose(); new MultiGameSelectFrame(); break;
            case 3: frame.dispose(); new ScoreBoardFrame(); break;
            case 4: frame.dispose(); new ConfigFrame(); break;
            case 5: frame.dispose(); System.exit(0); break;
        }
    }
}
