package dynamic_programming;

/**
 * Created by kewang on 5/11/18.
 */
public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        // Write your solution here
        if(source == null || target == null) {
            //threw exception;
        }

        // xaxxbxxcxxxX
        // yayybyyyyycY
        int[][] results = new int[source.length() + 1][target.length() + 1];
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();

        for(int i = 0; i <= sourceChars.length; i++) {
            for(int j = 0; j <= targetChars.length; j++){
                if(i == 0 || j == 0) {
                    results[i][j] = 0;
                    continue;
                }
                if(sourceChars[i - 1] == targetChars[j - 1]) {
                    results[i][j] = results[i - 1][j - 1] + 1;
                } else {
                    results[i][j] = Math.max(results[i - 1][j], results[i][j - 1]);
                }
            }
        }
        return results[sourceChars.length][targetChars.length];
    }
}
