package domain.block.entity.tetromino;

import domain.block.entity.Block;

public class TBlock extends Block {
    
    public TBlock() {
        shape = new int[][] {
            {0, 1, 0},
			{1, 1, 1}
        };
        isRotatable = true;
        isMovable = true;
    }
}