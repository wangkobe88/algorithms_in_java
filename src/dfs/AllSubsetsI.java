package dfs;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by kewang on 26/9/18.
 */
public class AllSubsetsI {
    private void dfs (String set, int level, String subSet, List<String> results){
        if ( level == set.length() ){
            results.add(subSet);
        }

        if ( level < set.length() ){
            subSet += set.charAt(level);
            dfs(set, level + 1, subSet, results);
            subSet = subSet.substring(0, subSet.length() - 1);

            dfs(set, level + 1, subSet, results);
        }
    }
    public List<String> subSets(String set) {
        // Write your solution here.
        if ( set == null ) {
            return new ArrayList<String>();
        }
        List<String> results = new ArrayList<String>();
        dfs(set, 0, new String(), results);
        return results;
    }
}
