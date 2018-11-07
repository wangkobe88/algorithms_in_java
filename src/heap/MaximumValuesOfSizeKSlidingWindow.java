package heap;
import java.util.*;
/**
 * Created by kewang on 2/11/18.
 */
public class MaximumValuesOfSizeKSlidingWindow {
    class Element{
    int value;
    int index;
    Element(int value, int index){
      this.value = value;
      this.index = index;
    }
  }
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here
    if(array == null || array.length < k) {
      //threw exception
    }

    PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
      public int compare(Element e1, Element e2) {
        if(e1.value > e2.value) {
          return -1;
        } else if(e1.value < e2.value) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    int right = 0;
    List<Integer> result = new ArrayList<Integer>();
    while(right < array.length) {
      if(right < (k-1)) {
        pq.offer(new Element(array[right], right));
        right++;
        continue;
      }

      pq.offer(new Element(array[right], right));
      while(!pq.isEmpty() && pq.peek().index <= (right - k)) {
        pq.poll();
      }

      if(!pq.isEmpty()) {
        result.add(pq.peek().value);
      }
      right++;
    }
    return result;
  }
}
