package domain.config.entity;

public class DifficultyConfig {

    private static String DEFAULT_DIFFICULTY = "Normal";

    private static int DEFAULT_IBLOCK_FITNESS = 10;
    private static int DEFAULT_JBLOCK_FITNESS = 10;
    private static int DEFAULT_LBLOCK_FITNESS = 10;
    private static int DEFAULT_OBLOCK_FITNESS = 10;
    private static int DEFAULT_SBLOCK_FITNESS = 10;
    private static int DEFAULT_TBLOCK_FITNESS = 10;
    private static int DEFAULT_ZBLOCK_FITNESS = 10;

    private static int BLOCK_COUNT = 7;
    

    private String difficulty;

    private int iBlockFitness;
    private int jBlockFitness;
    private int lBlockFitness;
    private int oBlockFitness;
    private int sBlockFitness;
    private int tBlockFitness;
    private int zBlockFitness;

    private int sumOfFitness;
    private double[] previousProbability;


    public DifficultyConfig(String difficulty, int iBlockFitness, int jBlockFitness, int lBlockFitness, int oBlockFitness,
            int sBlockFitness, int tBlockFitness, int zBlockFitness) {
            
        this.difficulty = difficulty;

        this.iBlockFitness = iBlockFitness;
        this.jBlockFitness = jBlockFitness;
        this.lBlockFitness = lBlockFitness;
        this.oBlockFitness = oBlockFitness;
        this.sBlockFitness = sBlockFitness;
        this.tBlockFitness = tBlockFitness;
        this.zBlockFitness = zBlockFitness;

        initSumOfFitness();
        initPreviousProbability();
    }

    public DifficultyConfig() {
        this(DEFAULT_DIFFICULTY, DEFAULT_IBLOCK_FITNESS, DEFAULT_JBLOCK_FITNESS, DEFAULT_LBLOCK_FITNESS, DEFAULT_OBLOCK_FITNESS, 
            DEFAULT_SBLOCK_FITNESS, DEFAULT_TBLOCK_FITNESS, DEFAULT_ZBLOCK_FITNESS);
    }


    private void initSumOfFitness() {
        sumOfFitness = 0;

        sumOfFitness += iBlockFitness;
        sumOfFitness += jBlockFitness;
        sumOfFitness += lBlockFitness;
        sumOfFitness += oBlockFitness;
        sumOfFitness += sBlockFitness;
        sumOfFitness += tBlockFitness;
        sumOfFitness += zBlockFitness;
    }

    private void initPreviousProbability() {
        previousProbability = new double[BLOCK_COUNT];

        previousProbability[0] = (double) iBlockFitness / (double) sumOfFitness;
        previousProbability[1] = previousProbability[0] + (double) jBlockFitness / (double) sumOfFitness;
        previousProbability[2] = previousProbability[1] + (double) lBlockFitness / (double) sumOfFitness;
        previousProbability[3] = previousProbability[2] + (double) oBlockFitness / (double) sumOfFitness;
        previousProbability[4] = previousProbability[3] + (double) sBlockFitness / (double) sumOfFitness;
        previousProbability[5] = previousProbability[4] + (double) tBlockFitness / (double) sumOfFitness;
        previousProbability[6] = previousProbability[5] + (double) zBlockFitness / (double) sumOfFitness;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public double[] getPreviousProbability() {
        return previousProbability;
    }

    public int getSumOfFitness() {
        return sumOfFitness;
    }
}
