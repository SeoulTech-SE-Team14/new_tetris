package domain.block.entity;

public class IBlock extends Block {

    public IBlock() {
        shape = new int[][] {
            {1, 1, 1, 1},
        };
        isRotatable = true;
        isMovable = true;
    }
}