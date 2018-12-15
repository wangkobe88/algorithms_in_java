package stack;
import java.util.*;
/**
 * Created by kewang on 11/12/18.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] sChars = s.toCharArray();
        for(char ch : sChars) {
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if(stack.size() > 0) {
                if(ch == ')' && stack.peek() != '(') {
                    return false;
                } else if( ch ==']' && stack.peek() != '[') {
                    return false;
                } else if( ch =='}' && stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                return false;
            }
        }
        if(stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    //much faster
    public boolean isValidV2(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] sChars = s.toCharArray();
        for(char ch : sChars) {
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if(stack.size() > 0) {
                char top = stack.pop();
                if(ch == ')' && top != '(') {
                    return false;
                } else if( ch == ']' && top != '[') {
                    return false;
                } else if( ch == '}' && top != '{') {
                    return false;
                }
            } else {
                return false;
            }
        }
        if(stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
