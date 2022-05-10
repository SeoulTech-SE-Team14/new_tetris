package domain.block.controller;

import domain.block.entity.Block;
import domain.block.entity.itemBlock.*;
import domain.block.entity.tetromino.*;
import domain.config.controller.BlockColorConfigController;
import domain.config.controller.DifficultyConfigController;
import domain.config.entity.BlockColorConfig;
import domain.config.entity.DifficultyConfig;

import java.awt.*;

public class BlockController {

    private static BlockController INSTANCE = new BlockController();
    private static DifficultyConfig difficultyConfig = DifficultyConfigController.getInstance().getCurrentConfig();
    private static BlockColorConfigController blockController = BlockColorConfigController.getInstance();

    public static BlockController getInstance() {
        return INSTANCE;
    }

    private BlockController() {

        initRouletteSelection();
    }

    private void initRouletteSelection() {
    }
    
    public Block rotate(Block block) {
        if(block.getShape().length == 0){
            return block;
        }

        int row = block.getShape().length;
        int col = block.getShape().length;

        int[][] blockShape = new int[col][row];

            for(int r=0;r<row;r++){
                for(int c=0;c<col;c++){
                    blockShape[c][r] = block.getShape()[row-r-1][c];
                }
            }
        block.setShape(blockShape);
        return block;
    }
    public int getBlockColor(Block block) {

        if(block instanceof IBlock) {
            return blockController.getDefault().getiBlockColor();
        } else if(block instanceof JBlock) {
            return blockController.getDefault().getjBlockColor();
        }  else if(block instanceof LBlock) {
            return blockController.getDefault().getlBlockColor();
        } else if(block instanceof OBlock) {
            return blockController.getDefault().getoBlockColor();
        } else if(block instanceof SBlock) {
            return blockController.getDefault().getsBlockColor();
        } else if(block instanceof TBlock) {
            return blockController.getDefault().gettBlockColor();
        } else if(block instanceof ZBlock) {
            return blockController.getDefault().getzBlockColor();
        } else {
            return 0xffffff;
        }
    }
    public Block getRandomBlock() {
        double[] previousProbability = difficultyConfig.getPreviousProbability();
        int sumOfFitness = difficultyConfig.getSumOfFitness();
        int seed = (int)(Math.random()*sumOfFitness);

        double threshold = (double)seed / sumOfFitness;
        if(threshold <= previousProbability[0]){
            return new IBlock();
        }else if(threshold <= previousProbability[1]){
            return new JBlock();
        }else if(threshold <= previousProbability[2]){
            return new LBlock();
        }else if(threshold <= previousProbability[3] ){
            return new OBlock();
        }else if(threshold <= previousProbability[4]){
            return new SBlock();
        }else if(threshold <= previousProbability[5]){
            return new TBlock();
        }else if(threshold <= previousProbability[6]){
            return new ZBlock();
        }else{
            //return null;
            return new IBlock();
        }
    }

    public Block getRandomItem() {
        int seed = (int)(Math.random()*5);

        switch(seed){
            case 0:
                return new BombItem();
            case 1:
                return new BonusScoreItem();
            case 2:
                return new DrillItem();
            case 3:
                return new LineRemoverItem();
            case 4:
                return new WeightItem();
            default:
                return null;
        }
    }

    public int getHeight(Block block) {
        return block.getShape().length;
    }

    public int getWidth(Block block) {
        return block.getShape()[0].length;
    }

    public boolean isMovable(Block block) {
        return block.isMovable();
    }

    public boolean isRotatable(Block block) {
        return block.isRotatable();
    }
}