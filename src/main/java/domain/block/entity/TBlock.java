package domain.block.entity;

public class TBlock extends Block {
    
    public TBlock() {
        shape = new int[][] {
            {0, 1, 0},
			{1, 1, 1}
        };
        isRotatable = true;
        isMovable = true;
    }
}