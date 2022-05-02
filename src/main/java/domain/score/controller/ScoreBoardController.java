package domain.score.controller;

import domain.score.dao.ScoreBoardDao;
import domain.score.entity.Score;

public class ScoreBoardController {

    private static ScoreBoardController INSTANCE = new ScoreBoardController();

    public static ScoreBoardController getInstance() {
        return INSTANCE;
    }

    private ScoreBoardDao scoreDao = ScoreBoardDao.getInstance();

    public Score[] getScoreBoard() {
        return scoreDao.read();
    }

    // 상위 15개만 생성
    // 15개 이상이면 가장 스코어가 낮은 것을 지우고 현재 점수를 추가하고 sort
    public void appendScoreBoard(Score score) {
        //
    }


}
