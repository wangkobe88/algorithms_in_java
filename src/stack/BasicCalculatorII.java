package stack;
import java.util.*;
/**
 * Created by kewang on 12/11/18.
 */
public class BasicCalculatorII {
    class Element{
        int value;
        boolean isDigit;
        Element(int value,boolean isDigit){
            this.value = value;
            this.isDigit = isDigit;
        }
    }

    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        char[] sChars = s.toCharArray();
        Stack<Element> stack = new Stack<Element>();
        int index = 0;
        while(index < sChars.length){
            if(sChars[index] == ' '){
                index++;
                continue;
            }

            int digit = 0;
            boolean isDigit = false;
            while(index < sChars.length && sChars[index] >= '0' && sChars[index] <= '9'){
                digit = digit * 10 + sChars[index] - '0';
                index++;
                isDigit = true;
            }
            if(isDigit) {
                index--;
            }

            if( (!stack.isEmpty()) && !stack.peek().isDigit && stack.peek().value == '*' && isDigit == true){
                stack.pop();
                int previous = stack.pop().value;
                stack.push(new Element(previous * digit, true));
            } else if( (!stack.isEmpty()) && !stack.peek().isDigit && stack.peek().value == '/' && isDigit == true){
                stack.pop();
                int previous = stack.pop().value;
                stack.push(new Element(previous / digit, true));
            } else if (isDigit){
                stack.push(new Element(digit, true));
            } else {
                stack.push(new Element(Integer.valueOf(sChars[index]), false));
            }
            index++;
        }

        int result = 0;
        while(!stack.isEmpty() && stack.size() > 1) {
            Element last = stack.pop();
            Element mark = stack.pop();
            if(mark.value == '+') {
                result += last.value;
            } else {
                result -= last.value;
            }
        }
        if(stack.isEmpty()){
            return result;
        } else {
            return result + stack.peek().value;
        }
    }
}
