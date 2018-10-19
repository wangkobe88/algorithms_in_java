package dynamic_programming;

/**
 * Created by kewang on 15/10/18.
 */
public class RangeSumQuery2DImmutable {
    private int getValue(int[][] matrix, int row, int col){
        if(row < matrix.length && row >= 0&& col < matrix[0].length && col >= 0){
            return matrix[row][col];
        } else {
            return 0;
        }
    }

    private int[][] getCache(int[][] matrix){
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                cache[i][j] = getValue(cache, i - 1, j) + getValue(cache,i,j - 1)
                        - getValue(cache, i - 1, j - 1) + matrix[i][j];
            }
        }
        return cache;
    }


    public int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
        // Write your solution here
        int[][] cache = getCache(matrix);
        return getValue(cache,row2,col2) + getValue(cache,row1 - 1,col1 - 1)
                - getValue(cache,row1 - 1,col2) - getValue(cache,row2,col1 - 1);
    }
}
