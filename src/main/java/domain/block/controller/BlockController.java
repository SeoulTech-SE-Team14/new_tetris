package domain.block.controller;

import domain.block.entity.Block;

public class BlockController {

    private static BlockController INSTANCE = new BlockController();

    public static BlockController getInstance() {
        return INSTANCE;
    }

    private int sumOfFitness;
    private Double[] previousProbability;

    private BlockController() {

        initRouletteSelection();
    }

    private void initRouletteSelection() {
        sumOfFitness = 0;
        previousProbability = new Double[3];
        //
    }
    
    public void rotate(Block block) {
        //
    }

    public Block getRandomBlock() {

        return null;
    }

    public Block getRandomItem() {

        return null;
    }

    public int getHeight(Block block) {
        return -1;
    }

    public int getWidth(Block block) {
        return -1;
    }

    public boolean isMovable(Block block) {
        return false;
    }

    public boolean isRotatable(Block block) {
        return false;
    }
}