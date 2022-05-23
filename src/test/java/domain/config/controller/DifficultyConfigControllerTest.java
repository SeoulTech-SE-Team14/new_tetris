package domain.config.controller;

import domain.config.constant.difficulty.EasyDifficulty;
import domain.config.constant.difficulty.HardDifficulty;
import domain.config.entity.DifficultyConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifficultyConfigControllerTest {

    @Test
    void getEasy() {
        DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();
        DifficultyConfig difficultyConfig = difficultyConfigController.getEasy();
        double[] expected = new double[7];
        double sumOfFitness = EasyDifficulty.IBLOCK.getFitness()
                +EasyDifficulty.JBLOCK.getFitness()
                +EasyDifficulty.LBLOCK.getFitness()
                +EasyDifficulty.OBLOCK.getFitness()
                +EasyDifficulty.SBLOCK.getFitness()
                +EasyDifficulty.TBLOCK.getFitness()
                +EasyDifficulty.ZBLOCK.getFitness();
        expected[0]+=EasyDifficulty.IBLOCK.getFitness();
        expected[1]+=expected[0] + EasyDifficulty.JBLOCK.getFitness();
        expected[2]+=expected[1] + EasyDifficulty.LBLOCK.getFitness();
        expected[3]+=expected[2] + EasyDifficulty.OBLOCK.getFitness();
        expected[4]+=expected[3] + EasyDifficulty.SBLOCK.getFitness();
        expected[5]+=expected[4] + EasyDifficulty.TBLOCK.getFitness();
        expected[6]+=expected[5] + EasyDifficulty.ZBLOCK.getFitness();
        for(int i=0;i<7;i++){
            expected[i]/=sumOfFitness;
        }

        assertEquals(difficultyConfig.getDifficulty(), "Easy");
        assertEquals(difficultyConfig.getSumOfFitness(), (int)sumOfFitness);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[0]-expected[0])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[1]-expected[1])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[2]-expected[2])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[3]-expected[3])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[4]-expected[4])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[5]-expected[5])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[6]-expected[6])<=0.0000001);

    }

    @Test
    void getNormal() {
        DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();
        DifficultyConfig difficultyConfig = difficultyConfigController.getNormal();
        double[] expected = {10, 20, 30, 40, 50, 60, 70};
        for(int i=0;i<7;i++){
            expected[i]/=70;
        }

        assertEquals(difficultyConfig.getDifficulty(), "Normal");
        assertEquals(difficultyConfig.getSumOfFitness(), 70);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[0]-expected[0])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[1]-expected[1])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[2]-expected[2])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[3]-expected[3])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[4]-expected[4])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[5]-expected[5])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[6]-expected[6])<=0.0000001);

    }

    @Test
    void getHard() {
        DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();
        DifficultyConfig difficultyConfig = difficultyConfigController.getHard();
        double[] expected = new double[7];
        double sumOfFitness = HardDifficulty.IBLOCK.getFitness()
                +HardDifficulty.JBLOCK.getFitness()
                +HardDifficulty.LBLOCK.getFitness()
                +HardDifficulty.OBLOCK.getFitness()
                +HardDifficulty.SBLOCK.getFitness()
                +HardDifficulty.TBLOCK.getFitness()
                +HardDifficulty.ZBLOCK.getFitness();
        expected[0]+=HardDifficulty.IBLOCK.getFitness();
        expected[1]+=expected[0] + HardDifficulty.JBLOCK.getFitness();
        expected[2]+=expected[1] + HardDifficulty.LBLOCK.getFitness();
        expected[3]+=expected[2] + HardDifficulty.OBLOCK.getFitness();
        expected[4]+=expected[3] + HardDifficulty.SBLOCK.getFitness();
        expected[5]+=expected[4] + HardDifficulty.TBLOCK.getFitness();
        expected[6]+=expected[5] + HardDifficulty.ZBLOCK.getFitness();
        for(int i=0;i<7;i++){
            expected[i]/=sumOfFitness;
        }

        assertEquals(difficultyConfig.getDifficulty(), "Hard");
        assertEquals(difficultyConfig.getSumOfFitness(), (int)sumOfFitness);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[0]-expected[0])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[1]-expected[1])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[2]-expected[2])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[3]-expected[3])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[4]-expected[4])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[5]-expected[5])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[6]-expected[6])<=0.0000001);

    }

    @Test
    void getCurrentConfig() {
        DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();
        DifficultyConfig difficultyConfig = difficultyConfigController.getNormal();
        double[] expected = {10, 20, 30, 40, 50, 60, 70};
        for(int i=0;i<7;i++){
            expected[i]/=70;
        }

        assertEquals(difficultyConfig.getDifficulty(), "Normal");
        assertEquals(difficultyConfig.getSumOfFitness(), 70);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[0]-expected[0])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[1]-expected[1])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[2]-expected[2])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[3]-expected[3])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[4]-expected[4])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[5]-expected[5])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[6]-expected[6])<=0.0000001);

        difficultyConfigController.update(difficultyConfigController.getHard());
        difficultyConfig = difficultyConfigController.getCurrentConfig();

        double[] expected1 = {8, 18, 28, 38, 48 ,58 ,68};
        for(int i=0;i<7;i++){
            expected1[i]/=68;
        }

        assertEquals(difficultyConfig.getDifficulty(), "Hard");
        assertEquals(difficultyConfig.getSumOfFitness(), 68);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[0]-expected1[0])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[1]-expected1[1])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[2]-expected1[2])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[3]-expected1[3])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[4]-expected1[4])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[5]-expected1[5])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[6]-expected1[6])<=0.0000001);
    }

    @Test
    void update() {
        DifficultyConfigController difficultyConfigController = DifficultyConfigController.getInstance();
        DifficultyConfig difficultyConfig = difficultyConfigController.getNormal();
        double[] expected = {10, 20, 30, 40, 50, 60, 70};
        for(int i=0;i<7;i++){
            expected[i]/=70;
        }

        assertEquals(difficultyConfig.getDifficulty(), "Normal");
        assertEquals(difficultyConfig.getSumOfFitness(), 70);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[0]-expected[0])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[1]-expected[1])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[2]-expected[2])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[3]-expected[3])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[4]-expected[4])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[5]-expected[5])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[6]-expected[6])<=0.0000001);

        difficultyConfigController.update(difficultyConfigController.getHard());
        difficultyConfig = difficultyConfigController.getCurrentConfig();

        double[] expected1 = {8, 18, 28, 38, 48 ,58 ,68};
        for(int i=0;i<7;i++){
            expected1[i]/=68;
        }

        assertEquals(difficultyConfig.getDifficulty(), "Hard");
        assertEquals(difficultyConfig.getSumOfFitness(), 68);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[0]-expected1[0])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[1]-expected1[1])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[2]-expected1[2])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[3]-expected1[3])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[4]-expected1[4])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[5]-expected1[5])<=0.0000001);
        assertTrue(Math.abs(difficultyConfig.getPreviousProbability()[6]-expected1[6])<=0.0000001);
    }
}