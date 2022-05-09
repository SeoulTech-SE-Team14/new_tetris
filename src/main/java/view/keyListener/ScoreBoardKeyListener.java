package view.keyListener;

import java.awt.event.*;

import view.frame.IndexFrame;
import view.frame.ScoreBoardFrame;

public class ScoreBoardKeyListener extends KeyAdapter {

    private ScoreBoardFrame frame;

    public ScoreBoardKeyListener(ScoreBoardFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_ENTER: frame.dispose(); new IndexFrame(); break;
        }
    }
    
}
