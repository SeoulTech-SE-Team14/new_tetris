package view.keyListener.game.multi;

import view.frame.IndexFrame;
import view.frame.game.multi.MultiGameOverFrame;

import java.awt.event.*;

public class MultiGameOverKeyListener extends KeyAdapter {
    
    private MultiGameOverFrame frame;

    public MultiGameOverKeyListener(MultiGameOverFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_ENTER: 
                frame.dispose();
                new IndexFrame();
                break;
            default: break;
        }
    }
}
