package dynamic_programming;

/**
 * Created by kewang on 5/11/18.
 */
/**
 *
 * 两个字符串之间关系，往往用DP。
 * 采用的临时结果往往从空字符串开始，需要做特殊处理。
 * */
public class LongestCommonSubstring {

    public String longestCommon(String source, String target) {
        // Write your solution here
        if(source == null || target == null) {
            return null;
        }
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        int[][] results = new int[sourceChars.length + 1][targetChars.length + 1];
        int maxLength = 0;
        int sourceEnd = 0;
        int targetEnd = 0;
        for(int i = 0; i <= sourceChars.length; i++) {
            for(int j = 0; j <= targetChars.length; j++) {
                if(i == 0 || j == 0) {
                    results[i][j] = 0;
                    continue;
                }

                if(sourceChars[i - 1] == targetChars[j - 1]) {
                    results[i][j] = results[i - 1][j - 1] + 1;
                    if(maxLength < results[i][j]) {
                        maxLength = results[i][j];
                        sourceEnd = i - 1;
                        targetEnd = j - 1;
                    }
                } else {
                    results[i][j] = 0;
                }
            }
        }

        StringBuilder tempResult = new StringBuilder();
        while(sourceEnd >= 0 && targetEnd >= 0 && sourceEnd < sourceChars.length && targetEnd < targetChars.length && sourceChars[sourceEnd] == targetChars[targetEnd]) {
            tempResult.append(sourceChars[sourceEnd]);
            sourceEnd--;
            targetEnd--;
        }
        return tempResult.reverse().toString();
    }
}
