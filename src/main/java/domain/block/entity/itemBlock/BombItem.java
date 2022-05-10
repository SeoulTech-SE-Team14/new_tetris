package domain.block.entity.itemBlock;

import domain.block.entity.Block;

public class BombItem extends Block{
    public BombItem(){
        shape = new int[][]{
            {1},
        };
        isRotatable = true;
        isMovable = true;
    }
}
