package string;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by kewang on 1/10/18.
 */


public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here
        char[] inputChars = input.toCharArray();
        char[] tChars = t.toCharArray();
        Set<Character> tCharSet = new HashSet<Character>();
        for ( Character tChar : tChars){
            tCharSet.add(tChar);
        }

        int i = 0;
        for(int j = 0; j < inputChars.length; j++){
            if (!tCharSet.contains(inputChars[j])){
                inputChars[i++] = inputChars[j];
            }
        }

        return new String(inputChars).substring(0,i);
    }
}
