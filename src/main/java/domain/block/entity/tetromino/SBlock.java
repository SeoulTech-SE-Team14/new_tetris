package domain.block.entity.tetromino;

import domain.block.entity.Block;

public class SBlock extends Block{
    
    public SBlock() {
        shape = new int[][] {
            {0, 1, 1},
			{1, 1, 0}
        };
        isRotatable = true;
        isMovable = true;
    }
}
