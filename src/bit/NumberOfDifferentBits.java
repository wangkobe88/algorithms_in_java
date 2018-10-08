package bit;

/**
 * Created by kewang on 6/10/18.
 */
public class NumberOfDifferentBits {
    public static int diffBits(int a, int b) {
        // Write your solution here
        int temp = a^b;
        int count = 0;
        int bit_set = 1;
        for (int i = 0; i < 32; i++){
            if ( (temp & bit_set) == 1) {
                count++;
            }
            temp = temp>>1;
        }
        return count;
    }

    public static int diffBitsV2(int a, int b) {
        // Write your solution here
        int temp = a^b;
        int count = 0;
        for (int i = 0; i < 32; i++){
            count += temp&1;
            temp = temp >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(NumberOfDifferentBits.diffBits(15, 0));
        System.out.println(NumberOfDifferentBits.diffBitsV2(2147483647, -2147483648));
    }
}
