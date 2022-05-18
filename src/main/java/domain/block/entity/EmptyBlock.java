package domain.block.entity;

public class EmptyBlock extends Block{
    
    public EmptyBlock() {
        shape = new int[][] {
            {1},
        };
        isRotatable = false;
        isMovable = false;
    }
}
