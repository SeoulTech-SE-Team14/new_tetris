package domain.score.dao;

import domain.score.entity.Score;
import global.dao.JsonDao;

public class ScoreBoardDao extends JsonDao<Score[]> {

    private static ScoreBoardDao INSTANCE = new ScoreBoardDao();

    public static ScoreBoardDao getInstance() {
        return INSTANCE;
    }

    private ScoreBoardDao() {
        super(new Score[]{});
    }
    
    public Score[] read() {
        return super.read(Score[].class);
    }
}
