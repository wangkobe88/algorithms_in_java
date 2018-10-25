package dfs;

/**
 * Created by kewang on 24/10/18.
 */
public class CuttingWoodI {

    public int minCost(int[] cuts, int length) {
        // Write your solution here

        if(cuts == null || cuts.length == 0) {
            return 0;
        }

        int[] extendCuts = new int[cuts.length + 2];
        extendCuts[0] = 0;
        extendCuts[extendCuts.length - 1] = length;
        for (int i = 0; i < cuts.length; i++) {
            extendCuts[i+1] = cuts[i];
        }

        int[][] tempResults = new int[extendCuts.length][extendCuts.length];

        for (int i = extendCuts.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= extendCuts.length - 1; j++) {
                if((i + 1) == j){
                    tempResults[i][j] = 0;
                    continue;
                }

                tempResults[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1 ; k <= (j-1); k++){
                    tempResults[i][j] = Math.min(tempResults[i][j], tempResults[i][k] + tempResults[k][j] + extendCuts[j] - extendCuts[i]);
                }
            }
        }
        return tempResults[0][extendCuts.length - 1];
    }

}
