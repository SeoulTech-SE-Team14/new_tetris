package domain.block.entity.tetromino;

import domain.block.entity.Block;

public class JBlock extends Block{
    
    public JBlock() {
        shape = new int[][] {
            {1, 1, 1},
            {0, 0, 1},
        };
        isRotatable = true;
        isMovable = true;
    }
}
