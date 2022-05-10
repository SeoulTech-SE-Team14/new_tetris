package domain.block.entity.tetromino;

import domain.block.entity.Block;

public class ZBlock extends Block {
    
    public ZBlock() {
        shape = new int[][] {
            {1, 1, 0},
			{0, 1, 1}
        };
        isRotatable = true;
        isMovable = true;
    }
}

