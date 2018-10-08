package string;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by kewang on 4/10/18.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String input, int k) {
        // Write your solution here
        if(input == null || input.length() <= 0 || k <= 0){
            return 0;
        }

        char[] inputChars = input.toCharArray();
        int i = 0;
        int j = 1;
        Map<Character,Integer> charWindowMap = new HashMap<Character,Integer>();
        charWindowMap.put(inputChars[0],1);
        int max_length = 1;
        while ( j < inputChars.length ){

            if(charWindowMap.size() <= k){

                if(j - i > max_length){
                    max_length = j-i;
                }

                if (charWindowMap.containsKey(inputChars[j])){
                    charWindowMap.put(inputChars[j],charWindowMap.get(inputChars[j]) + 1);
                } else {
                    charWindowMap.put(inputChars[j],1);
                }
                j++;
            } else {

                if (charWindowMap.get(inputChars[i]) != null ){
                    if(charWindowMap.get(inputChars[i]) == 1){
                        charWindowMap.remove(inputChars[i]);
                    } else {
                        charWindowMap.put(inputChars[i],charWindowMap.get(inputChars[i]) - 1);
                    }
                }
                i++;
            }
        }
        if(j - i > max_length && charWindowMap.size() <= k){
            max_length = j-i;
        }
        return max_length;
    }

    public int lengthOfLongestSubstringKDistinctBak(String input, int k) {
        // Write your solution here
        if(input == null || input.length() <= 0 || k <= 0){
            return 0;
        }

        char[] inputChars = input.toCharArray();
        int i = 0;
        int j = 1;
        Map<Character,Integer> charWindowMap = new HashMap<Character,Integer>();
        charWindowMap.put(inputChars[0],1);
        int max_length = 1;
        while ( j < inputChars.length ){

            Iterator<Map.Entry<Character,Integer>> iter = charWindowMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Character,Integer> e = iter.next();
                System.out.println(e.getKey());
                System.out.println(e.getValue());
            }
            System.out.println("-------------");
            //System.out.println(charWindowMap.size());
            if(charWindowMap.size() <= k){

                if(j - i > max_length){
                    max_length = j-i;
                }

                if (charWindowMap.containsKey(inputChars[j])){
                    charWindowMap.put(inputChars[j],charWindowMap.get(inputChars[j]) + 1);
                } else {
                    charWindowMap.put(inputChars[j],1);
                }
                j++;
            } else {
                //System.out.println(i);
                //System.out.println(inputChars[i]);

                if (charWindowMap.get(inputChars[i]) != null ){
                    if(charWindowMap.get(inputChars[i]) == 1){
                        charWindowMap.remove(inputChars[i]);
                    } else {
                        charWindowMap.put(inputChars[i],charWindowMap.get(inputChars[i]) - 1);
                    }
                }
                i++;
            }
        }
        if(j - i > max_length && charWindowMap.size() <= k){
            max_length = j-i;
        }
        return max_length;
    }


    public static void main(String[] args){
        LongestSubstringwithAtMostKDistinctCharacters ls = new LongestSubstringwithAtMostKDistinctCharacters();
        //int result = ls.lengthOfLongestSubstringKDistinct("abbbbbbbddddefgh",2);
        //int result = ls.lengthOfLongestSubstringKDistinct("eceba",2);
        //int result = ls.lengthOfLongestSubstringKDistinct("aa",2);
        int result = ls.lengthOfLongestSubstringKDistinct("ccaabbb",2);
        //result = ls.lengthOfLongestSubstringKDistinct("jkfljddikpfvstdhpvobkeuczgplxghjkztwjhnvvrdcvwxarqvftxwofcdraxbwazvucjkjnlsnnvpfptftvtoapeeaajdyxmapuyyuwsbayiejxagwnqggwnzgeyjyzlgha",10);
        System.out.println(result);
    }
}
