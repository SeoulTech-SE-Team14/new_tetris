package domain.block.entity;

public class IBlock extends Block {

    public IBlock(int color) {
        shape = new int[][] {
            {1, 1, 1, 1},
        };
        this.color = color;
        isRotatable = true;
        isMovable = true;
    }
}