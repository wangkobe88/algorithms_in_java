package string;
import java.util.*;
/**
 * Created by kewang on 6/11/18.
 */
public class FindAllAnagramsInAStringSlow {
    private boolean judgeValid(char[] sChars, int start, int end, Map<Character,Integer> pMap) {
        Map<Character,Integer> sMap = new HashMap<Character,Integer>();
        for(int i = start; i <= end; i++) {
            if( sMap.containsKey(sChars[i]) ) {
                sMap.put(sChars[i],sMap.get(sChars[i]) + 1);
            } else {
                sMap.put(sChars[i],1);
            }
        }
        if(sMap.equals(pMap)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null) {
            //threw exception
        }

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        Map<Character,Integer> pMap = new HashMap<Character,Integer>();

        for(int i = 0; i < pChars.length; i++) {
            if( pMap.containsKey(pChars[i]) ) {
                pMap.put(pChars[i],pMap.get(pChars[i]) + 1);
            } else {
                pMap.put(pChars[i],1);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        int i = 0;
        while(i < sChars.length) {
            if(pMap.containsKey(sChars[i]) && i + pChars.length <= sChars.length) {
                if(judgeValid(sChars, i, i + pChars.length - 1, pMap) == true) {
                    result.add(i);
                }
            }
            i++;
        }
        return result;
    }
}
