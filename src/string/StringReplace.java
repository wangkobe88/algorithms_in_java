package string;

/**
 * Created by kewang on 3/10/18.
 */
public class StringReplace {

    private void swap(char[] inputChars, int left, int right){
        char temp = inputChars[left];
        inputChars[left] = inputChars[right];
        inputChars[right] = temp;
    }

    private boolean isEqueal(char[] inputChars,int start,char[] sourceChars){
        int i = 0;
        while(start < inputChars.length && i < sourceChars.length){
            if (inputChars[start] != sourceChars[i]){
                return false;
            } else {
                start++;
                i++;
            }
        }

        if(i == sourceChars.length){
            return true;
        } else {
            return false;
        }
    }

    private void putInPlace(char[] inputChars,int start,char[] targetChars){
        int i = 0;
        while(i < targetChars.length){
            inputChars[start + i] = targetChars[i];
            i++;
        }
    }

    private int replaceFromStart(char[] inputChars, char[] sourceChars, char[] targetChars){
        int slow = 0;
        int fast = 0;
        while (fast < inputChars.length){
            if(isEqueal(inputChars,fast,sourceChars)) {
                putInPlace(inputChars, slow, targetChars);
                slow += targetChars.length;
                fast += sourceChars.length;
            } else {
                swap(inputChars, slow, fast);
                slow++;
                fast++;
            }
        }
        return slow;
    }

    public String replace(String input, String source, String target) {
        // Write your solution here
        if (input == null || source == null || target == null ||source.length() <= 0){
            return input;
        }

        char[] inputChars = input.toCharArray();
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();

        int slow = replaceFromStart(inputChars, sourceChars, targetChars);

        return new String(inputChars).substring(0,slow);

    }

    public static void main(String[] args) {
        StringReplace stringReplace = new StringReplace();
        System.out.println(stringReplace.replace("appledogapple", "apple", "cat"));
    }

}
