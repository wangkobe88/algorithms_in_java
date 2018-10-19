package dynamic_programming;

/**
 * Created by kewang on 15/10/18.
 */
public class LargestXOf1s {
    public int[][][] longestAllXDirections(int[][] matrix) {
        int[][][] results = new int[4][matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(j == 0 || i == 0){
                    results[0][i][j] = matrix[i][j] > 0? 1:0;
                }else if (matrix[i][j] == 1){
                    results[0][i][j] = results[0][i - 1][j - 1] + 1;
                } else {
                    results[0][i][j] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = matrix[0].length - 1; j >= 0 ; j--){
                if(j == matrix[0].length - 1 || i == 0){
                    results[1][i][j] = matrix[i][j] > 0? 1:0;
                }else if (matrix[i][j] == 1){
                    results[1][i][j] = results[1][i - 1][j + 1] + 1;
                } else {
                    results[1][i][j] = 0;
                }
            }
        }

        for(int i = matrix.length - 1; i >= 0 ; i--){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == matrix.length - 1 || j == 0){
                    results[3][i][j] = matrix[i][j] > 0? 1:0;
                } else if (matrix[i][j] == 1){
                    results[3][i][j] = results[3][i + 1][j - 1] + 1;
                } else {
                    results[3][i][j] = 0;
                }
            }
        }

        for(int i = matrix.length - 1; i >= 0 ; i--){
            for(int j = matrix[0].length -1; j >= 0 ; j--){
                if(i == matrix.length - 1 || j == matrix[0].length -1){
                    results[2][i][j] = matrix[i][j] > 0? 1:0;
                } else if (matrix[i][j] == 1){
                    results[2][i][j] = results[2][i + 1][j + 1] + 1;
                } else {
                    results[2][i][j] = 0;
                }
            }
        }



        return results;
    }
    private int[][] minXDirection(int[][][] lengthCross){
        int[][] results = new int[lengthCross[0].length][lengthCross[0][0].length];
        for(int i = 0; i < lengthCross[0].length; i++){
            for(int j = 0; j < lengthCross[0][0].length; j++){
                results[i][j] = Math.min(lengthCross[0][i][j], lengthCross[1][i][j]);
                results[i][j] = Math.min(results[i][j], lengthCross[2][i][j]);
                results[i][j] = Math.min(results[i][j], lengthCross[3][i][j]);
            }
        }
        return results;
    }

    private int maxOfMatrix(int[][] lengthCross){
        int result = lengthCross[0][0];
        for(int i = 0; i < lengthCross.length; i++){
            for(int j = 0; j < lengthCross[0].length; j++){
                //System.out.println(String.valueOf(i) + String.valueOf(j) + String.valueOf(lengthCross[i][j]));
                result = Math.max(lengthCross[i][j], result);
            }
        }
        return result;
    }


    public int largest(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][][] longest = longestAllXDirections(matrix);
        int[][] minLongest = minXDirection(longest);
        return maxOfMatrix(minLongest);
    }

    public static void main(String[] args){
        LongestCrossOf1s jg = new LongestCrossOf1s();
        System.out.println( jg.largest(new int[][]{{1,1,1,1,1},{1,0,0,1,1},{1,1,1,1,1},{1,1,1,1,0},{0,0,0,1,1}}) );
        //jg.canJump(int[2, 3,1,1,4]);
    }
}
