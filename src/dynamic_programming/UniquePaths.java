package dynamic_programming;

/**
 * Created by kewang on 14/12/18.
 */
public class UniquePaths {
    //2D dynamic programming
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) {
            return 0;
        }
        int[][] results = new int[m][n];
        //results[0][0] = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    results[i][j] = 1;
                } else {
                    results[i][j] = results[i-1][j] + results[i][j-1];
                }
            }
        }
        return results[m-1][n-1];
    }

    //DFS solution
    public int uniquePathsV1(int m, int n) {
        if(m <= 0 || n <= 0) {
            return 0;
        }
        int[] result = new int[1];
        uniquePathsHelper(0, 0, m - 1, n - 1, result);
        return result[0];
    }

    private void uniquePathsHelper(int rowStart, int colStart, int rowEnd, int colEnd, int[] result){
        if(rowStart == rowEnd && colStart == colEnd) {
            result[0] += 1;
            return;
        }

        if(rowStart < rowEnd) {
            uniquePathsHelper(rowStart + 1, colStart, rowEnd, colEnd, result);
        }
        if(colStart < colEnd) {
            uniquePathsHelper(rowStart, colStart + 1, rowEnd, colEnd, result);
        }
    }

}
