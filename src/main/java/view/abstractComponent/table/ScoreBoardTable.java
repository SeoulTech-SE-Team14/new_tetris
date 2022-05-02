package view.abstractComponent.table;

import javax.swing.JTable;

import domain.score.entity.Score;

public class ScoreBoardTable extends JTable {
    
    Score[] scores;

    public Score[] getScores() {
        return scores;
    }

    public void setScores(Score[] scores) {
        this.scores = scores;
    }
}
