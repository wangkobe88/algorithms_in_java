package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 9/10/18.
 */

public class StringAbbreviationMatching {
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }

    private boolean match(char[] inputChars, int startInput, char[] patternChars, int startPattern){
        //System.out.println(String.valueOf(startInput) + String.valueOf(inputChars.length)
        //        + String.valueOf(startPattern) + String.valueOf(patternChars.length));

        if((startInput == inputChars.length) && (startPattern == patternChars.length)){
            return true;
        }else if ((startInput == inputChars.length) || (startPattern == patternChars.length)){
            return false;
        }

        int count = 0;
        if(isDigit(patternChars[startPattern])){
            while( startPattern < patternChars.length && isDigit(patternChars[startPattern])){
                count = count*10 + patternChars[startPattern] - '0';
                startPattern ++;
            }

            return match(inputChars, startInput + count, patternChars, startPattern);
        } else {
            if(inputChars[startInput] != patternChars[startPattern]){
                return false;
            }else{
                return match(inputChars, startInput + 1, patternChars, startPattern + 1);
            }
        }
    }

    public boolean match(String input, String pattern) {
        // Write your solution here
        char[] inputChars = input.toCharArray();
        char[] patternChars = pattern.toCharArray();
        return match(inputChars, 0, patternChars, 0);
    }

    public static void main(String[] args){
        StringAbbreviationMatching  a = new StringAbbreviationMatching();
        a.match("apple","5");

    }
}
