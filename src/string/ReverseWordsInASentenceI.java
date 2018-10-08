package string;

/**
 * Created by kewang on 3/10/18.
 */
public class ReverseWordsInASentenceI {
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

    public String reverseWords(String input) {
        // Write your solution here
        if (input == null || input.length() < 1){
            return input;
        } else if(input.length() == 1 && input.equals(" ")){
            return "";
        }

        char[] inputChars = input.toCharArray();
        int left = 0;
        int right = 0;
        while ( right < inputChars.length){
            if (inputChars[right] != ' ' && right != inputChars.length - 1){
                right++;
            } else {
                if(right != inputChars.length - 1) {
                    reverse(inputChars, left, right - 1);
                } else {
                    reverse(inputChars, left, right);
                }
                right++;
                left = right;
            }
        }
        reverse(inputChars, 0, inputChars.length - 1);
        return new String(inputChars);
    }

    public String reverseWordsV2(String input) {
        // Write your solution here
        if (input == null || input.length() < 1){
            return input;
        } else if(input.length() == 1 && input.equals(" ")){
            return "";
        }

        char[] inputChars = input.toCharArray();
        int left = 0;
        int right = 0;
        while ( right <= inputChars.length){

            if (right == inputChars.length || inputChars[right] == ' '){
                reverse(inputChars, left, right - 1);
                right++;
                left = right;
            } else {
                right++;
            }
        }
        reverse(inputChars, 0, inputChars.length - 1);
        return new String(inputChars);
    }


    public static void main(String[] args) {
        ReverseWordsInASentenceI reverseWordsInASentenceI = new ReverseWordsInASentenceI();
        //System.out.println(reverseWordsInASentenceI.reverseWords("I love Yahoo"));
        System.out.println(reverseWordsInASentenceI.reverseWords(" ").length());
    }
}
