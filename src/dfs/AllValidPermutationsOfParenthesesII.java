package dfs;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by kewang on 29/10/18.
 */
/*
错误1：
* DFS在每一层的每一个分支，必须恢复到没有进入之前的状态，这样才能真正实现完全遍历。
* */

public class AllValidPermutationsOfParenthesesII {
    private void validParentheses(int[] ls, int[] ms, int[] ns, Stack<Character> st,StringBuilder sb, List<String> results) {
        System.out.println(sb.toString());
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

        if(ms[0] > ms[1]) {
            sb.append('<');
            ms[1] += 1;
            st.push('<');
            validParentheses(ls, ms, ns, st, sb, results);
            sb.deleteCharAt(sb.length() - 1);
            st.pop();
            ms[1] -= 1;
        }

        if(ns[0] > ns[1]) {
            sb.append('{');
            ns[1] += 1;
            st.push('{');
            validParentheses(ls, ms, ns, st, sb, results);
            sb.deleteCharAt(sb.length() - 1);
            st.pop();
            ns[1] -= 1;
        }


        if(ls[1] > ls[2] && st.size() > 0 && st.peek().equals('(')) {
            sb.append(')');
            ls[2] += 1;
            st.pop();
            validParentheses(ls, ms, ns, st, sb, results);
            sb.deleteCharAt(sb.length() - 1);
            ls[2] -= 1;
            st.push('(');
        }

        if(ms[1] > ms[2] && st.size() > 0 && st.peek().equals('<')) {
            sb.append('>');
            ms[2] += 1;
            st.pop();
            validParentheses(ls, ms, ns, st, sb, results);
            sb.deleteCharAt(sb.length() - 1);
            ms[2] -= 1;
            st.push('<');
        }

        if(ns[1] > ns[2] && st.size() > 0 && st.peek().equals('{')) {
            sb.append('}');
            ns[2] += 1;
            st.pop();
            validParentheses(ls, ms, ns, st, sb, results);
            sb.deleteCharAt(sb.length() - 1);
            ns[2] -= 1;
            st.push('{');
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
        AllValidPermutationsOfParenthesesII allValidPermutationsOfParentheses = new AllValidPermutationsOfParenthesesII();
        //kClosestInSortedArray.kClosest(new int[]{1,5}, 10, 1);
        List<String> results = allValidPermutationsOfParentheses.validParentheses(2,0,0);
        for (String s : results){
            System.out.println(s);
        }
    }
}
