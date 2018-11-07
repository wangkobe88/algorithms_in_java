package string;
import java.util.*;
/**
 * Created by kewang on 6/11/18.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || (s.length() < p.length())) {
            //threw exception
            return new ArrayList<Integer>();
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
        Map<Character,Integer> sMap = new HashMap<Character,Integer>();
        int i = 0;

        while(i < sChars.length) {
            if( sMap.containsKey(sChars[i]) ) {
                sMap.put(sChars[i], sMap.get(sChars[i]) + 1);
            } else {
                sMap.put(sChars[i], 1);
            }

            if(i >= pChars.length) {
                int count = sMap.get(sChars[i - pChars.length]);
                if(count == 1) {
                    sMap.remove(sChars[i - pChars.length]);
                } else {
                    sMap.put(sChars[i - pChars.length], count - 1);
                }
            }

            if(pMap.containsKey(sChars[i]) && sMap.equals(pMap)) {
                result.add(i - pChars.length + 1);
            }
            i++;
        }
        return result;
    }
}
