package dfs;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kewang on 26/9/18.
 */
public class AllValidPermutationsOfParentheses {
    private void dfs(int n, int left, int right, String result, List<String> results){
        if(left + right == 2*n){
            results.add(result);
            return;
        }

        if(left < n){
            result += '(';
            dfs (n, left + 1, right, result, results);
            result = result.substring( 0, result.length() - 1);
        }

        if(left > right){
            result += ')';
            dfs (n, left, right + 1, result, results);
            result = result.substring( 0, result.length() - 1);
        }
    }

    public List<String> validParentheses(int n) {
        // Write your solution here
        int left = 0;
        int right = 0;
        List<String> results = new ArrayList<String>();
        dfs(n, left, right, new String() , results);
        return results;
    }
    public static void main(String[] args) {
        AllValidPermutationsOfParentheses allValidPermutationsOfParentheses = new AllValidPermutationsOfParentheses();
        //kClosestInSortedArray.kClosest(new int[]{1,5}, 10, 1);
        List<String> results = allValidPermutationsOfParentheses.validParentheses(2);
        for (String s : results){
            System.out.println(s);
        }
    }
}
