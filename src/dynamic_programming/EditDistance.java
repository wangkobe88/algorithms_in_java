package dynamic_programming;

/**
 * Created by kewang on 12/10/18.
 */
public class EditDistance {
    public int editDistance(String one, String two) {
        // Write your solution here
        int[][] results = new int[one.length() + 1][two.length() + 1];

        for(int i = 0; i <= one.length(); i++) {
            for(int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    results[i][j] = j;
                } else if (j == 0) {
                    results[i][j] = i;
                } else if ( one.charAt(i-1) == two.charAt(j-1) ) {
                    results[i][j] = results[i - 1][j - 1];
                } else {
                    results[i][j] = 1 + Math.min( Math.min(results[i][j - 1], results[i - 1][j]), results[i - 1][j - 1]);
                }
            }
        }
        return results[one.length()][two.length()];
    }
}
