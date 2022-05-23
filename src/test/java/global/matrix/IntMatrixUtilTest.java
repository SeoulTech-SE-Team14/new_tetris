package global.matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntMatrixUtilTest {

    @Test
    @DisplayName("시계 방향 회전 테스트 - 배열이 비어있을 때")
    void testRotateClockwise() {
        int[][] matrix = {};
        int[][] expected = {};
        int[][] actual = IntMatrixUtil.rotateClockwise(matrix);
        assertArrayEquals(expected, actual);
    }
    @Test
    @DisplayName("시계 방향 회전 테스트 - 배열이 비어있지 않을 때")
    void testRotateClockwise2() {
         // 1 2 --> 7 4 1
         // 4 5 --> 8 5 2
         // 7 8
        int[][] matrix = {{1, 2}, {4, 5}, {7, 8}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}};
        int[][] actual = IntMatrixUtil.rotateClockwise(matrix);
        assertArrayEquals(expected, actual);
    }
    @Test
    @DisplayName("가장 가까운 중심점 찾기 테스트")
    void testFindNearestCenter() {
        int[][] matrix = {{1, 1, 1}, {0, 0, 1}};
        // sumR : 0 + 0 + 0 + 1
        // sumC : 0 + 1 + 2 + 2
        // avgR = 1/4 = 0
        // avgC = 5/4 = 1
        int[] expected = {0, 1};
        int[] actual = IntMatrixUtil.findNearestCenter(matrix);
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("0이 아닌 값 개수 테스트")
    void testCountNotZeroValue() {
        int[][] matrix = {{1, 2, 0}, {4, 0, 6}, {0, 8, 0}, {10, 0, 12}};
        int expected = 7;
        int actual = IntMatrixUtil.countNotZeroValue(matrix);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("0이 아니니 값 좌표 얻기 테스트")
    void testFindAllNotZeroValuePos() {
        int[][] matrix = {{1, 1, 1}, {0, 0, 1}};
        int[][] expected = {{0, 0}, {0, 1}, {0, 2}, {1, 2}};
        int count = IntMatrixUtil.countNotZeroValue(matrix);
        int[][] actual = IntMatrixUtil.findAllNotZeroValuePos(matrix, count);
        assertArrayEquals(expected, actual);
    }
}