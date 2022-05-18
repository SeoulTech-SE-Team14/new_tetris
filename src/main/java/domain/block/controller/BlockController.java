package domain.block.controller;

import domain.block.entity.Block;
import domain.block.entity.EmptyBlock;
import domain.block.entity.itemBlock.*;
import domain.block.entity.tetromino.*;
import domain.board.entity.Board;
import domain.config.entity.BlockColorConfig;
import domain.config.entity.DifficultyConfig;
import global.matrix.IntMatrixUtil;


public class BlockController {

    private static final BlockController INSTANCE = new BlockController();

    public static BlockController getInstance()  {
        return INSTANCE;
    }

    private BlockController() {

    }
    
    public Block rotate(Block block) {
        if (!block.isRotatable())
            return block;

        int[][] rotatedShape = IntMatrixUtil.rotateClockwise(block.getShape());
        block.setShape(rotatedShape);

        return block;
    }

    public int getBlockColor(Block block, BlockColorConfig blockColorConfig) {

        if(block instanceof IBlock)
            return blockColorConfig.getiBlockColor();
        else if(block instanceof JBlock)
            return blockColorConfig.getjBlockColor();
        else if(block instanceof LBlock)
            return blockColorConfig.getlBlockColor();
        else if(block instanceof OBlock)
            return blockColorConfig.getoBlockColor();
        else if(block instanceof SBlock)
            return blockColorConfig.getsBlockColor();
        else if(block instanceof TBlock)
            return blockColorConfig.gettBlockColor();
        else if(block instanceof ZBlock)
            return blockColorConfig.getzBlockColor();
        else if (block instanceof EmptyBlock)
            return 0x000000;
        else
            return 0xFFFFFF; // WHITE
    }
    public Block getRandomBlock(DifficultyConfig difficultyConfig) {
        double[] previousProbability = difficultyConfig.getPreviousProbability();

        int sumOfFitness = difficultyConfig.getSumOfFitness();
        int seed = (int)(Math.random() * sumOfFitness);

        double threshold = (double) seed / sumOfFitness;

        if(threshold <= previousProbability[0])
            return new IBlock();
        else if(threshold <= previousProbability[1])
            return new JBlock();
        else if(threshold <= previousProbability[2])
            return new LBlock();
        else if(threshold <= previousProbability[3] )
            return new OBlock();
        else if(threshold <= previousProbability[4])
            return new SBlock();
        else if(threshold <= previousProbability[5])
            return new TBlock();
        else if(threshold <= previousProbability[6])
            return new ZBlock();
        else
            return new IBlock();
    }

    public Block getRandomItem(DifficultyConfig difficultyConfig) {
        int seed = (int)(Math.random()*5);

        switch (seed) {
            case 0:
                return new BombItem();
            case 1:
                return new BonusScoreItem();
            case 2:
                return new DrillItem();
            case 3:
                return getLineRemoverItem(difficultyConfig);
            case 4:
                return new WeightItem();
            default:
                return new BombItem();
        }
    }

    public Block getLineRemoverItem(DifficultyConfig difficultyConfig) {
        int seed = (int)(Math.random()*4);

        Block block = getRandomBlock(difficultyConfig);

        int[][] shape = block.getShape();

        for (int x = 0; x < shape.length; x++)
            for (int y = 0; y < shape[x].length; y++) {
                if (shape[x][y] != 0) {
                    if (seed == 0) {
                        shape[x][y] = Board.TYPE_LINE_REMOVER;
                        block.setShape(shape);
                        return block;
                    }
                    seed--;
                }
            }

        return block;
    }
}