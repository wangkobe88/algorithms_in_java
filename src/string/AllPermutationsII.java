package string;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by kewang on 4/10/18.
 */

public class AllPermutationsII {
    private void swap(char[] inputChars, int i, int j){
        char temp = inputChars[i];
        inputChars[i] = inputChars[j];
        inputChars[j] = temp;
    }

    private void dfs(char[] inputChars, List<String> results, int level){
        if (level == inputChars.length - 1){
            results.add(new String(inputChars));
            return;
        }

        Set<Character> set_to_dedup = new HashSet<Character>();

        for (int i = level; i < inputChars.length; i++){
            if (!set_to_dedup.contains(inputChars[i])){
                set_to_dedup.add(inputChars[i]);
            } else {
                continue;
            }

            swap(inputChars, level, i);
            dfs(inputChars, results, level + 1);
            swap(inputChars, level, i);
        }
    }

    public List<String> permutations(String set) {
        // Write your solution here
        char[] inputChars = set.toCharArray();
        List<String> results = new ArrayList<String>();
        dfs(inputChars, results, 0);
        return results;
    }

    public static void main(String[] args){
        AllPermutationsII allPermutationsII = new AllPermutationsII();
        List<String> results = allPermutationsII.permutations("aabc");
        for (String s : results){
            System.out.println(s);
        }
    }
}
