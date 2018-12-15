package hashmap;
import java.util.*;
/**
 * Created by kewang on 8/11/18.
 */
public class RomanToInteger {
    private void initSymbolMap(Map<Character, Integer> symbolMap) {
        symbolMap.put('I',1);
        symbolMap.put('V',5);
        symbolMap.put('X',10);
        symbolMap.put('L',50);
        symbolMap.put('C',100);
        symbolMap.put('D',500);
        symbolMap.put('M',1000);
    }
    public int romanToInt(String s) {
        Map<Character, Integer> symbolMap = new HashMap<Character, Integer>();
        initSymbolMap(symbolMap);
        char[] sChars = s.toCharArray();
        int result = 0;
        int index = sChars.length - 1;
        while(index >= 0) {
            if(index < sChars.length - 1 && symbolMap.get(sChars[index]) < symbolMap.get(sChars[index + 1])) {
                result -= symbolMap.get(sChars[index]);
            } else {
                result += symbolMap.get(sChars[index]);
            }
            index--;
        }
        return result;
    }
}
