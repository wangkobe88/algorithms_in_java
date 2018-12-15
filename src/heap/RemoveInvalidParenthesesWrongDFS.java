package heap;
import java.util.*;
/**
 * Created by kewang on 9/11/18.
 */
public class RemoveInvalidParenthesesWrongDFS {
    private boolean isValid(char[] sChars, boolean[] isKeep) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < sChars.length; i++) {
            if(isKeep[i] == false) {
                continue;
            }

            char c = sChars[i];
            if(stack.isEmpty() || c == '(') {
                stack.push(c);
            } else if( c == ')') {
                if(stack.peek() == 'C') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(stack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private void removeInvalidParentheses(char[] sChars, boolean[] isKeep, int level, int length, List<String> results, int[] maxLength, int maxLevel) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sChars.length; i++) {
            if(isKeep[i] == true) {
                sb.append(sChars[i]);
            }
        }
        System.out.println(sb.toString());

        if(level >= maxLevel || length > maxLength[0]) {
            return;
        } else if (isValid(sChars, isKeep)) {
            //StringBuilder sb = new StringBuilder();
            sb = new StringBuilder();
            for(int i = 0; i < sChars.length; i++) {
                if(isKeep[i] == true) {
                    sb.append(sChars[i]);
                }
            }
            results.add(sb.toString());
            maxLength[0] = length;
            return;
        }
        isKeep[level] = false;
        removeInvalidParentheses(sChars, isKeep, level + 1, length - 1, results, maxLength, maxLevel);
        isKeep[level] = true;
        removeInvalidParentheses(sChars, isKeep, level + 1, length, results, maxLength, maxLevel);
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return results;
        }
        char[] sChars = s.toCharArray();
        boolean[] isKeep = new boolean[ sChars.length ];
        for(int i = 0; i < isKeep.length; i++){
            isKeep[i] = true;
        }

        removeInvalidParentheses(sChars, isKeep, 0, sChars.length, results, new int[]{sChars.length}, sChars.length);
        return results;
    }
}
