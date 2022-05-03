package domain.block.entity;

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
