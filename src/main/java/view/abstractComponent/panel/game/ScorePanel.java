package view.abstractComponent.panel.game;

import javax.swing.JPanel;

import domain.score.entity.Score;

public class ScorePanel extends JPanel {
    
    private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
