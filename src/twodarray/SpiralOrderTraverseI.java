package twodarray;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kewang on 9/10/18.
 */
public class SpiralOrderTraverseI {
    private void print_spiral(int[][] matrix, int start_row, int start_col, int print_length, List<Integer> result){
        if(print_length == 0){
            return;
        } else if(print_length == 1){
            result.add(matrix[start_row][start_col]);
            return;
        }

        for (int i = 0; i < print_length - 1; i++){
            result.add(matrix[start_row][start_col + i]);
        }

        for(int i = 0; i < print_length - 1; i++){
            result.add(matrix[start_row + i][ start_col + print_length -1]);
        }

        for(int i = 0; i < print_length - 1; i++){
            result.add(matrix[start_row  + print_length -1][ start_col + print_length - 1 - i]);
        }

        for(int i = 0; i < print_length - 1; i++){
            result.add(matrix[start_col + print_length - 1 - i][ start_col]);
        }
        print_spiral(matrix, start_row + 1, start_col + 1, print_length - 2, result);
    }

    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        int start_row = 0;
        int start_col = 0;
        int print_length = matrix.length;
        List<Integer> result = new ArrayList<Integer>();
        print_spiral(matrix, 0, 0, print_length, result);
        return result;
    }
}
