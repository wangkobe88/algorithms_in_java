package dfs;

/**
 * Created by kewang on 24/10/18.
 */
public class MergeStones {
    public int minCost(int[] stones) {
        // Write your solution here
        if(stones == null || stones.length == 0) {
            return 0;
        }
        int[][] tempResults = new int[stones.length][stones.length];
        for (int i = stones.length - 1; i >= 0; i--) {
            for (int j = i ; j <= stones.length - 1; j++) {
                if(i == j){
                    tempResults[i][j] = 0;
                    continue;
                }

                int weightBetween = 0;
                for(int k = i; k <= j; k++) {
                    weightBetween += stones[k];
                }


                tempResults[i][j] = Integer.MAX_VALUE;
                for (int k = i ; k <= (j-1); k++){
                    tempResults[i][j] = Math.min(tempResults[i][j], tempResults[i][k] + tempResults[k+1][j] + weightBetween);
                }
            }
        }
        return tempResults[0][stones.length - 1];
    }
}
