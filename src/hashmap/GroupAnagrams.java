package hashmap;
import java.util.*;
/**
 * Created by kewang on 13/12/18.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) {
            return results;
        }

        Map<String,List<String>> tempMap = new HashMap<String,List<String>>();
        for(String s : strs) {
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            String ns = new String(sChars);
            List<String> sList = tempMap.get(ns);
            if (sList == null) {
                sList = new ArrayList<String>();
                tempMap.put(ns,sList);
            }
            sList.add(s);
        }

        for(List<String> sList : tempMap.values()){
            results.add(sList);
        }
        return results;
    }


    public List<List<String>> groupAnagramsV2(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        List<List<String>> results = new ArrayList<List<String>>();
        Map<Integer,List<String>> tempMap = new HashMap<Integer,List<String>>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> sList = tempMap.get(key);
            if (sList == null) {
                sList = new ArrayList<String>();
                tempMap.put(key, sList);
            }
            sList.add(s);
        }
        for(List<String> sList : tempMap.values()){
            results.add(sList);
        }
        return results;
    }
}
