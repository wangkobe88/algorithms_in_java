package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kewang on 3/10/18.
 */
public class StringShuffling {

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

    public String shuffling(String input) {
        char[] inputChars = input.toCharArray();
        Arrays.sort(inputChars);

        reverse(inputChars, 0, inputChars.length/2 - 1);
        reverse(inputChars, inputChars.length/2, inputChars.length - 1);
        reverse(inputChars, 0, inputChars.length - 1);

        return new String(inputChars);
    }

    public void shufflingV2(char[] inputChars, int left, int right){

        if(left >= right - 1){
            return;
        }

        int length = right - left + 1;

        //System.out.println(left);
        //System.out.println(right);

        int left_mid = left + length/4;
        int mid =  left + length/2;
        int right_mid = left + length*3/4;

        reverse(inputChars, left_mid, mid - 1);
        reverse(inputChars, mid, right_mid - 1);
        reverse(inputChars, left_mid, right_mid - 1);

        shufflingV2(inputChars, left, left + 2*(left_mid - left) - 1);
        shufflingV2(inputChars, left + 2*(left_mid - left) , right);
    }

    public String shufflingV2(String input) {
        char[] inputChars = input.toCharArray();

        shufflingV2(inputChars, 0, inputChars.length - 1);
        return new String(inputChars);
    }

    public static void main(String[] args) {
        StringShuffling stringShuffling = new StringShuffling();
        //System.out.println(stringShuffling.shuffling("a1b2c3d4"));

        System.out.println(stringShuffling.shufflingV2("abcde12345"));

        System.out.println(stringShuffling.shufflingV2("abcdef123456"));

    }
}
