package math;

/**
 * Created by kewang on 9/10/18.
 */
public class PowerOf {
    public long power(int a, int b) {
        // Write your solution here
        if( b == 0 ){
            return 1;
        } else {
            long half_power= power(a, b/2);
            if( b%2 == 0) {
                return half_power * half_power;
            } else {
                return half_power * half_power * a;
            }
        }
    }
}
