package math;
import java.util.List;

/**
 * Created by kewang on 17/10/18.
 */
public class Percentile95 {
    public int percentile95(List<Integer> lengths) {
        // Write your solution here.
        int[] lengthCount = new int[4096];
        for(Integer length : lengths){
            lengthCount[length]++;
        }

        int count = 0;
        int lengthIndex = 0;
        while(count < 0.95 * lengths.size()){
            count += lengthCount[lengthIndex++];
        }
        return (lengthIndex - 1);
    }
}
