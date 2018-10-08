package bit;

/**
 * Created by kewang on 6/10/18.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int number) {
        // Write your solution here
        if(number <= 0) {
            return false;
        }

        while (number > 1) {
            if( number%2 != 0){
                return false;
            }
            number = number/2;
        }
        return true;
    }

    public boolean isPowerOfTwoV2(int number) {
        // Write your solution here
        if(number <= 0) {
            return false;
        }
        return (number&(number-1)) == 0;
    }
    public boolean isPowerOfTwoV3(int number) {
        // Write your solution here
        return number > 0 && (number&(number-1)) == 0;
    }
}
