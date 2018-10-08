package string;

/**
 * Created by kewang on 3/10/18.
 */
public class StringReplaceV2 {

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

    private int countOccurs(char[] inputChars, char[] sourceChars){
        int count = 0;
        int fast = 0;
        while (fast < inputChars.length){
            if(isEqueal(inputChars, fast, sourceChars)) {
                count++;
                fast += sourceChars.length;
            } else {
                fast++;
            }
        }
        return count;
    }

    private void replaceFromStart(char[] inputChars, char[] results, char[] sourceChars, char[] targetChars){
        int slow = 0;
        int fast = 0;
        while (fast < inputChars.length){
            if(isEqueal(inputChars, fast,sourceChars)) {
                putInPlace(results, slow, targetChars);
                slow += targetChars.length;
                fast += sourceChars.length;
            } else {
                results[slow++] = inputChars[fast++];
            }
        }
    }

    public String replace(String input, String source, String target) {
        // Write your solution here
        if (input == null || source == null || target == null ||source.length() <= 0){
            return input;
        }

        char[] inputChars = input.toCharArray();
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        int count = countOccurs(inputChars, sourceChars);

        char[] results = new char[count*(target.length() - source.length()) + input.length()];
        replaceFromStart(inputChars, results, sourceChars, targetChars);

        return new String(results);

    }

    public static void main(String[] args) {
        StringReplaceV2 stringReplace = new StringReplaceV2();
        System.out.println(stringReplace.replace("appledogapple", "apple", "cat"));
    }

}
