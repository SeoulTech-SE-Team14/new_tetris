package domain.score.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.score.dao.ScoreBoardDao;
import domain.score.entity.Score;

public class ScoreBoardController {

    private static ScoreBoardController INSTANCE = new ScoreBoardController();

    public static ScoreBoardController getInstance() {
        return INSTANCE;
    }

    private ScoreBoardDao scoreDao = ScoreBoardDao.getInstance();


    public List<Score> getScoreBoard() {
        return scoreDao.read();
    }

    public List<Score> appendScoreBoard(Score score) {
        List<Score> scores = scoreDao.read();

        if (scores.size() == 15)
            scores.remove(14);

        scores.add(score);
        Collections.sort(scores);

        scoreDao.write(scores);

        return scores;
    }

    public void removeAll() {
        List<Score> scores = new ArrayList<>();
        scoreDao.write(scores);
    }
}
