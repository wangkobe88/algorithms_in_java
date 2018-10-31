package dfs;

/**
 * Created by kewang on 28/10/18.
 */

//错误1： 最后一层判断后直接返回，不再进行扩展。

public class TwoSubsetsWithMinDifference {
    private void minDirrerence(int[] array, int level, int count, int currentSum, int totalSum, int[] bestValue){
        if(count == array.length/2){
            int otherSum = totalSum - currentSum;
            if( Math.abs(otherSum - currentSum) < Math.abs(otherSum - bestValue[0]) ){
                bestValue[0] = currentSum;
            }
        }

        if(level == array.length){
            return;
        }

        minDirrerence(array, level + 1, count + 1, currentSum + array[level], totalSum, bestValue);
        minDirrerence(array, level + 1, count, currentSum, totalSum, bestValue);

    }
    public int minDifference(int[] array) {
        // Write your solution here
        if(array == null) {
            return 0;
        }
        int totalSum = 0;
        for(int i = 0; i < array.length; i++){
            totalSum += array[i];
        }
        int[] bestValue = new int[1];
        bestValue[0] = Integer.MAX_VALUE;
        minDirrerence(array, 0, 0, 0, totalSum, bestValue);
        return Math.abs(totalSum - bestValue[0] - bestValue[0]);
    }
}
