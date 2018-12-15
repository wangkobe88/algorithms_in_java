package dynamic_programming;

/**
 * Created by kewang on 14/12/18.
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n <= 0) {
            return 0;
        }
        int[] results = new int[n + 1];
        results[0] = 1;
        results[1] = 1;
        for(int i = 2; i <= n; i++) {
            results[i] = results[i-1] + results[i-2];
        }
        return results[n];
    }
}
