package dfs;
import java.util.*;

/**
 * Created by kewang on 9/10/18.
 */
public class NQueens {
    /*
        first wrong, list don't has length,it just has size();
        second wrong, how to declare one list of list List<List<Integer>> results= new ArrayList<List<Integer>>();

     */


    private boolean isValid (Integer[] result, int number, int pos){
        for (int i = 0; i < number; i++){
            if ((result[i].equals(pos)) || Math.abs(i - number) == Math.abs(result[i] - pos)){
                return false;
            }
        }
        return true;
    }

    private void nQueensSolve(int total, int number, Integer[] result, List<List<Integer>> results ){
        if (total == number) {

            List<Integer> resultCopy = new ArrayList<Integer>();
            for (int i = 0; i < number; i++){
                resultCopy.add(result[i]);
                //System.out.println(String.valueOf(i) + " : " + String.valueOf(result[i]));
            }


            results.add(resultCopy);
        }

        for (int i = 0; i < total; i++){
            if(isValid(result, number, i)){
                result[number] = i;
                //System.out.println(Arrays.asList(result));
                nQueensSolve(total, number + 1, result, results);
            }
        }
    }

    public List<List<Integer>> nqueens(int n) {
        // Write your solution here
        List<List<Integer>> results= new ArrayList<List<Integer>>();
        Integer[] result = new Integer[n];
        //List<Integer> result = new ArrayList<Integer>();
        nQueensSolve(n, 0, result, results);
        return results;
    }

    public static void main(String args[]) {
        NQueens nq = new NQueens();
        List<List<Integer>> nqueens = nq.nqueens(1);
        for (List<Integer> qlist : nqueens){
            System.out.println(qlist.toString());
        }

        nqueens = nq.nqueens(4);
        for (List<Integer> qlist : nqueens){
            System.out.println(qlist.toString());
        }


    }
}
