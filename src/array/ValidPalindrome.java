package array;

/**
 * Created by kewang on 9/11/18.
 */
/*
* String转化为小写toLowerCase()
* 变量名不要写错。
* */
public class ValidPalindrome {
    private boolean judgeIsValid(char sChar) {
        if( (sChar >= '0' && sChar <= '9') || (sChar >= 'a' && sChar <= 'z')) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        char[] sChars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = sChars.length - 1;
        while(i < j){

            if (!judgeIsValid(sChars[i])) {
                i++;
                continue;
            } else if (!judgeIsValid(sChars[j])) {
                j--;
                continue;
            } else if(sChars[i] == sChars[j]) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
