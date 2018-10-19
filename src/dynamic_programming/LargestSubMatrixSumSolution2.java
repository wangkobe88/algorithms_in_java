package dynamic_programming;

/**
 * Created by kewang on 15/10/18.
 */
public class LargestSubMatrixSumSolution2 {

    public int[][] rowSumCache(int[][] matrix) {
        // Write your solution here
        int[][] cache = new int[ matrix.length ][ matrix[0].length ];

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j == 0){
                    cache[i][j] = matrix[i][j];
                } else {
                    cache[i][j] = cache[i][j - 1] + matrix[i][j];
                }
            }
        }

        return cache;
    }

    private int largestSum(int[] array) {
        // Write your solution here

        if(array == null || array.length == 0){
            return 0;
        }

        int[] results = new int[array.length];
        results[0] = array[0];
        int maxLength = results[0];
        for(int i = 1; i < array.length; i++){
            results[i] = results[i-1] > 0 ? results[i-1] + array[i] : array[i];
            maxLength = Math.max(results[i], maxLength);
        }
        return maxLength;
    }

    private int[] colSum(int[][] rowSumCache, int col1, int col2){
        int[] colSum = new int[rowSumCache.length];
        for(int i = 0; i < rowSumCache.length; i++){
            if(col1 == 0){
                colSum[i] = rowSumCache[i][col2];
            } else {
                colSum[i] = rowSumCache[i][col2] - rowSumCache[i][col1 - 1];
            }
        }
        return colSum;
    }

    public int largest(int[][] matrix) {
        // Write your solution here
        int[][] rowSumCache = rowSumCache(matrix);
        int max = matrix[0][0];
        for (int col1 = 0; col1 < matrix[0].length; col1++){
            for (int col2 = col1; col2 < matrix[0].length; col2 ++){
                int[] allColsBetween =  colSum(rowSumCache, col1, col2);
                max = Math.max(max,largestSum(allColsBetween));
            }
        }
        return max;
    }

}
