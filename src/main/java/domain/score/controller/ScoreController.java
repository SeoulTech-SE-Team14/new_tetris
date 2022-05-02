package domain.score.controller;

import domain.score.entity.Score;

public class ScoreController {

    private static ScoreController INSTANCE = new ScoreController();

    public static ScoreController getInstance() {
        return INSTANCE;
    }

    public void updateScore(Score score, double clock, int  deletedLines) {

    }
    
    public void setUsername(Score score, String username) {

    }

    public void setMode(Score score, String mode) {

    }

    public void setDifficulty(Score score, String difficulty) {
        
    }
}
