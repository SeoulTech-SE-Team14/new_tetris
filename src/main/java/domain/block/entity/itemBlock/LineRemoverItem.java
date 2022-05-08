package domain.block.entity.itemBlock;

import domain.block.entity.Block;

public class LineRemoverItem extends Block{
    public LineRemoverItem() {
        shape = new int[][] {
            {1, 1, 1, 1},
        };
        isRotatable = true;
        isMovable = true;
    }
}
