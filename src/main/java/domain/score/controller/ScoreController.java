package domain.score.controller;

import domain.config.entity.DifficultyConfig;
import domain.score.entity.Score;

public class ScoreController {

    private static ScoreController INSTANCE = new ScoreController();

    public static ScoreController getInstance() {
        return INSTANCE;
    }

    public void updateScore(Score score, double clock, int  deletedLines) {
        long res = score.getScore();
        String diff = score.getDifficulty();

        double weight = 0.0;
        if (diff.equals("Easy"))
            weight = 1000.0;
        else if (diff.equals("Noraml"))
            weight = 1500.0;
        else if (diff.equals("Hard"))
            weight = 2000.0;
        else
            weight = 1.0;

        if (deletedLines != 0)
            res += (long) (weight * deletedLines * 4 / clock);
        else
            res += (long) (weight / clock);

        score.setScore(res);
    }
    
    public void setUsername(Score score, String username) {
        score.setUsername(username);
    }

    public void setMode(Score score, String mode) {
        score.setMode(mode);
    }

    public void setDifficulty(Score score, String difficulty) {
        score.setDifficulty(difficulty);
    }

    public void setDifficulty(Score score, DifficultyConfig difficultyConfig) {
        setDifficulty(score, difficultyConfig.getDifficulty());
    }
}
