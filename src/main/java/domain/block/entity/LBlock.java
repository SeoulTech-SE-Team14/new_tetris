package domain.block.entity;

public class LBlock extends Block{
    
    public LBlock() {
        shape = new int[][] {
            {1, 1, 1},
			{1, 0, 0}
        };
        isRotatable = true;
        isMovable = true;
     }
}
