package domain.block.entity.itemBlock;

import domain.block.entity.Block;
import domain.board.entity.Board;

public class LineRemoverItem extends Block{
    public LineRemoverItem() {
        int l = Board.TYPE_LINE_REMOVER;

        shape = new int[][] {
            {l, l, l, l},
        };
        isRotatable = true;
        isMovable = true;
    }
}
