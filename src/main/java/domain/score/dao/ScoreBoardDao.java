package domain.score.dao;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import domain.score.entity.Score;
import global.dao.JsonDao;

public class ScoreBoardDao extends JsonDao<List<Score>> {

    private static ScoreBoardDao INSTANCE = new ScoreBoardDao();

    public static ScoreBoardDao getInstance() {
        return INSTANCE;
    }

    private ScoreBoardDao() {
        super(new ArrayList<Score>());
    }
    
    public List<Score> read() {
        return super.read(new TypeReference<List<Score>>(){});
    }
}
