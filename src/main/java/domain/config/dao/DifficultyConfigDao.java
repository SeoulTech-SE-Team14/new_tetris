package domain.config.dao;

import domain.config.entity.DifficultyConfig;
import global.dao.JsonDao;

public class DifficultyConfigDao extends JsonDao<DifficultyConfig> {

    private static DifficultyConfigDao INSTANCE = new DifficultyConfigDao();

    public static DifficultyConfigDao getInstance() {
        return INSTANCE;
    }


    private DifficultyConfigDao() {
        super(new DifficultyConfig());
    }
    

    public DifficultyConfig read() {
        return super.read(DifficultyConfig.class);
    }
}
