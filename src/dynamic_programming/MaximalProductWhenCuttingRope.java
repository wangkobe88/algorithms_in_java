package dynamic_programming;

/**
 * Created by kewang on 11/10/18.
 */
public class MaximalProductWhenCuttingRope {

    public int maxProduct(int length) {
        if(length == 1 || length  == 0){
            return 0;
        }
        int[] results = new int[length + 1];
        results[1] = 0;
        for (int i = 2; i < length + 1; i++){
            for (int j = 1; j < i; j++) {
                results[i] = Math.max(results[i], j * Math.max(i - j, results[i - j]));
            }
        }
        return results[length];
    }
}
