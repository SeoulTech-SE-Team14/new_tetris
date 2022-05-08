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

    public BoardController() {
        board = new Board();
    }

    private boolean isItem(int[][] shape, int i) {
        for (int r = 0; r < shape.length; r++) {
            for (int c = 0; c < shape[r].length; c++) {
                if (shape[r][c] == i)
                    return true;
            }
        }

        return false;
    }
    private void removePos(int[][] pos) {
        int[][][] tBoard = board.getBoard();
        for (int i = 0; i < pos.length; i++) {
            int x = pos[i][0];
            int y = pos[i][1];

            tBoard[x][y][0] = Board.TYPE_EMPTY;
            tBoard[x][y][1] = BoardColorMap.getColor(BoardComponent.EMPTY);
        }
    }
    private void convertBlockToBoard() {
        int[][][] tBoard = board.getBoard();
        Block block = board.getNowBlock();
        int[][] curBlockPosInBoard = findCurBlockPosInBoard();
        //int blockColor = block.getColor();
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
            //scoreService.updateScore(5, GameFrame.periodInterval);
            for (int i = 0; i < IntMatrixUtil.countNotZeroValue(block.getShape()); i++) {
                int xPos = curBlockPosInBoard[i][0];
                int yPos = curBlockPosInBoard[i][1];
                tBoard[xPos][yPos][Board.TYPE] = Board.TYPE_STATIC;
                //tBoard[xPos][yPos][Board.COLOR] = blockColor;
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
                //tBoard[xPos][yPos][Board.COLOR] = blockColor;
            }
        }
        lineCount += findFullLine().size();
    }
    // spawn block method ?
    private void updateCurBlock() {
        board.setNowBlock(board.getPrevBlock());
        board.setyPos(5);
        board.setxPos(5 - IntMatrixUtil.lengthCenterToBottom(board.getNowBlock().getShape()));

        if (isItemMode && lineCount >= PER_LINES) {
            board.setPrevBlock(BlockController.getInstance().getRandomItem());
            lineCount %= PER_LINES;
        }
        else {
            board.setPrevBlock(BlockController.getInstance().getRandomItem());
        }
    }
    public void init() {
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
        updateCurBlock();
    }

    public Board getBoard() {
        return board;
    }

    public int[][] findCurBlockPosInBoard() {
        Block block = board.getNowBlock();
        int[][] shape = block.getShape();
        int xPos = board.getxPos();
        int yPos = board.getyPos();
        int[] center = IntMatrixUtil.findNearestCenter(shape);
        int count = IntMatrixUtil.countNotZeroValue(shape);

        int[][] ret = new int[count][2];
        int[][] notZeroValue = IntMatrixUtil.findAllNotZeroValuePos(shape, count);

        for (int i = 0; i < count; i++) {
            ret[i][0] = xPos + (notZeroValue[i][0] - center[0]);
            ret[i][1] = yPos + (notZeroValue[i][1] - center[1]);
        }
        return ret;
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
    public List<Integer> findFullLine() {
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
    public void eraseFullLine() {
        int[][][] newBoard = board.getBoard();
        List<Integer> fullLines = findFullLine();
        for (int fullLine : fullLines) {
            for(int row = fullLine; row > 0; row--) {
                newBoard[row] = newBoard[row - 1];
            }
            newBoard[0] = new int[10][2];
            for(int col = 0; col < 10; col++) {
                newBoard[0][col][Board.TYPE] = Board.TYPE_EMPTY;
                newBoard[0][col][Board.COLOR] = BoardColorMap.getColor(BoardComponent.EMPTY);
            }
        }
        board.setBoard(newBoard);
    }
    public void moveLeft() {
        Block block = board.getNowBlock();
        if(block.isMovable()) {
            try {
                int[][] curBlockPosInBoard = findCurBlockPosInBoard();
                int[][] blockShape = block.getShape();
                if (block instanceof DrillItem) {
                    for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                        if (board.getBoard()[curBlockPosInBoard[i][0]][curBlockPosInBoard[i][1] - 1][Board.TYPE] != Board.TYPE_EMPTY) {
                            // continue 의미가 뭐지
                            continue;
                        }
                    }
                    removePos(curBlockPosInBoard);
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
    public void moveRight() {
        Block block = board.getNowBlock();
        if (block.isMovable()) {
            try {
                int[][] curBlockPosInBoard = findCurBlockPosInBoard();
                if (block instanceof DrillItem) {
                    for (int i = 0; i < IntMatrixUtil.countNotZeroValue(block.getShape()); i++) {
                        if (board.getBoard()[curBlockPosInBoard[i][0]][curBlockPosInBoard[i][1] + 1][Board.TYPE] != Board.TYPE_EMPTY) {
                            continue;
                        }
                    }
                    removePos(curBlockPosInBoard);
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
    public void moveDown() {
        Block block = board.getNowBlock();
        int[][] blockShape = block.getShape();
        int[][] curBlockPosInBoard = findCurBlockPosInBoard();

        try {
            if (block instanceof WeightItem) {
                for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                    if (board.getBoard()[curBlockPosInBoard[i][0] + 1][curBlockPosInBoard[i][1]][Board.TYPE] != Board.TYPE_EMPTY) {
                        board.getNowBlock().setMovable(false);
                    }
                }
                removePos(curBlockPosInBoard);
            }
            else if (block instanceof DrillItem) {
                for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                    if (board.getBoard()[curBlockPosInBoard[i][0] + 1][curBlockPosInBoard[i][1]][Board.TYPE] != Board.TYPE_EMPTY) {
                        continue;
                    }
                }
                removePos(curBlockPosInBoard);
            }
            else {
                for (int i = 0; i < IntMatrixUtil.countNotZeroValue(blockShape); i++) {
                    if (board.getBoard()[curBlockPosInBoard[i][0] + 1][curBlockPosInBoard[i][1]][Board.TYPE] != Board.TYPE_EMPTY) {
                        convertBlockToBoard();
                        updateCurBlock();
                    }
                }
            }

            board.setxPos(board.getxPos() + 1);
            //scoreService.updateScore(0, GameFrame.periodInterval);
        } catch (IndexOutOfBoundsException e) {
            if (block instanceof WeightItem) {
                removePos(curBlockPosInBoard);
                updateCurBlock();
            }
            else if (block instanceof DrillItem) {
                removePos(curBlockPosInBoard);
                updateCurBlock();
            }
            else {
                convertBlockToBoard();
                updateCurBlock();
            }
        }
    }
    public void moveDownAtOnce(Board board) {
        try {
            for (int i = 0; i < 20; i++) {
                moveDown();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            eraseFullLine();
            updateCurBlock();
        }
    }
}
