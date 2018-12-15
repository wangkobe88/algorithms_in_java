package dfs;
import java.util.*;
/**
 * Created by kewang on 11/11/18.
 */
public class WordLadderDFSSlowV2 {
    private boolean isValid(Map<String,Boolean> matchMap, String s1, String s2) {

        if(matchMap.containsKey(s1+s2)){
            return matchMap.get(s1+s2);
        }

        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                diff += 1;
            }
            if(diff > 1){
                break;
            }
        }
        matchMap.put(s1+s2,diff == 1);
        matchMap.put(s2+s1,diff == 1);
        return diff == 1;
    }

    private void ladderDFS(String beginWord, String endWord, List<String> wordList, Set<String> pathStrings,int[] minLength, Map<String,Boolean> matchMap) {
        System.out.println(beginWord);
        if(pathStrings.size() >= minLength[0] || pathStrings.size() == (wordList.size() + 1)) {
            return;
        }

        if(beginWord.equals(endWord)) {
            minLength[0] = Math.min(minLength[0], pathStrings.size());
            return;
        }

        for(String word : wordList) {
            if(!pathStrings.contains(word) && isValid(matchMap, beginWord, word)) {
                pathStrings.add(word);
                ladderDFS(word, endWord, wordList, pathStrings, minLength, matchMap);
                pathStrings.remove(word);
            }
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null) {
            return 0;
        }

        Set<String> pathStrings = new HashSet<String>();
        pathStrings.add(beginWord);
        int[] minLength = new int[1];
        minLength[0] = Integer.MAX_VALUE;
        Map<String,Boolean> matchMap = new HashMap<String,Boolean>();
        //initMatchMap(matchMap,wordList);
        ladderDFS(beginWord, endWord, wordList, pathStrings, minLength, matchMap);

        return minLength[0] == Integer.MAX_VALUE ? 0 : minLength[0];
    }

    public static void main(String[] args){
        WordLadderDFSSlowV2 w = new WordLadderDFSSlowV2();
        long start = System.currentTimeMillis();
        w.ladderLength("qa","sq", Arrays.asList(new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"}));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
