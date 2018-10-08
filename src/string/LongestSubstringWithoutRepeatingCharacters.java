package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kewang on 4/10/18.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Write your solution here
        if (s == null || s.length() <= 0) {
            return 0;
        }
        char[] inputChars = s.toCharArray();
        int i = 0;
        int j = 1;
        Map<Character, Integer> charWindowMap = new HashMap<Character, Integer>();
        charWindowMap.put(inputChars[0], 1);
        int max_length = 1;
        boolean isDup = false;
        char dupChar = ' ';

        while (j < inputChars.length) {

            if (isDup == false) {
                if (j - i > max_length) {
                    max_length = j - i;
                }

                if (charWindowMap.get(inputChars[j]) != null) {
                    int count = charWindowMap.get(inputChars[j]);
                    charWindowMap.put(inputChars[j], count + 1);
                    if (count == 1) {
                        isDup = true;
                        dupChar = inputChars[j];
                    }
                } else {
                    charWindowMap.put(inputChars[j], 1);
                }
                j++;
            } else {
                int count = charWindowMap.get(inputChars[i]);
                if(count == 2 && dupChar == inputChars[i]){
                    isDup = false;
                }
                charWindowMap.put(inputChars[i], count - 1);
                i++;
            }
        }
        if (j - i > max_length && isDup == false) {
            max_length = j - i;
        }
        return max_length;
    }

    public int lengthOfLongestSubstringV2(String s) {
        // Write your solution here
        if (s == null || s.length() <= 0) {
            return 0;
        }
        char[] inputChars = s.toCharArray();
        int i = 0;
        int j = 1;
        Map<Character, Integer> charWindowMap = new HashMap<Character, Integer>();
        charWindowMap.put(inputChars[0], 1);
        int max_length = 1;

        int count = 0;
        while (j < inputChars.length) {

            if (charWindowMap.get(inputChars[j]) != null) {
                count = charWindowMap.get(inputChars[j]);
                charWindowMap.put(inputChars[j], count + 1);

                while(charWindowMap.get(inputChars[j]) == 2){

                    if(charWindowMap.get(inputChars[i]) - 1 == 0){
                        charWindowMap.remove(inputChars[i]);
                    } else {
                        charWindowMap.put(inputChars[i], charWindowMap.get(inputChars[i]) - 1);
                    }
                    i++;
                }

            } else {
                charWindowMap.put(inputChars[j], 1);
                if (j - i > max_length) {
                    max_length = j - i + 1;
                }
            }
            j++;
        }

        if (j - i > max_length) {
            max_length = j - i + 1;
        }
        return max_length;
    }

    public int lengthOfLongestSubstringV2Bak(String s) {
        // Write your solution here
        if (s == null || s.length() <= 0) {
            return 0;
        }
        char[] inputChars = s.toCharArray();
        int i = 0;
        int j = 1;
        Map<Character, Integer> charWindowMap = new HashMap<Character, Integer>();
        charWindowMap.put(inputChars[0], 1);
        int max_length = 1;

        int count = 0;
        while (j < inputChars.length) {

            Iterator<Map.Entry<Character,Integer>> iter = charWindowMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Character,Integer> e = iter.next();
                System.out.println(e.getKey());
                System.out.println(e.getValue());
            }
            System.out.println("**************");

            if (charWindowMap.get(inputChars[j]) != null) {
                count = charWindowMap.get(inputChars[j]);

                charWindowMap.put(inputChars[j], count + 1);
                while(charWindowMap.get(inputChars[j]) == 2){
                    charWindowMap.put(inputChars[i], charWindowMap.get(inputChars[i]) - 1);
                    i++;
                }

            } else {
                charWindowMap.put(inputChars[j], 1);
                if (j - i > max_length && count < 1) {
                    max_length = j - i + 1;
                }
            }
            j++;
        }

        if (j - i > max_length && count < 1) {
            max_length = j - i + 1;
        }
        return max_length;
    }

    public int lengthOfLongestSubstringBak(String s) {
        // Write your solution here
        if (s == null || s.length() <= 0) {
            return 0;
        }
        char[] inputChars = s.toCharArray();
        int i = 0;
        int j = 1;
        Map<Character, Integer> charWindowMap = new HashMap<Character, Integer>();
        charWindowMap.put(inputChars[0], 1);
        int max_length = 1;
        boolean isDup = false;
        char dupChar = ' ';

        while (j < inputChars.length) {

            Iterator<Map.Entry<Character,Integer>> iter = charWindowMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Character,Integer> e = iter.next();
                System.out.println(e.getKey());
                System.out.println(e.getValue());
            }
            System.out.println(isDup);
            System.out.println("**************");
            if (isDup == false) {
                if (j - i > max_length) {
                    max_length = j - i;
                }

                if (charWindowMap.get(inputChars[j]) != null) {
                    int count = charWindowMap.get(inputChars[j]);
                    charWindowMap.put(inputChars[j], count + 1);
                    if (count == 1) {
                        isDup = true;
                        dupChar = inputChars[j];
                    }
                } else {
                    charWindowMap.put(inputChars[j], 1);
                }
                j++;
            } else {
                //System.out.println(inputChars[i]);
                int count = charWindowMap.get(inputChars[i]);
                if(count == 2 && dupChar == inputChars[i]){
                    isDup = false;
                }
                charWindowMap.put(inputChars[i], count - 1);
                i++;
            }
        }
        if (j - i > max_length && isDup == false) {
            max_length = j - i;
        }
        return max_length;
    }
    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        //int result = ls.lengthOfLongestSubstringKDistinct("abbbbbbbddddefgh",2);
        //int result = ls.lengthOfLongestSubstringKDistinct("eceba",2);
        //int result = ls.lengthOfLongestSubstringKDistinct("aa",2);
        String[] testCases = new String[]{"abcabcbb", "bbbbb","pwwkew","aabaab!bb","au"};
        for (String testCase : testCases) {
            int result = ls.lengthOfLongestSubstringV2(testCase);
            System.out.println(result);
            System.out.println("------------------");
        }

    }
}
