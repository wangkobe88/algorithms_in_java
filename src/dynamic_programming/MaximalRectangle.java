package dynamic_programming;

/**
 * Created by kewang on 15/12/18.
 */
// 最大面积定义为以某个点在自己行向前后得到1的最大长度，跟上一层融合，得到其高度最左与左右的界限。
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        int[] height = new int[matrix[0].length];
        for(int j = 0; j < matrix[0].length; j++) {
            right[j] = matrix[0].length - 1;
        }
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] = height[j] + 1;
                }
            }

            int curLeft = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    left[j] = 0;
                    curLeft = j + 1;
                } else {
                    left[j] = Math.max(left[j], curLeft);
                }
            }

            int curRight = matrix[0].length - 1;
            for(int j = matrix[0].length - 1; j >= 0; j--) {
                if(matrix[i][j] == '0') {
                    right[j] = matrix[0].length - 1;
                    curRight = j-1;
                } else {
                    right[j] = Math.min(right[j], curRight);
                }
            }
            for(int j = 0; j < matrix[0].length; j++) {
                //System.out.println(String.valueOf(right[j]) + ":" +  String.valueOf(left[j]) + ":" + String.valueOf(height[j]) );
                maxArea = Math.max(maxArea, (right[j] - left[j] + 1) * height[j]);
            }
        }
        return maxArea;

    }
}
