package recursion;

/**
 * Created by kewang on 12/12/18.
 */
public class RotateImage {
    private void rotate(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        if(startRow >= endRow) {
            return;
        }
        //int[] temp = new int[endRow - startRow];
        for(int i = 0; i < (endRow - startRow); i++) {
            int temp = matrix[endRow - i][startCol]; // 74
            matrix[endRow - i][startCol] = matrix[endRow][endCol-i]; // 74<-98
            matrix[endRow][endCol - i] = matrix[startRow + i][endCol]; //
            matrix[startRow + i][endCol] = matrix[startRow][startCol + i];
            matrix[startRow][startCol + i] = temp;
        }
        rotate(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1);
    }

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        rotate(matrix, 0, 0, matrix.length - 1, matrix.length - 1);
    }
}
