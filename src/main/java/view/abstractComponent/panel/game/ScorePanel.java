package view.abstractComponent.panel.game;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.score.controller.ScoreController;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;

public class ScorePanel extends JPanel {

    private static final String labelText = "점수";
    
    private final ScoreController scoreController = ScoreController.getInstance();
    private Score scoreObject;
    

    private JLabel label;
    private JLabel score;


    public ScorePanel() {
        scoreObject = new Score();

        GridLayout gl = new GridLayout(2, 1);
        setLayout(gl);
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        Font font = new Font("Noto sans", Font.PLAIN, 20);

        label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        label.setFont(font);

        score = new JLabel(scoreObject.getScore() + "");
        score.setForeground(Color.WHITE);
        score.setFont(font);

        add(label);
        add(score);
    }


    public Score getScoreObject() {
        return scoreObject;
    }

    public JLabel getLabel() {
        return label;
    }

    public JLabel getScore() {
        return score;
    }


    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        GridLayout gl = new GridLayout(10, 10);
        frame.setLayout(gl);

        frame.add(new ScorePanel());
        frame.setVisible(true);
    }
}
