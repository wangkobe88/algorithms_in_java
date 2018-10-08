package string;

/**
 * Created by kewang on 1/10/18.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }

        if (needle.length() == 0){
            return 0;
        }

        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        for ( int i = 0; i < haystackChars.length; i++){
            for ( int j = i; (j-i) < needleChars.length; j++){
                if (j >= haystackChars.length || haystackChars[j] != needleChars[j-i]) {
                    break;
                }
                if((j-i) == (needleChars.length - 1)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        //System.out.println(strStr.strStr("hello","ll"));
        System.out.println(strStr.strStr("mississippi","issippi"));
    }
}
