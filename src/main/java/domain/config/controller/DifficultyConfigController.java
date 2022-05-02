package domain.config.controller;

import domain.config.dao.DifficultyConfigDao;
import domain.config.entity.DifficultyConfig;

public class DifficultyConfigController {

    private static DifficultyConfigController INSTANCE = new DifficultyConfigController();

    public static DifficultyConfigController getInstance() {
        return INSTANCE;
    }
    
    private final DifficultyConfigDao difficultyConfigDao = DifficultyConfigDao.getInstance();

    public DifficultyConfig getEasy() {
        return new DifficultyConfig();
    }

    public DifficultyConfig getNormal() {
        return new DifficultyConfig();
    }

    public DifficultyConfig getHard() {
        return new DifficultyConfig();
    }

    public DifficultyConfig getCurrentConfig() {
        return difficultyConfigDao.read();
    }

    public void update(DifficultyConfig object) {
        difficultyConfigDao.write(object);
    }
}
