package domain.block.entity.itemBlock;

import domain.block.entity.Block;

public class DrillItem extends Block{
    public DrillItem() {
        shape = new int[][] {
            {1},
            {1},
        };
        isRotatable = false;
        isMovable = true;
    }
}
