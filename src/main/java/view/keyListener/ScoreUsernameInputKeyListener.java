package view.keyListener;

import java.awt.event.*;

import javax.swing.JTextField;

import domain.score.controller.ScoreBoardController;
import domain.score.entity.Score;
import view.frame.ScoreBoardFrame;
import view.frame.ScoreUsernameInputFrame;

public class ScoreUsernameInputKeyListener extends KeyAdapter {

    private final ScoreBoardController scoreBoardController = ScoreBoardController.getInstance();

    private ScoreUsernameInputFrame frame;
    private JTextField input;
    private Score score;

    public ScoreUsernameInputKeyListener(ScoreUsernameInputFrame frame, JTextField input, Score score) {
        this.frame = frame;
        this.input = input;
        this.score = score;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_ENTER: 
                score.setUsername(input.getText());
                scoreBoardController.appendScoreBoard(score);
                frame.dispose();
                new ScoreBoardFrame(score.getTimestamp());
                break;
            default: break;
        }
    }
    
}
