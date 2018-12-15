package dynamic_programming;

/**
 * Created by kewang on 14/12/18.
 */
public class EditDistanceV2 {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return 0;
        }

        int[][] results = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i <= word1.length(); i++) {
            for(int j = 0; j <= word2.length(); j++) {
                if(i == 0) {
                    results[i][j] = j;
                } else if (j == 0) {
                    results[i][j] = i;
                } else if (word1.charAt(i-1) == word2.charAt(j-1)){
                    results[i][j] = results[i-1][j-1];
                } else{
                    results[i][j] = Math.min(Math.min(results[i-1][j], results[i-1][j-1]),results[i][j-1]) + 1;
                }
            }
        }

        return results[word1.length()][word2.length()];
    }
}
