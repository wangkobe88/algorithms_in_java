package dynamic_programming;

/**
 * Created by kewang on 10/11/18.
 */
public class LongestPalindromicSubstring {
    public String getString(char[] sChars, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= end; i++){
            sb.append(sChars[i]);
        }
        return sb.toString();
    }

    public String longestPalindrome(String s) {
        if(s == null ) {
            return null;
        }
        char[] sChars = s.toCharArray();
        int maxLength = 0;
        String maxSubString = "";
        boolean[][] results = new boolean[sChars.length][sChars.length];

        for(int i = sChars.length - 1; i >= 0; i--)  {
            for(int j = i; j < sChars.length; j++) {
                if(i == j) {
                    results[i][j] = true;
                } else if(j == (i+1)) {
                    results[i][j] = (sChars[i] == sChars[j]);
                } else{
                    results[i][j] = results[i+1][j-1] && (sChars[i] == sChars[j]);
                }

                if(results[i][j] == true && (j-i) >= maxLength) {
                    maxSubString = getString(sChars,i,j);
                    maxLength = (j-i);
                }
            }
        }
        return maxSubString;
    }
}
