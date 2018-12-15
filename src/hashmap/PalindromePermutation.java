package hashmap;
import java.util.*;
/**
 * Created by kewang on 10/11/18.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if(s == null) {
            return true;
        }

        Set<Character> charSet = new HashSet<Character>();

        for(char c : s.toCharArray()){
            if(!charSet.contains(c)){
                charSet.add(c);
            } else {
                charSet.remove(c);
            }
        }

        if(charSet.size() <= 1) {
            return true;
        } else {
            return false;
        }
    }
}
