package domain.board.entity;

public class Board {
    public static final int TYPE = 0;
    public static final int COLOR = 1;

    public static final int TYPE_EMPTY = 0;
    public static final int TYPE_STATIC = 1;

    public static final int TYPE_BOMB = 2;
    public static final int TYPE_BONUS_SCORE = 3;
    public static final int TYPE_DRILL = 4;
    public static final int TYPE_LINE_REMOVER = 5;
    public static final int TYPE_WEIGHT = 6;

    private int[][][] board;

    private int curX;
    private int curY;

    public Board() {
        board = new int[24][10][2];

        curX = 3;
        curY = 4;
    }

    public int[][][] getBoard() {
        return this.board;
    }

    public void setBoard(int[][][] board) {
        this.board = board;
    }

    public int getCurX() {
        return curX;
    }

    public void setCurX(int curX) {
        this.curX = curX;
    }

    public int getCurY() {
        return curY;
    }

    public void setCurY(int curY) {
        this.curY = curY;
    }
}
