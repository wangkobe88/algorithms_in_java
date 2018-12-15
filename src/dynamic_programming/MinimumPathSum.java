package dynamic_programming;

/**
 * Created by kewang on 14/12/18.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] results = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    results[i][j] = grid[0][0];
                } else if(i == 0) {
                    results[i][j] = results[i][j-1] + grid[i][j];
                } else if(j == 0) {
                    results[i][j] = results[i-1][j] + grid[i][j];
                } else {
                    results[i][j] = grid[i][j] + Math.min(results[i-1][j],results[i][j-1]);
                }
            }
        }
        return results[grid.length-1][grid[0].length-1];
    }
}
