package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 4/10/18.
 */
public class Longest1ArrayWithKFlip {
    public int sub(String input, int flip){
        char[] inputChars = input.toCharArray();
        int i = 0;
        int j = 0;
        int fliped_count = 0;
        int max_length = 0;
        while (j < inputChars.length){
            System.out.println(i);
            System.out.println(j);
            System.out.println(fliped_count);
            System.out.println("********************");

            if(fliped_count > flip){
                if(inputChars[i] == '1'){
                    i++;
                }else {
                    fliped_count--;
                    i++;
                }
            } else if( inputChars[j] == '0') {
                fliped_count++;
                j++;
            } else {
                j++;
            }

            if (fliped_count <= flip &&(j - i) > max_length){
                max_length = (j -i);
            }

        }
        return max_length;
    }

    public static void main(String[] args) {
        Longest1ArrayWithKFlip a = new Longest1ArrayWithKFlip();
        int result = 0;
        result = a.sub("11101110111000111", 2);
        System.out.println(result);
    }

}
