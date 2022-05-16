package view.abstractComponent.panel.game;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.config.controller.DifficultyConfigController;
import domain.config.entity.DifficultyConfig;
import domain.score.controller.ScoreController;
import domain.score.entity.Score;
import view.abstractComponent.frame.DefaultFrame;

public class ScorePanel extends JPanel {

    private static final String labelText = "점수";
    
    private final ScoreController scoreController = ScoreController.getInstance();
    private final DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();
    
    private DifficultyConfig difficultyConfig;
    private Score scoreObject;
    

    private JLabel label;
    private JLabel score;


    public ScorePanel() {
        scoreObject = new Score();

        difficultyConfig = difficultyConfigController.getCurrentConfig();
        scoreObject.setDifficulty(difficultyConfig.getDifficulty());

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

    public void updateScore(double clock, int deletedLines) {
        scoreController.updateScore(scoreObject, clock, deletedLines);
        score.setText(scoreObject.getScore() + "");
    }

    public void updateScore(double clock, int deletedLines, int times) {
        scoreController.updateScore(scoreObject, clock, deletedLines, times);
        score.setText(scoreObject.getScore() + "");
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

    public void reset() {
        scoreObject = new Score();

        difficultyConfig = difficultyConfigController.getCurrentConfig();
        scoreObject.setDifficulty(difficultyConfig.getDifficulty());

        score.setText(scoreObject.getScore() + "");
    }

    public void setMode(String mode) {
        scoreObject.setMode(mode);
    }

    public void setItemMode() {
        setMode("Item");
    }


    public static void main(String[] args) {
        DefaultFrame frame = new DefaultFrame();

        GridLayout gl = new GridLayout(10, 10);
        frame.setLayout(gl);

        frame.add(new ScorePanel());
        frame.setVisible(true);
    }
}
