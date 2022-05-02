package domain.block.entity;

public class TBlock extends Block {
    
    public TBlock(int color) {
        shape = new int[][] {
            {0, 1, 0},
			{1, 1, 1}
        };
        this.color = color;
        isRotatable = true;
        isMovable = true;
    }
}