package domain.config.constant.difficulty;

public enum HardDifficulty {
    
    IBLOCK(8),
    JBLOCK(10),
    LBLOCK(10),
    OBLOCK(10),
    SBLOCK(10),
    TBLOCK(10),
    ZBLOCK(10),
    ;
    
    private int fitness;

    HardDifficulty(int fitness) {
        this.fitness = fitness;
    }

    public int getFitness() {
        return fitness;
    }
}
