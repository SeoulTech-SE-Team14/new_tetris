package domain.block.entity.itemBlock;

import domain.block.entity.Block;
import domain.board.entity.Board;

public class BombItem extends Block{
    public BombItem(){
        int b = Board.TYPE_BOMB;

        shape = new int[][]{
            {b},
        };
        isRotatable = true;
        isMovable = true;
    }
}
