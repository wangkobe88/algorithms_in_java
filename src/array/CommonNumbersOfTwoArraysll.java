package array;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by kewang on 31/10/18.
 */

/*
List排序：Collections.sort()
* */

public class CommonNumbersOfTwoArraysll {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here
        if(A == null || B == null) {
            return null;
        }

        Collections.sort(A);
        Collections.sort(B);

        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<Integer>();
        while(i < A.size() && j < B.size()) {
            if(A.get(i) == B.get(j)) {
                result.add(A.get(i));
                i++;
                j++;
                continue;
            }

            if(A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
