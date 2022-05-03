package domain.block.entity;

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

