package view.keyListener.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.frame.game.GameFrame;

public class GameFrameActionListener implements ActionListener {
    
    private GameFrame gameFrame;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameFrame.isGameOver())
            gameFrame.gameExit();
        
    }

    public GameFrameActionListener(GameFrame frame) {
        gameFrame = frame;
    }
}
