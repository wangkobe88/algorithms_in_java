package string;

/**
 * Created by kewang on 30/9/18.
 */
public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1){
            return input;
        }

        char[] values = input.toCharArray();
        int i = 1;
        int j = 1;
        while ( j < values.length){
            if ( values[j] == values[i-1] ){
                j++;
            } else {
                values[ i++ ] = values[ j++ ];
            }
            System.out.println(values);
        }
        return new String(values).substring(0, i);
    }
    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharactersI removeAdjacentRepeatedCharactersI = new RemoveAdjacentRepeatedCharactersI();
        System.out.println(removeAdjacentRepeatedCharactersI.deDup("abc"));
    }
}
