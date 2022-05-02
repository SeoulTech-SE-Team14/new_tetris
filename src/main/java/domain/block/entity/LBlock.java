package domain.block.entity;

public class LBlock extends Block{
    
    public LBlock(int color) {
        shape = new int[][] {
            {1, 1, 1},
			{1, 0, 0}
        };
        this.color = color;
        isRotatable = true;
        isMovable = true;
     }
}
