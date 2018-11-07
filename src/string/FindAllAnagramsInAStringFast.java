package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kewang on 6/11/18.
 */
public class FindAllAnagramsInAStringFast {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || (s.length() < p.length())) {
            return new ArrayList<Integer>();
        }

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        int[] pMap = new int[26];
        for(int i = 0; i < pChars.length; i++) {
            pMap[pChars[i] - 'a'] += 1;
        }

        List<Integer> result = new ArrayList<Integer>();
        int[] sMap = new int[26];
        int i = 0;
        while(i < sChars.length) {
            sMap[sChars[i] - 'a'] += 1;

            if(i >= pChars.length) {
                sMap[sChars[i - pChars.length] - 'a'] -= 1;
            }

            boolean match = true;
            for(int j = 0; j < 26; j++){
                //System.out.println(String.valueOf(sMap[j])  + String.valueOf(pMap[j]));
                if(sMap[j] != pMap[j]) {
                    match = false;
                    break;
                }
            }
            if(match == true){
                result.add(i - pChars.length + 1);
            }
            i++;
        }
        return result;
    }
}
