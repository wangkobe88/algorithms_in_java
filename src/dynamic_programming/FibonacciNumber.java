package dynamic_programming;

/**
 * Created by kewang on 11/10/18.
 */
public class FibonacciNumber {
    public long fibonacci(int K){
        if(K == 0|| K == 1){
            return K;
        }

        long[] results = new long[K + 1];
        results[0] = 0;
        results[1] = 1;

        for (int i = 2; i <= K ; i++){
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[K];
    }
}
