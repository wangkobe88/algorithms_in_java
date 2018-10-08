package stack; /**
 * Created by kewang on 20/9/18.
 */
import java.util.LinkedList;
public class SortWith3Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        // Write your solution here.

        while( ! s1.isEmpty()){
            Integer minValue = Integer.MAX_VALUE;
            while( ! s1.isEmpty()){
                Integer currentValue = s1.pop();
                if (currentValue < minValue){
                    minValue = currentValue;
                }
                s3.push(minValue);
            }

            while( ! s3.isEmpty()){
                Integer currentValue = s3.peek();
                if (currentValue.equals(minValue)){
                    s2.push(currentValue);
                }else{
                    s1.push(currentValue);
                }
            }
        }
    }

    public void sortV2(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        // Write your solution here.

        while( !s1.isEmpty()){
            Integer maxValue = Integer.MIN_VALUE;
            while( ! s1.isEmpty()){
                Integer currentValue = s1.pop();
                if (currentValue > maxValue){
                    maxValue = currentValue;
                }
                s3.push(maxValue);
            }
            while( ! s3.isEmpty()){
                Integer currentValue = s3.peek();
                if (currentValue.equals(maxValue)){
                    s2.push(currentValue);
                }else{
                    s1.push(currentValue);
                }
            }
        }

        while( !s3.isEmpty()){
            s1.push(s3.pop());
        }
    }

}
