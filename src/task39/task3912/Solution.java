package task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int [][] temp = new int[rows + 1][cols + 1];
        int maxLength = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    temp[i][j] = Math.min(Math.min(temp[i][j - 1], temp[i - 1][j]), temp[i-1][j -1]) + 1;
                    maxLength = Math.max(maxLength, temp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }
}
