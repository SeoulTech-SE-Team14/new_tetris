package view.keyListener.game.multi;

import view.frame.game.multi.MultiGameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiGameTimeOutActionListener implements ActionListener {
    
    private MultiGameFrame frame;

    public MultiGameTimeOutActionListener(MultiGameFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.countDown();
    }
}
