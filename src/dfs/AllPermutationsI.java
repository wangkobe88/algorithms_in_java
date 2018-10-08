package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 26/9/18.
 */
public class AllPermutationsI {
    private void swap(char[] setChars, int level, int i){
        char temp = setChars[level];
        setChars[level] = setChars[i];
        setChars[i] = temp;
    }

    private void dfs(char[] setChars, int level, List<String> results){
        if (level == setChars.length){
            results.add(new String(setChars));
        }

        for (int i = level ; i < setChars.length ; i++){
            swap(setChars, level, i);
            dfs(setChars, level + 1, results);
            swap(setChars, level, i);
        }
    }

    public List<String> permutations(String set) {
        // Write your solution here
        if(set == null || set.length() == 0){
            return new ArrayList<String>();
        }

        char[] setChars = set.toCharArray();
        List<String> results = new ArrayList<String>();
        dfs(setChars,  0 , results);
        return results;

    }
}
