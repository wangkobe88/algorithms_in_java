package twodarray;

/**
 * Created by kewang on 20/10/18.
 */
public class RotateMatrix {
    private void rotateMatrix(int[][] matrix, int left, int top, int right, int bottom) {
        if(left >= right) {
            return;
        }

        int[] temp = new int[right - left];
        for(int i = 0; i < temp.length; i++){
            temp[i] = matrix[top][left + i];          //所有的坐标必须以顶点为基准
            matrix[top][left + i] = matrix[bottom - i][left];
        }

        for(int i = 0; i < temp.length; i++){
            matrix[bottom - i][left] = matrix[bottom][right - i];
        }

        for(int i = 0; i < temp.length; i++){
            matrix[bottom][right - i] = matrix[top + i][right];
        }

        for(int i = 0; i < temp.length; i++){
            matrix[top + i][right] = temp[i];
        }
        rotateMatrix(matrix, left + 1, top + 1, right - 1, bottom - 1);
    }
    public void rotate(int[][] matrix) {
        // Write your solution here
        if(matrix == null || matrix.length == 0) {
            return;
        }
        rotateMatrix(matrix, 0, 0, matrix.length - 1, matrix.length - 1);

    }

    public static void main(String[] args){
        RotateMatrix r = new RotateMatrix();
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        r.rotate(matrix);
        System.out.println("-----------------------");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


        matrix = new int[][]{{1,2},{3,4}};
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        r.rotate(matrix);
        System.out.println("-----------------------");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
