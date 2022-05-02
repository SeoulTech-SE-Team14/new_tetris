package domain.board.controller;

import java.util.ArrayList;
import java.util.List;

import domain.block.entity.Block;
import domain.board.entity.Board;
import global.matrix.IntMatrixUtil;

public class BoardController {

    private static BoardController INSTANCE = new BoardController();

    public static BoardController getInstance() {
        return INSTANCE;
    }

    private void updateCurBlock(Block block, Board board) {
        // int[][] curBlockPosInBoard = findCurBlockPosInBoard(block, board);

    }

    
    // 매개변수를 Block block, Board board로 변경하자
    private int[][] findCurBlockPosInBoard(int[][] matrix, int xPos, int yPos, int[] center, int count) {

        int[][] ret = new int[count][2];

        int[][] notZeroValue = IntMatrixUtil.findAllNotZeroValuePos(matrix, count);

        for (int i = 0; i < count; i++) {
            ret[i][0] = xPos + (notZeroValue[i][0] - center[0]);
            ret[i][1] = yPos + (notZeroValue[i][1] - center[1]);
        }

        return ret;
    }

    // 지워지는 라인 Column 모두 리턴
    public List<Integer> findFullLine(Board board) {

        List<Integer> ret = new ArrayList<>();

        return null;
    }

    public void eraseFullLine(Board board) {
        List<Integer> fullLines = findFullLine(board);

        for (int fullLine : fullLines) {
            //
        }
    }
    
    public void moveLeft(Block block, Board board) {
        //

        updateCurBlock(block, board);
    }

    public void moveRight(Block block, Board board) {
        //

        updateCurBlock(block, board);
    }

    public void moveDown(Block block, Board board) {
        try {
            
        } catch (ArrayIndexOutOfBoundsException e) {
            updateCurBlock(block, board);
            eraseFullLine(board);
        }
    }

    public void moveDownAtOnce(Block block, Board board) {
        try {
            for (int i = 0; i < 20; i++) {
                moveDown(block, board);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            updateCurBlock(block, board);
            eraseFullLine(board);
        }
    }
}
