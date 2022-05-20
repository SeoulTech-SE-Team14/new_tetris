package domain.board.controller;

import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.DrillItem;
import domain.block.entity.itemBlock.WeightItem;
import domain.block.entity.tetromino.*;
import domain.board.entity.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardControllerTest {
    Board board;
    Block block;
    int[][][] tboard;
    @BeforeEach
    void beforeEach() {
        board = new Board();
        tboard = new int[24][10][2];
    }
    @Test
    @DisplayName("[HitWall] 무게추 블럭이 못 움 움직이게 만드는 경우")
    void testDoWeightBlockHitWall() {
        block = new WeightItem();
        board.setCurX(8);
        board.setCurY(7);
        int[][] shape = BoardController.getInstance().findNowBlockPosInBoard(board, block);
        tboard[10][7][0] = 1;
        tboard[10][7][1] = 0xffffff;
        board.setBoard(tboard);
        assertFalse(BoardController.getInstance().doHitWall(board, block));
        assertFalse(block.isMovable());
    }

    @Test
    @DisplayName("[HitWall] 일반 블럭이 벽을 때리는 경우")
    void testDoHitWall() {
        block = new OBlock();
        board.setCurX(8);
        board.setCurY(7);
        tboard[10][7][0] = 1;
        tboard[10][7][1] = 0xffffff;
        board.setBoard(tboard);
        assertTrue(BoardController.getInstance().doHitWall(board, block));
    }

    @Test
    @DisplayName("[HitWall] 일반 블럭이 벽을 때리지 않는 경우")
    void testDoHitWall2() {
        block = new OBlock();
        board.setCurX(8);
        board.setCurY(7);
        tboard[11][7][0] = 1;
        tboard[11][7][1] = 0xffffff;
        board.setBoard(tboard);
        assertFalse(BoardController.getInstance().doHitWall(board, block));
    }
    @Test
    @DisplayName("[HitWall] 잘못된 인덱스 접근 테스트")
    void testDoHitWall3() {
        block = new OBlock();
        board.setCurX(23);
        board.setCurY(7);
        board.setBoard(tboard);
        assertTrue(BoardController.getInstance().doHitWall(board, block));
    }
    @Test
    @DisplayName("[isGameOver] 게임이 끝나는 경우")
    void testGameOver() {
        for(int x = 0; x < 10; x++) {
            tboard[3][x][0] = 1;
        }
        board.setBoard(tboard);
        assertTrue(BoardController.getInstance().isGameOver(board));
    }

    @Test
    @DisplayName("[isGameOver] 게임이 끝나지 않는 경우")
    void testGameOver2() {
        board.setBoard(tboard);
        assertFalse(BoardController.getInstance().isGameOver(board));
    }

    @Test
    @DisplayName("[deleteFullLine] 지우는 라인이 주어질 때")
    void testDeleteFullLine() {
        int[][][] expected = new int[24][10][2];

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 5; x++) {
                if (y % 2 == 0) {
                    tboard[y][x][0] = 1;
                    expected[y + 1][x][0] = 1;
                } else {
                    tboard[y][x + 5][0] = 1;
                    expected[y + 1][x + 5][0] = 1;
                }
            }
        }
        for(int x = 0; x < 10; x++) tboard[11][x][0] = 1;

        board.setBoard(tboard);
        List<Integer> toDelete = new ArrayList<>();
        toDelete.add(11);
        BoardController.getInstance().deleteFullLine(board, toDelete);
        board.getBoard();
        assertArrayEquals(expected, board.getBoard());
    }
    @Test
    @DisplayName("[deleteFullLine] 지우는 라인이 안 주어질 때")
    void testDeleteFullLine2() {
        int[][][] expected = new int[24][10][2];

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 5; x++) {
                if (y % 2 == 0) {
                    tboard[y][x][0] = 1;
                    expected[y + 1][x][0] = 1;
                } else {
                    tboard[y][x + 5][0] = 1;
                    expected[y + 1][x + 5][0] = 1;
                }
            }
        }
        for(int x = 0; x < 10; x++) tboard[11][x][0] = 1;

        board.setBoard(tboard);
        BoardController.getInstance().deleteFullLine(board);
        board.getBoard();
        assertArrayEquals(expected, board.getBoard());
    }
    @Test
    @DisplayName("[move] 아래로 이동 할 수 있는 경우")
    void testMoveDown() {
        block = new SBlock();
        board.setCurX(5);
        board.setCurY(5);
        for (int y = 10; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                tboard[y][x][0] = 1;
            }
        }
        board.setBoard(tboard);
        BoardController.getInstance().moveDown(board, block);
        assertEquals(6, board.getCurX());
        assertEquals(5, board.getCurY());
    }

    @Test
    @DisplayName("[move] 아래로 이동 할 수 없는 경우")
    void testMoveDown2() {
        block = new OBlock();
        board.setCurX(5);
        board.setCurY(5);
        for (int y = 6; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                tboard[y][x][0] = 1;
            }
        }
        board.setBoard(tboard);
        BoardController.getInstance().moveDown(board, block);
        assertEquals(5, board.getCurX());
        assertEquals(5, board.getCurY());
    }
    @Test
    @DisplayName("[move] 왼쪽 이동 할 수 있는 경우")
    void testMoveLeft() {
        block = new IBlock();
        board.setCurX(5);
        board.setCurY(5);
        for (int x = 0; x < 3; x++) {
            tboard[5][x][0] = 1;
        }
        board.setBoard(tboard);
        BoardController.getInstance().moveLeft(board, block);
        assertEquals(5, board.getCurX());
        assertEquals(4, board.getCurY());
    }

    @Test
    @DisplayName("[move] 왼쪽 이동 할 수 없는 경우")
    void testMoveLeft2() {
        block = new LBlock();
        board.setCurX(5);
        board.setCurY(5);
        for (int x = 0; x < 5; x++) {
            tboard[5][x][0] = 1;
        }
        board.setBoard(tboard);
        BoardController.getInstance().moveLeft(board, block);
        assertEquals(5, board.getCurX());
        assertEquals(5, board.getCurY());
    }

    @Test
    @DisplayName("[move] 오른쪽 이동 할 수 있는 경우")
    void testMoveRight() {
        block = new JBlock();
        board.setCurX(5);
        board.setCurY(3);
        for (int x = 7; x < 10; x++) {
            tboard[5][x][0] = 1;
        }
        board.setBoard(tboard);
        BoardController.getInstance().moveRight(board, block);
        assertEquals(5, board.getCurX());
        assertEquals(4, board.getCurY());
    }

    @Test
    @DisplayName("[move] 오른쪽 이동 할 수 없는 경우")
    void testMoveRight2() {
        block = new IBlock();
        board.setCurX(5);
        board.setCurY(3);
        // y : 5  => [2][3][4][5][6][7][8][9]
        // y : 5  => [ ][c][ ][ ][1][1][1][1]
        for (int x = 6; x < 10; x++) {
            tboard[5][x][0] = 1;
        }
        board.setBoard(tboard);
        BoardController.getInstance().moveRight(board, block);
        assertEquals(5, board.getCurX());
        assertEquals(3, board.getCurY());
    }

    @Test
    @DisplayName("[transformBlockToBoard] 드릴 아이템 경우")
    void testTransformBlockToBoard() {
        int[][][] expected = new int[24][10][2];
        block = new DrillItem();
        board.setCurX(7);
        board.setCurY(3);
        // y : 7  => [ ][ ][ ][ ][ ][ ][ ][ ]
        // y : 8  => [ ][ ][ ][ ][ ][ ][ ][ ]
        // y : 9  => [1][1][1][ ][1][1][1][1]
        // y : 10  => [1][1][1][ ][1][1][1][1]
        for(int x = 0; x < 10; x++) {
            if(x == 3) continue;
            tboard[9][x][0] = 1;
            tboard[10][x][0] = 1;
            expected[9][x][0] = 1;
            expected[10][x][0] = 1;
        }
        board.setBoard(tboard);
        BoardController.getInstance().transformBlockToBoard(board, block, 0x00000);
        assertArrayEquals(expected, board.getBoard());
    }
    @Test
    @DisplayName("[transformBlockToBoard] 무게추 아이템 경우")
    void testTransformBlockToBoard2() {
        int[][][] expected = new int[24][10][2];
        block = new WeightItem();
        board.setCurX(7);
        board.setCurY(3);
        // y : 7  => [ ][ ][ ][ ][ ][ ][ ][ ]
        // y : 8  => [ ][ ][ ][ ][ ][ ][ ][ ]
        // y : 9  => [1][1][1][ ][1][1][1][1]
        // y : 10  => [1][1][1][ ][1][1][1][1]
        for(int x = 0; x < 10; x++) {
            if(x == 3) continue;
            tboard[9][x][0] = 1;
            tboard[10][x][0] = 1;
            expected[9][x][0] = 1;
            expected[10][x][0] = 1;
        }
        board.setBoard(tboard);
        BoardController.getInstance().transformBlockToBoard(board, block, 0x00000);
        assertArrayEquals(expected, board.getBoard());
    }

    @Test
    @DisplayName("[transformBlockToBoard] 폭탄 아이템인경우")
    void testTransformBlockToBoard3() {
        int[][][] expected = new int[24][10][2];
        block = new BombItem();
        board.setCurX(9);
        board.setCurY(3);
        /**
         * before
         * y : 7  => [ ][ ][ ][ ][ ][ ][ ][ ]
         * y : 8  => [ ][ ][ ][ ][ ][ ][ ][ ]
         * y : 9  => [1][1][1][ ][1][1][1][1]
         * y : 10  => [1][1][1][ ][1][1][1][1]

         * after
         y : 7  => [ ][ ][ ][ ][ ][ ][ ][ ]
         y : 8  => [ ][ ][ ][ ][ ][ ][ ][ ]
         y : 9  => [1][1][ ][ ][ ][1][1][1]
         y : 10  => [1][1][ ][ ][ ][1][1][1]
         */
        for(int x = 0; x < 10; x++) {
            if (x == 3) continue;
            tboard[9][x][0] = 1;
            tboard[10][x][0] = 1;
        }
        for(int x = 0; x < 10; x++) {
            expected[9][x][0] = 1;
            expected[10][x][0] = 1;
            if(x == 1) x = 4;
        }
        board.setBoard(tboard);
        BoardController.getInstance().transformBlockToBoard(board, block, 0x00000);
        assertArrayEquals(expected, board.getBoard());
    }
    @Test
    @DisplayName("[transformBlockToBoard] 일반 블럭 경우")
    void testTransformBlockToBoard4() {
        int[][][] expected = new int[24][10][2];
        block = new TBlock();
        board.setCurX(8);
        board.setCurY(3);
        // y : 7  => [ ][ ][ ][ ][ ][ ][ ][ ]
        // y : 8  => [ ][ ][ ][ ][ ][ ][ ][ ]
        // y : 9  => [1][1][ ][ ][ ][1][1][1]
        // y : 10  => [1][1][1][ ][1][1][1][1]
        for(int x = 0; x < 10; x++) {
            tboard[9][x][0] = 1;
            tboard[10][x][0] = 1;
            expected[9][x][0] = 1;
            expected[10][x][0] = 1;
        }
        expected[8][3][0] = 1;
        tboard[9][2][0] = 0;
        tboard[9][3][0] = 0;
        tboard[9][4][0] = 0;
        tboard[10][3][0] = 0;
        expected[10][3][0] = 0;

        board.setBoard(tboard);
        BoardController.getInstance().transformBlockToBoard(board, block, 0x00000);
        assertArrayEquals(expected, board.getBoard());
    }

    @Test
    @DisplayName("[rotate]")
    void testRotate() {
        int[][] expected = {
                {1, 0},
                {1, 1},
                {1, 0},
        };
        block = new TBlock();
        board.setCurX(8);
        board.setCurY(3);
        BoardController.getInstance().rotate(board, block);
        assertArrayEquals(expected, block.getShape());
    }
    @Test
    @DisplayName("[moveUpBoard]")
    void testMoveUpBoard() {
        int[][][] preview = new int[24][10][2];
        int[][][] expectedBoard = new int[24][10][2];
        int[][][] expectedPreviewBoard = new int[24][10][2];
        for(int x = 0; x < 10; x++) {
            tboard[22][x][0] = 1;
            tboard[23][x][0] = 1;
            expectedBoard[22][x][0] = 1;
            expectedBoard[23][x][0] = 1;
        }
        Board previewBoard = new Board();
        previewBoard.setBoard(tboard);
        board.setBoard(preview);
        /**
         * <before>
         *     preview board
         *     y: 20 => [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
         *     y: 22 => [1][1][1][1][1][1][1][1][1][1]
         *     y: 23 => [1][1][1][1][1][1][1][1][1][1]
         *
         *     board
         *     y: 20 => [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
         *     y: 22 => [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
         *     y: 23 => [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
         * </before>
         *
         * <after>
         *     preview board
         *     y: 20 => [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
         *     y: 22 => [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
         *     y: 23 => [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
         *
         *     board
         *     y: 20 => [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
         *     y: 22 => [1][1][1][1][1][1][1][1][1][1]
         *     y: 23 => [1][1][1][1][1][1][1][1][1][1]
         * </after>
         */
        BoardController.getInstance().moveUpBoard(board, previewBoard);
        assertArrayEquals(expectedBoard, board.getBoard());
        assertArrayEquals(expectedPreviewBoard, previewBoard.getBoard());
    }
}