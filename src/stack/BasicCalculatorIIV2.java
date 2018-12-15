package stack;
import java.util.*;
/**
 * Created by kewang on 12/11/18.
 */
/*
* String的trim()只能删除首尾的空格。
* 在一个循环内部，如果指针移动了，后面的逻辑不要忘记做判断以及处理。
* */
public class BasicCalculatorIIV2 {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        char[] sChars = s.toCharArray();
        //char[] newSChars = trimSpace(sChars);
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        char mark = '+';
        while(index < sChars.length){
            if(sChars[index] == ' '){
                index++;
                continue;
            }

            int digit = 0;
            while(index < sChars.length && sChars[index] >= '0' && sChars[index] <= '9'){
                digit = digit * 10 + sChars[index] - '0';
                index++;
            }

            if(index < sChars.length && sChars[index] == ' '){
                index++;
                //continue;
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

            if(index < sChars.length){
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
