package dynamic_programming;

/**
 * Created by kewang on 12/10/18.
 */
public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int[][] results = new int[matrix.length][matrix[0].length];
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0){
                    results[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    results[i][j] = 1 + Math.min(Math.min(results[i - 1][j - 1],results[i - 1][j]),results[i][j - 1]);
                } else {
                    results[i][j] = 0;
                }
                maxLength = Math.max(results[i][j], maxLength);
            }
        }
        return maxLength;
    }
}
