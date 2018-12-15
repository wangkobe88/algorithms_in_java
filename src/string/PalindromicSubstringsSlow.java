package string;

/**
 * Created by kewang on 10/11/18.
 */
public class PalindromicSubstringsSlow {
    private boolean isPalindromic(char[] sChars,int i, int j) {
        while( i < j ) {
            if(sChars[i] != sChars[j]){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public int countSubstrings(String s) {
        char[] sChars = s.toCharArray();
        int count = 0;
        for(int i = 0; i < sChars.length; i++)  {
            for(int j = i; j < sChars.length; j++) {
                if(isPalindromic(sChars,i,j) == true){
                    count++;
                }
            }
        }
        return count;
    }
}
