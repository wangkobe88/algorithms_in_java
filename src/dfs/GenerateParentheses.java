package dfs;
import java.util.*;
/**
 * Created by kewang on 11/12/18.
 */
public class GenerateParentheses {
    private void generateParenthesis(int level, int total, int left, int right, char[] result, List<String> results){
        if(level == 2*total) {
            results.add(new String(result));
        }

        if(left < total) {
            result[level] = '(';
            generateParenthesis(level + 1, total, left + 1, right, result, results);
        }

        if(left > right) {
            result[level] = ')';
            generateParenthesis(level + 1, total, left, right + 1, result, results);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();
        if( n <= 0) {
            return results;
        }

        char[] result = new char[n*2];
        generateParenthesis(0, n, 0, 0, result, results);
        return results;
    }
}
