package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kewang on 29/10/18.
 */
public class AllValidPermutationsOfParenthesesIITest {
    private void validParentheses(int[] ls, int[] ms, int[] ns, Stack<Character> st,StringBuilder sb, List<String> results) {

        if(ls[0] == ls[2] && ms[0] == ms[2] && ns[0] == ns[2]) {
            results.add( sb.toString() );
            return;
        }

        if(ls[0] > ls[1]) {
            sb.append('(');
            ls[1] += 1;
            st.push('(');
            validParentheses(ls, ms, ns, st, sb, results);
            sb.deleteCharAt(sb.length() - 1);
            st.pop();
            ls[1] -= 1;
        }
        System.out.println(String.valueOf(ls[0]) + String.valueOf(ls[1]) + String.valueOf(ls[2]));
        System.out.println(sb.toString());
        System.out.println(String.valueOf(st.size())); //+ String.valueOf(st.peek()));
        if(ls[1] > ls[2] && st.size() > 0 && st.peek().equals('(')) {
            sb.append(')');
            ls[2] += 1;
            st.pop();
            validParentheses(ls, ms, ns, st, sb, results);
            sb.deleteCharAt(sb.length() - 1);
            ls[2] -= 1;
            st.push('(');
        }

    }

    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        int[] ls = new int[3];
        ls[0] = l;
        int[] ms = new int[3];
        ms[0] = m;
        int[] ns = new int[3];
        ns[0] = n;
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        List<String> results = new ArrayList<String>();
        validParentheses(ls, ms, ns, st, sb, results);
        return results;
    }

    public static void main(String[] args) {
        AllValidPermutationsOfParenthesesIITest allValidPermutationsOfParentheses = new AllValidPermutationsOfParenthesesIITest();
        //kClosestInSortedArray.kClosest(new int[]{1,5}, 10, 1);
        List<String> results = allValidPermutationsOfParentheses.validParentheses(2,0,0);
        for (String s : results){
            System.out.println(s);
        }
    }
}
