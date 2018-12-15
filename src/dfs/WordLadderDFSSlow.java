package dfs;
import java.util.*;
/**
 * Created by kewang on 11/11/18.
 */
public class WordLadderDFSSlow {
    private boolean isValid(String s1, String s2) {
        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                diff += 1;
            }
        }
        return diff == 1;
    }

    private void ladderDFS(String beginWord, String endWord, List<String> wordList, Set<String> pathStrings,int[] minLength) {
        if(pathStrings.size() >= minLength[0]) {
            return;
        }

        if(beginWord.equals(endWord)) {
            minLength[0] = Math.min(minLength[0], pathStrings.size());
            return;
        }

        for(String word : wordList) {
            if(!pathStrings.contains(word) && isValid(beginWord, word)) {
                pathStrings.add(word);
                ladderDFS(word, endWord, wordList, pathStrings, minLength);
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
        ladderDFS(beginWord, endWord, wordList, pathStrings, minLength);

        return minLength[0] == Integer.MAX_VALUE ? 0 : minLength[0];
    }
}
