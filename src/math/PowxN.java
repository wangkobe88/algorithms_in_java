package math;

/**
 * Created by kewang on 12/11/18.
 */
public class PowxN {
    public double myPow(double x, int n) {
        if(x == 1 || n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if(n < 0) {
            return 1.0d/(x*myPow(x,-1*n -1));
        } else {
            return (n&1) > 0 ? x*myPow(x*x,n>>1) : myPow(x*x,n>>1);
        }
    }
}
