package dfs;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 29/10/18.
 */

/*
* 获取一个数字的factor逻辑需要熟悉，尤其是从2开始 ;
* array是length,String是length(),List是size();
* 本程序后期需要重写。
* */

public class AllFactorsOfANumber {
    private List<Integer> getResult(List<Integer> factorNumbers, List<Integer> counts){
        List<Integer> result = new ArrayList();
        for (int i = 0; i < factorNumbers.size(); i++){
            for(int j = 0; j < counts.get(i); j++){
                result.add(factorNumbers.get(i));
            }
        }
        return result;
    }

    private void factors(int level, int n, List<Integer> factorNumbers, List<Integer> result, List<List<Integer>> results) {
        if(level == factorNumbers.size()) {
            if( n == 1) {
                results.add( getResult(factorNumbers, result) );
            }
            return;
        }

        int factor = factorNumbers.get(level);
        int count = 0;
        while (n > 0) {
            result.add(count);
            factors(level + 1, n, factorNumbers, result, results);
            result.remove(result.size() - 1);

            count += 1;
            if(n%factor == 0){
                n = n/factor;
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> factors(int n) {
        // Write your solution here
        if(n < 2) {
            return null;
        }
        List<Integer> factorNumbers = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++){
            if(n%i == 0) {
                factorNumbers.add(i);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        factors(0, n , factorNumbers, result, results);
        return results;
    }
}
