package domain.block.entity.itemBlock;

import domain.block.entity.Block;
import domain.board.entity.Board;

public class WeightItem extends Block{
    public WeightItem() {
        int w = Board.TYPE_WEIGHT;

        shape = new int[][] {
            {0, w, w, 0},
            {w, w, w, w},
        };
        
        isRotatable = false;
        isMovable = true;
        isPassable = true;
    }
}
