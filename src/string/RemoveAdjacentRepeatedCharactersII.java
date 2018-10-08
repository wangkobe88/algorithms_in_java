package string;

/**
 * Created by kewang on 1/10/18.
 */
public class RemoveAdjacentRepeatedCharactersII {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1){
            return input;
        }

        char[] values = input.toCharArray();
        int i = 1;
        int j = 1;
        int count = 0;
        while ( j < values.length){
            count = 0;
            while (j < values.length && values[j] == values[i-1] ) {
                j++;
                count++;
            }
            if (count >= 1){
                values[i] = values[i-1];
                i++;
            }

            if( j >= values.length ){
                break;
            }

            if(values[j] != values[i-1]) {
                values[i++] = values[j++];
            }
        }
        return new String(values).substring(0,i);
    }
}
