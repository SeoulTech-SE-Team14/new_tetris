package domain.block.entity.itemBlock;

import domain.block.entity.Block;
import domain.board.entity.Board;

public class BonusScoreItem extends Block{
    public BonusScoreItem() {
        int s = Board.TYPE_BONUS_SCORE;

        shape = new int[][] {
            {s, s, s},
            {s, s, s},
            {s, s, s},
        };
        isRotatable = true;
        isMovable = true;
    }
}
