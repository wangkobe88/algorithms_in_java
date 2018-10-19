package dynamic_programming;

/**
 * Created by kewang on 15/10/18.
 */
public class LargestSubSquareSurroundedBy1 {

    public int[][][] longestAllDirections(int[][] matrix) {
        int[][][] results = new int[4][matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(j == 0){
                    results[0][i][j] = matrix[i][j] > 0? 1:0;
                }else if (matrix[i][j] == 1){
                    results[0][i][j] = results[0][i][j - 1] + 1;
                } else {
                    results[0][i][j] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = matrix[0].length - 1; j >= 0 ; j--){
                if(j == matrix[0].length - 1){
                    results[1][i][j] = matrix[i][j] > 0? 1:0;
                }else if (matrix[i][j] == 1){
                    results[1][i][j] = results[1][i][j + 1] + 1;
                } else {
                    results[1][i][j] = 0;
                }
            }
        }

        for(int j = 0; j < matrix[0].length; j++){
            for(int i = 0; i < matrix.length; i++){
                if(i == 0){
                    results[2][i][j] = matrix[i][j] > 0? 1:0;
                } else if (matrix[i][j] == 1){
                    results[2][i][j] = results[2][i - 1][j] + 1;
                } else {
                    results[2][i][j] = 0;
                }
            }
        }

        for(int j = 0; j < matrix[0].length; j++){
            for(int i = matrix.length - 1; i >= 0 ; i--){
                if(i == matrix.length - 1){
                    results[3][i][j] = matrix[i][j] > 0? 1:0;
                } else if (matrix[i][j] == 1){
                    results[3][i][j] = results[3][i + 1][j] + 1;
                } else {
                    results[3][i][j] = 0;
                }
            }
        }

        return results;
    }
    private int[][] largestSquareAllPoints(int[][][] longestAllDirections){
        int[][] results = new int[longestAllDirections[0].length][longestAllDirections[0][0].length];
        for(int i = 0; i < longestAllDirections[0].length; i++){
            for(int j = 0; j < longestAllDirections[0][0].length; j++){
                results[i][j] = 0;
                int minLongestFromRightAndBottom = Math.min(longestAllDirections[1][i][j], longestAllDirections[3][i][j]);
                for(int k = minLongestFromRightAndBottom; k >= 1; k--) {
                    //System.out.println(String.valueOf(i) + String.valueOf(j) + String.valueOf(k));
                    //System.out.println(String.valueOf(i) + String.valueOf(i + k - 1) + String.valueOf(longestAllDirections[2]));
                    if(longestAllDirections[2][i + k - 1][j + k - 1] >= k && longestAllDirections[0][i + k - 1][j + k - 1] >= k){
                        results[i][j] = k;
                        break;
                    }
                }
            }
        }
        return results;
    }

    private int maxOfMatrix(int[][] lengthCross){
        int result = lengthCross[0][0];
        for(int i = 0; i < lengthCross.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(i) + ":");
            for(int j = 0; j < lengthCross[0].length; j++){
                sb.append(String.valueOf(lengthCross[i][j]));
                result = Math.max(lengthCross[i][j], result);
            }
            sb.append(String.valueOf(i));
            System.out.println(sb.toString());
        }
        return result;
    }


    public int largest(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][][] longest = longestAllDirections(matrix);
        int[][] minLongest = largestSquareAllPoints(longest);
        return maxOfMatrix(minLongest);
    }

    public static void main(String[] args){
        LargestSubSquareSurroundedBy1 jg = new LargestSubSquareSurroundedBy1();
        System.out.println( jg.largest(new int[][]{{1,0,1,1,1},{1,1,1,1,1},{1,1,0,1,0},{1,1,1,1,1},{1,1,1,0,0}}) );
        //jg.canJump(int[2, 3,1,1,4]);
    }

}
