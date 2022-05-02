package domain.block.entity;

public class OBlock extends Block{
    
    public OBlock(int color) {
        shape = new int[][] {
            {1, 1}, 
			{1, 1}
        };
        this.color = color;
        isRotatable = true;
        isMovable = true;
    }
}
