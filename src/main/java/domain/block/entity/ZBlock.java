package domain.block.entity;

public class ZBlock extends Block {
    
    public ZBlock(int color) {
        shape = new int[][] {
            {1, 1, 0},
			{0, 1, 1}
        };
        this.color = color;
        isRotatable = true;
        isMovable = true;
    }
}

