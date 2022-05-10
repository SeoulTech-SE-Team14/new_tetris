package domain.block.entity.itemBlock;

import domain.block.entity.Block;

public class WeightItem extends Block{
    public WeightItem() {
        shape = new int[][] {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
        };
        isRotatable = false;
        isMovable = true;
    }
}
