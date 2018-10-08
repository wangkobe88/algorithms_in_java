package dfs;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kewang on 26/9/18.
 */
public class CombinationsOfCoins {

    private void dfs(int level, int sum, int target, int[] coins, List<Integer> result, List<List<Integer>> results){
        //System.out.println(sum);
        //System.out.println(target);
        if (sum == target && level == coins.length){
            List<Integer> resultCopy = new ArrayList<>();
            for(Integer resultValue : result){
                resultCopy.add(resultValue);
            }
            results.add(resultCopy);
        }

        if(level < coins.length){
            for(int i = 0 ; i <= (target - sum)/coins[level]; i++){
                result.add(i);
                dfs(level + 1, sum + i*coins[level], target, coins, result, results);
                result.remove(result.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        int level = 0;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int sum = 0;
        dfs(level, sum, target, coins, new ArrayList<Integer>(), results);
        return results;
    }

    public static void main(String[] args) {
        CombinationsOfCoins combinationsOfCoins = new CombinationsOfCoins();
        //kClosestInSortedArray.kClosest(new int[]{1,5}, 10, 1);
        List<List<Integer>> results = combinationsOfCoins.combinations(1, new int[]{25,10,5,1});
        for (List<Integer> s : results){
            for (Integer e : s) {
                System.out.println(e);
            }
        }
    }
}

