package string;
import java.util.*;
/**
 * Created by kewang on 14/12/18.
 */
public class MinimumWindowSubstring {
    private boolean compare(Map<Character,Integer> countMap, Map<Character,Integer> tMap) {
        if(countMap.size() < tMap.size()) {
            return false;
        }

        for(Character c : tMap.keySet()) {
            if(countMap.get(c) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if(s == null || t == null) {
            return "";
        }
        Map<Character,Integer> tMap = new HashMap<Character,Integer>();
        char[] tChars = t.toCharArray();
        for(char c : tChars) {
            tMap.put(c, tMap.getOrDefault(c,0) + 1);
        }
        Map<Character,Integer> countMap = new HashMap<Character,Integer>();
        char[] sChars = s.toCharArray();
        int start = 0;
        int end = 0;
        int minLength = sChars.length;
        int minStart = 0;
        int minEnd = 0;
        boolean isFound = false;
        while(end < sChars.length) {
            if(!tMap.containsKey(sChars[end])) {
                end++;
                continue;
            }

            countMap.put(sChars[end], countMap.getOrDefault(sChars[end],0) + 1);
            end++;

            if(isFound == false && !compare(countMap,tMap)){
                continue;
            }

            while(true) {
                if(!tMap.containsKey(sChars[start])) {
                    start++;
                    continue;
                }
                //System.out.println(start);
                int startCount = countMap.get(sChars[start]);
                if(startCount > tMap.get(sChars[start])) {
                    countMap.put(sChars[start],startCount - 1);
                    start++;
                } else {
                    if((end - start) <= minLength) {
                        isFound = true;
                        minLength = end - start;
                        minStart = start;
                        minEnd = end;
                    }
                    break;
                }
            }
        }
        //System.out.println(isFound);
        //System.out.println(minStart);
        //System.out.println(minEnd);
        if(isFound == true){
            return s.substring(minStart, minEnd);
        } else {
            return "";
        }
    }
}
