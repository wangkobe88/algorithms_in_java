package dynamic_programming;

/**
 * Created by kewang on 18/10/18.
 */
public class MinimumCutsForPalindromes {
    private boolean isPalindrome(char[] inputCharArray, int left, int right){
        while(left < right){
            if(inputCharArray[right] != inputCharArray[left]){
                return false;
            } else {
                left ++;
                right --;
            }
        }
        return true;
    }

    public int minCuts(String input) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return 0;
        }
        char[] inputCharArray = input.toCharArray();
        int[] minCurrentCuts = new int[inputCharArray.length];
        minCurrentCuts[0] = 0;

        for(int i = 1; i < inputCharArray.length; i++){

            if(isPalindrome(inputCharArray, 0, i)){
                minCurrentCuts[i] = 0;
                continue;
            }

            int minCutCount = inputCharArray.length;
            for(int j = 0; j <= i-1; j++){
                if(isPalindrome(inputCharArray, j + 1, i)){
                    if( (minCurrentCuts[j] + 1) < minCutCount ) {
                        minCutCount = minCurrentCuts[j] + 1;
                    }
                }
            }
            minCurrentCuts[i] = minCutCount;
        }
        return minCurrentCuts[inputCharArray.length - 1];
    }

    public static void main(String[] args){
        new MinimumCutsForPalindromes().minCuts("ab");
    }
}
