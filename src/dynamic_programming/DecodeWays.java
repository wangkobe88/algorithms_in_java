package dynamic_programming;

/**
 * Created by kewang on 9/11/18.
 */
/*没有从一开始想到用DP。
1维DP，要获取某一个长度上的某一个信息，通过之前的状态通过各种转化得到，可以用DP
*/
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        char[] sChars = s.toCharArray();
        int[] results = new int[sChars.length];
        if(sChars[0] == '0') {
            return 0;
        } else {
            results[0] = 1;
        }

        for (int i = 1; i < sChars.length; i++){
            int current = sChars[i] - '0';
            int previous = sChars[i-1] - '0';

            if(current == 0) {
                if(previous > 2 || previous == 0){
                    return 0;
                } else {
                    if( (i-2) >= 0) {
                        results[i] = results[i-2];
                    } else {
                        results[i] = 1;
                    }
                }
            } else {
                int linkNumber = (sChars[i-1] - '0') * 10 + sChars[i] - '0';
                if(linkNumber >= 1 && linkNumber <= 26) {
                    if(sChars[i-1] == '0'){
                        results[i] = results[i-1];
                    } else {
                        if( (i-2) >= 0) {
                            results[i] = results[i-1] + results[i-2];
                        } else {
                            results[i] = results[i-1] + 1;
                        }
                    }
                } else {
                    results[i] = results[i-1];
                }
            }
        }
        return results[sChars.length - 1];
    }
}
