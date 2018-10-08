package bit;

/**
 * Created by kewang on 6/10/18.
 */
public class HexadecimalRepresentation {
    private char getChar(int digit){
        if (digit < 10){
            return (char)(digit + '0');
        } else{
            return (char)(digit - 10 + 'A');
        }
    }

    public String hex(int number) {
        // Write your solution here
        if(number < 0){
            return null;
        } else if (number == 0){
            return "0x0";
        }

        StringBuilder hexResult = new StringBuilder();
        while (number > 0){
            hexResult.append(getChar(number % 16));
            number = number/16;
        }
        return "0x"+hexResult.reverse().toString();
    }
}
