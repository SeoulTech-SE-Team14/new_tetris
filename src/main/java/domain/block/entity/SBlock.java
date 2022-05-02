package domain.block.entity;

public class SBlock extends Block{
    
    public SBlock(int color) {
        shape = new int[][] {
            {0, 1, 1},
			{1, 1, 0}
        };
        this.color = color;
        isRotatable = true;
        isMovable = true;
    }
}
