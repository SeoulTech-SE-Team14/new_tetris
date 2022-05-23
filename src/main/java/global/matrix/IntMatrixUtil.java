package global.matrix;

public class IntMatrixUtil {
    
    public static int[][] rotateClockwise(int[][] matrix) {
        if (matrix.length == 0)
            return new int[][]{};

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] res = new int[col][row];

        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++)
                res[c][r] = matrix[row - r - 1][c];

        return res;
    }

    public static int[] findNearestCenter(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int sumR = 0;
        int sumC = 0;

        int count = countNotZeroValue(matrix);

        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] != 0) {
                    sumR += r;
                    sumC += c;
                }
            }

        int avgR = sumR / count;
        int avgC = sumC / count;

        return new int[]{ avgR, avgC };
    }

//
//    public static int lengthCenterToBottom(int[][] matrix, int[] center) {
//
//        return matrix.length - center[0];
//    }
//
//    public static int lengthCenterToBottom(int[][] matrix) {
//
//        return lengthCenterToBottom(matrix, findNearestCenter(matrix));
//    }

    public static int countNotZeroValue(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0 ; c < col; c++) {
                if (matrix[r][c] != 0) {
                    i++;
                }
            }
        }

        return i;
    }

    public static int[][] findAllNotZeroValuePos(int[][] matrix, int count) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] ret = new int[count][2];

        int i = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0 ; c < col; c++) {
                if (matrix[r][c] != 0) {
                    ret[i][0] = r;
                    ret[i][1] = c;
                    i++;
                }
            }
        }

        return ret;
    }
}
