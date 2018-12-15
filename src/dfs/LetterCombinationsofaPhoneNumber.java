package dfs;
import java.util.*;
/**
 * Created by kewang on 8/11/18.
 */
/*
*
*  错误1：数组初始化，如果使用{}，那么不要写数组大小。
*  静态初始化数组：方法一
   String cats[] = new String[] {"A","B","C"};
   //静态初始化数组：方法二
   String dogs[] = {"D","E","F"};
   //动态初始化数据
   String books[] = new String[2];

   错误2: 由数字组成的字符串，转化为字符后，还需要减去0才能的得到数字。
* */
public class LetterCombinationsofaPhoneNumber {
    private void letterCombinations(char[] digits, int level, StringBuilder result, List<String> results, Map<Integer,char[]> lettersMap) {

        if(level == digits.length) {
            results.add(result.toString());
            return;
        }

        char[] letters = lettersMap.get(digits[level] - '0');

        for(char letter : letters){
            result.append(letter);
            letterCombinations(digits, level + 1, result, results, lettersMap);
            result.deleteCharAt(result.length() - 1);
        }

    }

    private void initLettersMap(Map<Integer,char[]> lettersMap){
        lettersMap.put(2, new char[]{'a','b','c'});
        lettersMap.put(3, new char[]{'d','e','f'});
        lettersMap.put(4, new char[]{'g','h','i'});
        lettersMap.put(5, new char[]{'j','k','l'});
        lettersMap.put(6, new char[]{'m','n','o'});
        lettersMap.put(7, new char[]{'p','q','r','s'});
        lettersMap.put(8, new char[]{'t','u','v'});
        lettersMap.put(9, new char[]{'w','x','y','z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return results;
        }

        Map<Integer,char[]> lettersMap = new HashMap<Integer,char[]>();
        initLettersMap(lettersMap);

        StringBuilder result = new StringBuilder();
        letterCombinations(digits.toCharArray(), 0, result, results, lettersMap);
        return results;
    }
}
