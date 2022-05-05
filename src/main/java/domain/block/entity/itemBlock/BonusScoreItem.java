package domain.block.entity.itemBlock;

import domain.block.entity.Block;

public class BonusScoreItem extends Block{
    public BonusScoreItem() {
        shape = new int[][] {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1},
        };
        isRotatable = true;
        isMovable = true;
    }
}
