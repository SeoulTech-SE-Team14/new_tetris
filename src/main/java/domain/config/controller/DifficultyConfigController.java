package domain.config.controller;

import domain.config.constant.difficulty.EasyDifficulty;
import domain.config.constant.difficulty.HardDifficulty;
import domain.config.dao.DifficultyConfigDao;
import domain.config.entity.DifficultyConfig;

public class DifficultyConfigController {

    private static DifficultyConfigController INSTANCE = new DifficultyConfigController();

    public static DifficultyConfigController getInstance() {
        return INSTANCE;
    }

    
    private final DifficultyConfigDao difficultyConfigDao = DifficultyConfigDao.getInstance();


    private DifficultyConfigController() {

    }


    public DifficultyConfig getDefault() {
        return new DifficultyConfig();
    }

    public DifficultyConfig getEasy() {
        int iBlockFitness = EasyDifficulty.IBLOCK.getFitness();
        int jBlockFitness = EasyDifficulty.JBLOCK.getFitness();
        int lBlockFitness = EasyDifficulty.LBLOCK.getFitness();
        int oBlockFitness = EasyDifficulty.OBLOCK.getFitness();
        int sBlockFitness = EasyDifficulty.SBLOCK.getFitness();
        int tBlockFitness = EasyDifficulty.TBLOCK.getFitness();
        int zBlockFitness = EasyDifficulty.ZBLOCK.getFitness();

        return new DifficultyConfig("Easy", iBlockFitness, jBlockFitness, lBlockFitness, 
            oBlockFitness, sBlockFitness, tBlockFitness, zBlockFitness);
    }

    public DifficultyConfig getNormal() {
        return getDefault();
    }

    public DifficultyConfig getHard() {
        int iBlockFitness = HardDifficulty.IBLOCK.getFitness();
        int jBlockFitness = HardDifficulty.JBLOCK.getFitness();
        int lBlockFitness = HardDifficulty.LBLOCK.getFitness();
        int oBlockFitness = HardDifficulty.OBLOCK.getFitness();
        int sBlockFitness = HardDifficulty.SBLOCK.getFitness();
        int tBlockFitness = HardDifficulty.TBLOCK.getFitness();
        int zBlockFitness = HardDifficulty.ZBLOCK.getFitness();

        return new DifficultyConfig("Hard", iBlockFitness, jBlockFitness, lBlockFitness, 
            oBlockFitness, sBlockFitness, tBlockFitness, zBlockFitness);
    }

    public DifficultyConfig getCurrentConfig() {
        return difficultyConfigDao.read();
    }

    public void update(DifficultyConfig object) {
        difficultyConfigDao.write(object);
    }
}
