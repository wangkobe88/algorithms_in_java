package string;

/**
 * Created by kewang on 9/10/18.
 */
public class ReverseStringRecuersion {
    private void swap(char[] inputChars, int start, int end){
        char temp = inputChars[start];
        inputChars[start] = inputChars[end];
        inputChars[end] = temp;
    }
    private void reverse(char[] inputChars, int start, int end){
        if(start >= end) {
            return;
        }
        if(inputChars[start] != inputChars[end]){
            swap(inputChars, start, end);
        }
        reverse(inputChars, start + 1, end - 1);
    }

    public String reverse(String input) {
        // Write your solution here
        char[] inputChars = input.toCharArray();
        int start = 0;
        int end = inputChars.length - 1;
        reverse(inputChars, start, end);
        return new String(inputChars);
    }
}
