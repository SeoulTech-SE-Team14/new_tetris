package domain.block.entity.itemBlock;

import domain.block.entity.Block;
import domain.board.entity.Board;

public class DrillItem extends Block{
    public DrillItem() {
        int d = Board.TYPE_DRILL;

        shape = new int[][] {
            {d},
            {d},
        };
        isRotatable = false;
        isMovable = true;
        isPassable = true;
    }
}
