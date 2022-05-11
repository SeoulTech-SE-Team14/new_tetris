package domain.board.controller;

import domain.block.entity.tetromino.TBlock;
import domain.board.entity.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardControllerTest {

    Board board;

    @Test
    void moveLeft() {
        board = new Board();
        board.setNowBlock(new TBlock());
        board.setPrevBlock(new TBlock());

        board.setxPos(5);
        board.setyPos(5);
        BoardController.getInstance().moveLeft(board);
        assertEquals(4, board.getyPos());
    }
}