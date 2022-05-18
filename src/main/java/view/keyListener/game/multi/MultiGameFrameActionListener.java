package view.keyListener.game.multi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.frame.game.multi.MultiGameFrame;

public class MultiGameFrameActionListener implements ActionListener {

    private MultiGameFrame frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.isGameOver())
            frame.gameExit();
    }

    public MultiGameFrameActionListener(MultiGameFrame frame) {
        this.frame = frame;
    }
    
}
