package domain.block.entity.tetromino;

import domain.block.entity.Block;

public class OBlock extends Block{
    
    public OBlock() {
        shape = new int[][] {
            {1, 1}, 
			{1, 1}
        };
        isRotatable = true;
        isMovable = true;
    }
}
