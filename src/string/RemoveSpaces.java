package string;

/**
 * Created by kewang on 30/9/18.
 */
public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }
        char[] inputChars = input.toCharArray();
        int i = 0;
        int j = 0;
        boolean start = true;

        while ( j < inputChars.length ) {
            if(start == true){
                while (j < inputChars.length && inputChars[j] == ' ' ){
                    j++;
                }
                if( j < inputChars.length ) {
                    inputChars[i++] = inputChars[j++];
                }else {
                    break;
                }
                start = false;
            }

            if( inputChars[j] == ' ' && inputChars[i-1] != ' '){
                inputChars[i++] = inputChars[j++];
            } else if (inputChars[j] == ' ' ){
                j++;
            } else if (inputChars[j] != ' '){
                inputChars[i++] = inputChars[j++];
            }
        }

        while ( (i-1) > 0 && inputChars[i-1] == ' ' ){
            i--;
        }

        return new String(inputChars).substring(0,i);
    }

    public String removeSpacesSolution2(String input) {
        // Write your solution here
        if(input == null || input.length() <= 1){
            return input;
        }
        char[] inputChars = input.toCharArray();
        int i = 0;
        int j = 0;

        while ( j < inputChars.length ) {

            while (j < inputChars.length && inputChars[j] == ' ' ){
                j++;
            }

            if( j >= inputChars.length ){
                break;
            }
            if (j < inputChars.length && inputChars[j] != ' '){
                while (j < inputChars.length && inputChars[j] != ' '){
                    inputChars[i++] = inputChars[j++];
                }
                if ( i < inputChars.length){
                    inputChars[i++] = ' ';
                }
            }
        }

        while ( (i-1) > 0 && inputChars[i-1] == ' ' ){
            i--;
        }

        return new String(inputChars).substring(0,i);
    }


    public static void main(String[] args) {
        RemoveSpaces removeSpaces = new RemoveSpaces();
        System.out.println(removeSpaces.removeSpacesSolution2(" I Love  Yahoo "));
    }
}
