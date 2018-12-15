package dfs;

/**
 * Created by kewang on 9/11/18.
 */
public class DecodeWaysBadMethod {
    private void numDecodings(char[] sChars, int level, int[] count) {
        if(level >= sChars.length) {
            count[0]++;
            return;
        }
        if(sChars[level] != '0') {
            numDecodings(sChars, level + 1, count);
        }
        if( sChars[level] != '0' && (level + 1) < sChars.length) {
            int number = (sChars[level] - '0') * 10 + (sChars[level + 1] - '0');
            if(number >= 1 && number <= 26) {
                numDecodings(sChars, level + 2, count);
            }
        }

    }
    public int numDecodings(String s) {
        if(s == null) {
            return 0;
        }

        int[] count = new int[1];
        numDecodings(s.toCharArray(), 0, count);
        return count[0];
    }
}
