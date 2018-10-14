package dynamic_programming;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by kewang on 12/10/18.
 */
public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        // Write your solution here
        if(input == null || input.length() == 0) {
            return false;
        }
        Set<String> dictSet = new HashSet<String>();
        for(String word : dict){
            dictSet.add(word);
        }

        boolean[] results = new boolean[input.length()];
        results[0] = dictSet.contains(input.substring(0,1));
        for(int i = 1; i < input.length(); i++){
            results[i] = false;
            if(dictSet.contains( input.substring(0,i+1) )) {
                results[i] = true;
                continue;
            }
            for(int j = 0; j <= i; j++){
                if(results[j] && dictSet.contains(input.substring(j+1,i+1)) == true){
                    results[i] = true;
                    break;
                }
            }
        }
        return results[input.length() - 1];
    }
}
