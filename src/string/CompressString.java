package string;

/**
 * Created by kewang on 4/10/18.
 */
public class CompressString {

    private void swap(char[] inputChars, int left, int right){
        char temp = inputChars[left];
        inputChars[left] = inputChars[right];
        inputChars[right] = temp;
    }

    private void reverse(char[] inputChars, int left, int right){
        while(left < right){
            swap(inputChars, left, right);
            left++;
            right--;
        }
    }

    private char[] int2charArray(int digit){
        char[] results = new char[10];
        int i = 0;
        while(digit != 0){
            results[i++] = Character.forDigit(digit%10,10);
            digit = digit/10;
        }
        //reverse(results, 0, i-1);
        char[] finalResult = new char[i];
        for(int j = 0; j < finalResult.length; j++){
            finalResult[j] = results[i-j-1];
        }
        return finalResult;
    }

    public String compress(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1){
            return input;
        }

        char[] inputChars = input.toCharArray();
        int i = 1;
        int j = 1;
        int count = 1;

        while (j < inputChars.length){
            if (inputChars[j] == inputChars[i-1]) {
                j++;
                count++;
            } else {
                if (count != 1) {
                    for(char digit : int2charArray(count)) {
                        inputChars[i++] = digit;
                    }
                }
                count = 1;
                inputChars[i++] = inputChars[j++];
            }
        }
        if(count != 1) {
            for(char digit : int2charArray(count)) {
                inputChars[i++] = digit;
            }
        }
        return new String(inputChars).substring(0,i);
    }

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        //System.out.println(reverseWordsInASentenceI.reverseWords("I love Yahoo"));
        System.out.println(compressString.compress("aaaabbbdddcccccc"));
        System.out.println(compressString.compress("shekmqyxupwmmtptilvbji"));
        System.out.println(compressString.compress("ffffffffffffffnnnnnnnnnnnnnnnnnnnnnmmmmmmmmmmmmmmmmmmmmmmmmccccccccccccccccccccccrrrrrrrrrrrrrrrdddddd"));
    }
}
