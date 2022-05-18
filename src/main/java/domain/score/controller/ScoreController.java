package domain.score.controller;

import domain.config.entity.DifficultyConfig;
import domain.score.entity.Score;

public class ScoreController {

    private static ScoreController INSTANCE = new ScoreController();

    public static ScoreController getInstance() {
        return INSTANCE;
    }

    private long calculateScore(Score score, double clock, int  deletedLines, int times) {
        long res = 0;
        String diff = score.getDifficulty();

        double weight = 0.0;
        if (diff.equals("Easy"))
            weight = 1000.0;
        else if (diff.equals("Normal"))
            weight = 2000.0;
        else if (diff.equals("Hard"))
            weight = 3000.0;
        else
            weight = 1.0;

        if (deletedLines != 0)
            res = (long) (weight * deletedLines * 4 / clock) * times;
        else
            res = (long) (weight / clock) * times;
        return res;
    }
    public void updateScore(Score score, double clock, int deletedLines) {
        updateScore(score, clock, deletedLines, 1);
    }

    public void updateScore(Score score, double clock, int  deletedLines, int times) {
        long cur = score.getScore();
        long res = calculateScore(score, clock, deletedLines, times);
        score.setScore(cur + res);
    }
    
    public void setUsername(Score score, String username) {
        score.setUsername(username);
    }

    // 사용하지 않음
    public void setMode(Score score, String mode) {
        score.setMode(mode);
    }

    public void setDifficulty(Score score, String difficulty) {
        score.setDifficulty(difficulty);
    }

    // 사용하지 않음
    public void setDifficulty(Score score, DifficultyConfig difficultyConfig) {
        setDifficulty(score, difficultyConfig.getDifficulty());
    }
}
