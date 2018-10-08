package bit;

import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

/**
 * Created by kewang on 6/10/18.
 */

public class Int2Hexadecimal {

    private char getChar(int x){
        if (x < 10){
            return (char)(x + '0');
        } else {
            return (char)(x - 10 + 'A');
        }
    }
    public String int2Hexadecimal(int num){
        String result = new String();
        while(num > 0) {
            char x = getChar(num % 16);
            result = x + result;
            num = num/16;
        }
        return "0X" + result;
    }

    public String int2HexadecimalV2(int num){
        StringBuilder result = new StringBuilder();
        while(num > 0) {
            char x = getChar(num % 16);
            result = result.append(x); // 效率太低
            num = num/16;
        }
        return "0X" + result.reverse().toString();
    }
}
