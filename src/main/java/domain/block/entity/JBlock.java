package domain.block.entity;

public class JBlock extends Block{
    
    public JBlock(int color) {
        shape = new int[][] {
            {1, 1, 1},
            {0, 0, 1},
        };
        this.color = color;
        isRotatable = true;
        isMovable = true;
    }
}
