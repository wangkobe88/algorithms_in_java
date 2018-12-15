package dynamic_programming;

/**
 * Created by kewang on 10/11/18.
 */
//还可以通过从某个字符开始往外扩的方式解决。
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        char[] sChars = s.toCharArray();
        int count = 0;
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
                if(results[i][j] == true){
                    count++;
                }
            }
        }
        return count;
    }
}
