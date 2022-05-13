package domain.board.controller;

import java.util.ArrayList;
import java.util.List;

import domain.block.controller.BlockController;
import domain.block.entity.Block;
import domain.block.entity.itemBlock.BombItem;
import domain.block.entity.itemBlock.BonusScoreItem;
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

    private Board board;
    private boolean isPause;
    private boolean isItemMode;
    private boolean forceQuit;
    private int lineCount;
    private final int PER_LINES = 1;

    public BoardController() { }

    public boolean isPause() {
        return isPause;
    }
    public boolean isItemMode() {
        return isItemMode;
    }
    private boolean isEmpty(Board board, int[][] pos) {
        int[][] matrix = board.getNowBlock().getShape();
        int xPos = board.getxPos();
        int yPos = board.getyPos();
        int[] center = IntMatrixUtil.findNearestCenter(matrix);

        int[][] realPos = findRealPos(pos, xPos, yPos, center, IntMatrixUtil.countNotZeroValue(matrix));

        int[][][] tBoard = board.getBoard();

        try {
            for (int i = 0; i < IntMatrixUtil.countNotZeroValue(matrix); i++) {
                int x = realPos[i][0];
                int y = realPos[i][1];

                if (tBoard[x][y][Board.TYPE] != Board.TYPE_EMPTY) {
                    return false;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }
    public boolean isDead(Board board) {
        final int[][] test = board.getBoard()[3];
        for (int x = 0; x < 10; x++) {
            if (test[x][Board.TYPE] != Board.TYPE_EMPTY)
                return true;
        }
        return false;
    }
    public boolean getForceQuit() {
        return forceQuit;
    }
    public Board getBoard() {
        return board;
    }
    public void setForceQuit() {
        forceQuit = true;
    }
    public void setItemMode() {
        isItemMode = true;
    }

    private void removePos(Board board, int[][] pos) {
        int[][][] tBoard = board.getBoard();
        for (int i = 0; i < pos.length; i++) {
            int x = pos[i][0];
            int y = pos[i][1];

            tBoard[x][y][0] = Board.TYPE_EMPTY;
            tBoard[x][y][1] = BoardColorMap.getColor(BoardComponent.EMPTY);
        }
    }
    private void convertBlockToBoard(Board board) {
        int[][][] tBoard = board.getBoard();
        Block block = board.getNowBlock();
        int[][] curBlockPosInBoard = findCurBlockPosInBoard(board);
        int blockColor = BlockController.getInstance().getBlockColor(block);
        int lineRemoverIdx = findLineRemover(block);
        if (block instanceof BombItem) {
            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    try {
                        int xPos = curBlockPosInBoard[0][0];
                        int yPos = curBlockPosInBoard[0][1];
                        tBoard[xPos + r][yPos + c][Board.TYPE] = Board.TYPE_EMPTY;
                        tBoard[xPos + r][yPos + c][Board.COLOR] = BoardColorMap.getColor(BoardComponent.EMPTY);
                    } catch (IndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }
        else if (block instanceof BonusScoreItem) {
            //ScoreController.getInstance().updateScore(5, GameFrame.periodInterval);
            for (int i = 0; i < IntMatrixUtil.countNotZeroValue(block.getShape()); i++) {
                int xPos = curBlockPosInBoard[i][0];
                int yPos = curBlockPosInBoard[i][1];
                tBoard[xPos][yPos][Board.TYPE] = Board.TYPE_STATIC;
                tBoard[xPos][yPos][Board.COLOR] = blockColor;
            }
        }
        else {
            for (int i = 0; i < IntMatrixUtil.countNotZeroValue(block.getShape()); i++) {
                int xPos = curBlockPosInBoard[i][0];
                int yPos = curBlockPosInBoard[i][1];
                if (i == lineRemoverIdx) {
                    tBoard[xPos][yPos][Board.TYPE] = Board.TYPE_LINE_REMOVER;
                }
                else {
                    tBoard[xPos][yPos][Board.TYPE] = Board.TYPE_STATIC;
                }
                tBoard[xPos][yPos][Board.COLOR] = blockColor;
            }
        }
        lineCount += findFullLine(board).size();
    }
    private int[][] findRealPos(int[][] matrix, int xPos, int yPos, int[] center, int count) {

        int[][] ret = new int[count][2];

        int[][] notZeroValue = IntMatrixUtil.findAllNotZeroValuePos(matrix, count);

        for (int i = 0; i < count; i++) {
            ret[i][0] = xPos + (notZeroValue[i][0] - center[0]);
            ret[i][1] = yPos + (notZeroValue[i][1] - center[1]);
        }

        return ret;
    }
    private void updateCurBlock(Board board) {
        board.setNowBlock(board.getPrevBlock());
        board.setyPos(5);
        board.setxPos(5 - IntMatrixUtil.lengthCenterToBottom(board.getNowBlock().getShape()));
        if (isItemMode && lineCount >= PER_LINES) {
            board.setPrevBlock(BlockController.getInstance().getRandomItem());
            lineCount %= PER_LINES;
        }
        else {
            board.setPrevBlock(BlockController.getInstance().getRandomBlock());
        }
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

    public void init(Board board) {
        this.board = board;
        int[][][] tBoard = board.getBoard();

        for (int r = 0; r < 24; r++) {
            for (int c = 0; c < 10; c++) {
                tBoard[r][c][Board.TYPE] = Board.TYPE_EMPTY;
                tBoard[r][c][Board.COLOR] = BoardColorMap.getColor(BoardComponent.EMPTY);
            }
        }

        isPause = false;
        isItemMode = false;
        forceQuit = false;

        lineCount = 0;

        board.setPrevBlock(BlockController.getInstance().getRandomBlock());
        updateCurBlock(board);
    }

    public int[][] findCurBlockPosInBoard(Board board) {
        Block block = board.getNowBlock();
        int[][] shape = block.getShape();
        int xPos = board.getxPos();
        int yPos = board.getyPos();
        int[] center = IntMatrixUtil.findNearestCenter(shape);
        int count = IntMatrixUtil.countNotZeroValue(shape);
        return findRealPos(shape, xPos, yPos, center, count);
    }
    // i가 뭐지
    public int findLineRemover(Block block) {
        int[][] shape = block.getShape();
        int i = 0;
        for (int r = 0; r < shape.length; r++) {
            for (int c = 0; c < shape[r].length; c++) {
                if (shape[r][c] != Board.TYPE_EMPTY) {
                    if (shape[r][c] == Board.TYPE_LINE_REMOVER) {
                        return i;
                    }
                    i++;
                }
            }
        }

        return -1;
    }
    // 지워지는 라인 Column 모두 리턴
    public List<Integer> findFullLine(Board board) {
        List<Integer> lines = new ArrayList<>();
        int[][][] currentBoard = board.getBoard();
        for(int row = 0; row < 24; row++) {
            for(int col = 0; col < 10; col++) {
                // 라인 지우는 블럭이면 배열에 넣고 반복문 탈출(같은 row에 여러 개 있어도 같은 row만 지우기 때문)
                if(currentBoard[row][col][Board.TYPE] == Board.TYPE_LINE_REMOVER) {
                    lines.add(row);
                    break;
                }
                // 만약 비어있다면 반복문 탈출
                if(currentBoard[row][col][Board.TYPE] != Board.TYPE_STATIC) {
                    break;
                }
                // 10개 모두 비어있지 않다면 배열에 추가
                if(col == 9) {
                    lines.add(row);
                }
            }
        }
        return lines;
    }

    public void deleteFullLine(Board board, List<Integer> toDelete) {
        for (Integer i : toDelete) {
            moveBoardLineDown(board.getBoard(), i);
        }
    }
    public void moveLeft(Board board) {
        Block block = board.getNowBlock();
        if(block.isMovable()) {
            try {
                int[][] curBlockPosInBoard = findCurBlockPosInBoard(board);
                int[][] blockShape = block.getShape();
                if (block instanceof DrillItem) {
                    for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                        if (board.getBoard()[curBlockPosInBoard[i][0]][curBlockPosInBoard[i][1] - 1][Board.TYPE] != Board.TYPE_EMPTY) {
                            // continue 의미가 뭐지
                            continue;
                        }
                    }
                    removePos(board, curBlockPosInBoard);
                }
                else {
                    for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                        if (board.getBoard()[curBlockPosInBoard[i][0]][curBlockPosInBoard[i][1] - 1][Board.TYPE] != Board.TYPE_EMPTY) {
                            return;
                        }
                    }
                }
                board.setyPos(board.getyPos() - 1);
            } catch (IndexOutOfBoundsException e) {

            }
        }
    }
    public void moveRight(Board board) {
        Block block = board.getNowBlock();
        if (block.isMovable()) {
            try {
                int[][] curBlockPosInBoard = findCurBlockPosInBoard(board);
                if (block instanceof DrillItem) {
                    for (int i = 0; i < IntMatrixUtil.countNotZeroValue(block.getShape()); i++) {
                        if (board.getBoard()[curBlockPosInBoard[i][0]][curBlockPosInBoard[i][1] + 1][Board.TYPE] != Board.TYPE_EMPTY) {
                            continue;
                        }
                    }
                    removePos(board, curBlockPosInBoard);
                }
                else {
                    for (int i = 0; i < IntMatrixUtil.countNotZeroValue(block.getShape()); i++) {
                        if (board.getBoard()[curBlockPosInBoard[i][0]][curBlockPosInBoard[i][1] + 1][Board.TYPE] != Board.TYPE_EMPTY) {
                            return;
                        }
                    }
                }
                board.setyPos(board.getyPos() + 1);
            } catch (IndexOutOfBoundsException e) {

            }
        }
    }
    public boolean moveDown(Board board) {
        Block block = board.getNowBlock();
        int[][] blockShape = block.getShape();
        int[][] curBlockPosInBoard = findCurBlockPosInBoard(board);

        try {
            if (block instanceof WeightItem) {
                for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                    if (board.getBoard()[curBlockPosInBoard[i][0] + 1][curBlockPosInBoard[i][1]][Board.TYPE] != Board.TYPE_EMPTY) {
                        board.getNowBlock().setMovable(false);
                    }
                }
                removePos(board, curBlockPosInBoard);
            }
            else if (block instanceof DrillItem) {
                for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                    if (board.getBoard()[curBlockPosInBoard[i][0] + 1][curBlockPosInBoard[i][1]][Board.TYPE] != Board.TYPE_EMPTY) {
                        continue;
                    }
                }
                removePos(board, curBlockPosInBoard);
            }
            else {
                for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                    if (board.getBoard()[curBlockPosInBoard[i][0] + 1][curBlockPosInBoard[i][1]][Board.TYPE] != Board.TYPE_EMPTY) {
                        convertBlockToBoard(board);
                        updateCurBlock(board);
                        return true;
                    }
                }
            }

            board.setxPos(board.getxPos() + 1);
            //scoreService.updateScore(0, GameFrame.periodInterval);
        } catch (IndexOutOfBoundsException e) {
            if (block instanceof WeightItem) {
                removePos(board, curBlockPosInBoard);
                updateCurBlock(board);
            }
            else if (block instanceof DrillItem) {
                removePos(board, curBlockPosInBoard);
                updateCurBlock(board);
            }
            else {
                convertBlockToBoard(board);
                updateCurBlock(board);
            }
            return true;
        }
        return false;
    }
    public boolean moveDownAtOnce(Board board) {
        while (!moveDown(board)) {}
        return true;
    }
    public void rotate(Board board) {
        if (board.getNowBlock().isRotatable()) {
            int[][] beforeShape = board.getNowBlock().getShape();
            int[][] afterShape = IntMatrixUtil.rotateClockwise(board.getNowBlock().getShape());

            int prevXPos = board.getxPos();
            int prevYPos = board.getyPos();

            board.getNowBlock().setShape(afterShape);
            for (int xVal = 0; xVal >= -1; xVal--) {
                for (int yVal = 0; yVal <= 2; yVal++) {
                    board.setxPos(prevXPos + xVal); board.setyPos(prevYPos + yVal);
                    if (isEmpty(board, afterShape)) {
                        board.getNowBlock().setShape(afterShape);
                        return;
                    }

                    board.setyPos(prevYPos - yVal);
                    if (isEmpty(board, afterShape)) {
                        board.getNowBlock().setShape(afterShape);
                        return;
                    }
                }
            }

            board.setxPos(prevXPos); board.setyPos(prevYPos);
            board.getNowBlock().setShape(beforeShape);
        }
    }

}
