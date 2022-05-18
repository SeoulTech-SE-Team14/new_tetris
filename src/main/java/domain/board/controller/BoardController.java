package domain.board.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.DrillItem;
import domain.block.entity.itemBlock.WeightItem;
import domain.board.constant.BoardComponent;
import domain.board.constant.map.BoardColorMap;
import domain.board.entity.Board;
import global.matrix.IntMatrixUtil;

public class BoardController {

    private static BoardController INSTANCE = new BoardController();

    public static BoardController getInstance() {
        return INSTANCE;
    }

    public BoardController() { }
    
    public boolean doHitWall(Board board, Block nowBlock) {
        int[][] matrix = nowBlock.getShape();
        int[][][] tBoard = board.getBoard();

        int count = IntMatrixUtil.countNotZeroValue(matrix);
        int[][] nowBlockPosInBoard = findNowBlockPosInBoard(board, nowBlock);

        try {
            for (int i = 0; i < count; i++) {
                int x = nowBlockPosInBoard[i][0] + 1;
                int y = nowBlockPosInBoard[i][1];

                if (tBoard[x][y][Board.TYPE] != Board.TYPE_EMPTY) {
                    if (nowBlock instanceof WeightItem)
                        nowBlock.setMovable(false);
                    if (nowBlock.isPassable())
                        continue;
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
        
        return false;
    }

    public boolean isGameOver(Board board) {
        final int[][] test = board.getBoard()[3];
        for (int x = 0; x < 10; x++) {
            if (test[x][Board.TYPE] != Board.TYPE_EMPTY)
                return true;
        }
        return false;
    }

    public int[][] findNowBlockPosInBoard(Board board, Block nowBlock) {
        int[][] matrix = nowBlock.getShape();

        int curX = board.getCurX();
        int curY = board.getCurY();

        int count = IntMatrixUtil.countNotZeroValue(matrix);
        int[] center = IntMatrixUtil.findNearestCenter(matrix);
        int[][] notZeroValue = IntMatrixUtil.findAllNotZeroValuePos(matrix, count);

        int[][] ret = new int[count][2];

        for (int i = 0; i < count; i++) {
            ret[i][0] = curX + (notZeroValue[i][0] - center[0]);
            ret[i][1] = curY + (notZeroValue[i][1] - center[1]);
        }

        return ret;
    }

    private void moveBoardLineDown(int[][][] board, int deletedRow) {
        for (int i = deletedRow; i > 0; i--) {
            board[i] = board[i - 1];
        }

        board[0] = new int[10][2];
        for (int i = 0; i < 10; i++) {
            board[0][i][Board.TYPE] = Board.TYPE_EMPTY;
            board[0][i][Board.COLOR] = BoardColorMap.getColor(BoardComponent.EMPTY);
        }
    }

    private void moveBoardLineUp(int[][][] board, int[][] createdLine, int index) {

        for (int i = 0; i < index; i++)
            board[i] = board[i  + 1];

        board[index] = createdLine;
    }

    public List<Integer> findFullLine(Board board) {
        List<Integer> lines = new ArrayList<>();
        int[][][] currentBoard = board.getBoard();

        for(int row = 0; row < 24; row++) {
            int cnt = 0;
            for(int col = 0; col < 10; col++) {
                if (currentBoard[row][col][Board.TYPE] == Board.TYPE_LINE_REMOVER) {
                    lines.add(row); break;
                } else if(currentBoard[row][col][Board.TYPE] == Board.TYPE_EMPTY)
                    continue;
                
                cnt++;
                if(cnt == 10)
                    lines.add(row);
            }
        }

        return lines;
    }

    public void deleteFullLine(Board board, List<Integer> toDelete) {
        for (Integer i : toDelete) {
            moveBoardLineDown(board.getBoard(), i);
        }
    }

    public void deleteFullLine(Board board) {
        deleteFullLine(board, findFullLine(board));
    }

    private void move(Board board, Block nowBlock, int dx, int dy) {

        if (!nowBlock.isMovable() && !(dx == 1 && dy == 0))
            return;

        int[][] nowBlockPosInBoard = findNowBlockPosInBoard(board, nowBlock);
        int[][][] tBoard = board.getBoard();

        for (int i = 0; i < nowBlockPosInBoard.length; i++) {
            int x = nowBlockPosInBoard[i][0];
            int y = nowBlockPosInBoard[i][1];

            try {
                if (tBoard[x + dx][y + dy][Board.TYPE] != Board.TYPE_EMPTY && !nowBlock.isPassable())
                    return;
                tBoard[x + dx][y + dy][Board.TYPE] = Board.TYPE_EMPTY;
                tBoard[x + dx][y + dy][Board.COLOR] = 0x000000; // BLACK
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }

        int curX = board.getCurX();
        int curY = board.getCurY();

        board.setCurX(curX + dx);
        board.setCurY(curY + dy);
    }

    public void moveDown(Board board, Block nowBlock) {
        move(board, nowBlock, 1, 0);
    }

    public void moveLeft(Board board, Block nowBlock) {
        move(board, nowBlock, 0, -1);
    }

    public void moveRight(Board board, Block nowBlock) {
        move(board, nowBlock, 0, 1);
    }

    public void transformBlockToBoard(Board board, Block nowBlock, int color) {
        if (nowBlock instanceof DrillItem)
            return;
        else if (nowBlock instanceof WeightItem)
            return;

        int[][] matrix = nowBlock.getShape();
        int count = IntMatrixUtil.countNotZeroValue(matrix);
    
        int[][] nowBlockPos = IntMatrixUtil.findAllNotZeroValuePos(matrix, count);
        int[][] nowBlockPosInBoard = findNowBlockPosInBoard(board, nowBlock);
    
        int[][][] tBoard = board.getBoard();
    
        if (nowBlock instanceof BombItem) {
            int px = board.getCurX();
            int py = board.getCurY();

            for (int dx = -1; dx <= 1; dx++)
                for (int dy = -1; dy <= 1; dy++) {
                    try {
                        int x = px + dx;
                        int y = py + dy;

                        tBoard[x][y][Board.TYPE] = Board.TYPE_EMPTY;
                        tBoard[x][y][Board.COLOR] = 0x000000; 
                    } catch (Exception e) {
                        continue;
                    }
                }
        } else {
            for (int i = 0; i < count; i++) {
                int ix = nowBlockPos[i][0];
                int iy = nowBlockPos[i][1];
    
                int bx = nowBlockPosInBoard[i][0];
                int by = nowBlockPosInBoard[i][1];
        
                tBoard[bx][by][Board.TYPE] = matrix[ix][iy];
                tBoard[bx][by][Board.COLOR] = color; 
            }
        }
    }

    public void rotate(Board board, Block nowBlock) {
        if (nowBlock.isRotatable()) {
            int[][] beforeShape = nowBlock.getShape();
            int[][] afterShape = IntMatrixUtil.rotateClockwise(nowBlock.getShape());

            nowBlock.setShape(afterShape);
            int[][] nowBlockPosInBoard = findNowBlockPosInBoard(board, nowBlock);

            int prevXPos = board.getCurX();
            int prevYPos = board.getCurY();

            for (int xVal = 0; xVal >= -1; xVal--) {
                for (int yVal = 0; yVal <= 2; yVal++) {
                    board.setCurX(prevXPos + xVal); board.setCurY(prevYPos + yVal);
                    nowBlockPosInBoard = findNowBlockPosInBoard(board, nowBlock);
                    if (isEmpty(board, nowBlockPosInBoard))
                        return;
        
                    board.setCurX(prevXPos + xVal); board.setCurY(prevYPos - yVal);
                    nowBlockPosInBoard = findNowBlockPosInBoard(board, nowBlock);
                    if (isEmpty(board, nowBlockPosInBoard))
                        return;
                }
            }

            nowBlock.setShape(beforeShape);
            board.setCurX(prevXPos); board.setCurY(prevYPos);
        }
    }

    private boolean isEmpty(Board board, int[][] posInBoard) {

        int[][][] tBoard = board.getBoard();

        try {
            for (int i = 0; i < posInBoard.length; i++) {
                int x = posInBoard[i][0];
                int y = posInBoard[i][1];
    
                if (tBoard[x][y][Board.TYPE] != Board.TYPE_EMPTY)
                    return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    public void updatePreviewBoard(Board board, Board previewBoard, Block nowBlock, List<Integer> toDeleted, int savedCurX, int savedCurY) {
        if (toDeleted.isEmpty())
            return;

        int beforeCurX = board.getCurX();
        int beforeCurY = board.getCurY();

        board.setCurX(savedCurX);
        board.setCurY(savedCurY);
        
        int[][] nowBlockPosInBoard = findNowBlockPosInBoard(board, nowBlock);
        int[][][] boardShape = board.getBoard();
        int[][][] previewBoardShape = previewBoard.getBoard();

        board.setCurX(beforeCurX);
        board.setCurY(beforeCurY);

        // Collections.reverse(toDeleted);

        for (int x : toDeleted) {
            int[][] deletedLineShape = new int[10][2];

            for (int y = 0; y < 10; y++) {
                deletedLineShape[y][Board.TYPE] = boardShape[x][y][Board.TYPE];
                if (deletedLineShape[y][Board.TYPE] != Board.TYPE_EMPTY)
                    deletedLineShape[y][Board.COLOR] = 0xDCDCDC;
            }

            for (int i = 0; i < nowBlockPosInBoard.length; i++) {
                int bx = nowBlockPosInBoard[i][0];
                int by = nowBlockPosInBoard[i][1];

                if (bx == x) {
                    deletedLineShape[by][Board.TYPE] = Board.TYPE_EMPTY;
                    deletedLineShape[by][Board.COLOR] = 0x000000;
                }
            }

            moveBoardLineUp(previewBoardShape, deletedLineShape, 23);
        }
    }

    public void moveUpBoard(Board board, Board previewBoard) {
        int cnt = 0;

        try {
            while (isExistInLine(previewBoard, 23)) {
                if (cnt == 10)
                    return;

                moveBoardLineUp(board.getBoard(), previewBoard.getBoard()[23], 23);
                moveBoardLineDown(previewBoard.getBoard(), 23);

                cnt++;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    private boolean isExistInLine(Board board, int index) {
        int[][][] boardShape = board.getBoard();

        for (int i = 0; i < 10; i++)
            if (boardShape[index][i][Board.TYPE] != Board.TYPE_EMPTY)
                return true;

        return false;
    }
}
