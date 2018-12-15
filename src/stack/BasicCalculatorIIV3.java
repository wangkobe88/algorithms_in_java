package stack;
import java.util.*;
/**
 * Created by kewang on 12/11/18.
 */
public class BasicCalculatorIIV3 {
    private int trimSpace(char[] sChars){
        int slow = 0;
        int fast = 0;
        while(fast < sChars.length){
            if(sChars[fast] != ' '){
                sChars[slow++] = sChars[fast++];
            } else{
                fast++;
            }
        }
        return slow;
    }

    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        char[] sChars = s.toCharArray();
        int length = trimSpace(sChars);
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        char mark = '+';
        while(index < length){
            int digit = 0;
            while(index < length && sChars[index] >= '0' && sChars[index] <= '9'){
                digit = digit * 10 + sChars[index] - '0';
                index++;
            }
            //+1-2*3
            if(mark == '+') {
                stack.push(digit);
            } else if(mark == '-') {
                stack.push(-1*digit);
            } else if(mark == '*') {
                stack.push(stack.pop()*digit);
            } else {
                stack.push(stack.pop()/digit);
            }

            if(index < length){
                mark = sChars[index];
            }
            index++;
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
