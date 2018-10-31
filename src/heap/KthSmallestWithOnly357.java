package heap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Created by kewang on 31/10/18.
 */
/*
* Comparator实现public int compare() 函数；
* 整数的指数需要自己写函数；
* BFS2遍历结点时，需要想办法去重复。
* */
public class KthSmallestWithOnly357 {

    class Element{
        int x;
        int y;
        int z;
        long value;

        long power(int a, int b) {
            long result = 1;
            for(int i = 0; i < b; i++){
                result *= a;
            }
            return result;
        }

        Element(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            value = power(3,x) * power(5,y) * power(7,z);
        }
    }

    public long kth(int k) {
        // Write your solution here
        if (k < 1) {
            return 0l;
        }

        Element first = new Element(1, 1, 1);
        PriorityQueue<Element> heap = new PriorityQueue<Element>(new Comparator<Element>(){
            public int compare(Element e1, Element e2) {
                if(e1.value < e2.value) {
                    return -1;
                } else if (e1.value > e2.value) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        heap.offer(first);
        Set<Long> set = new HashSet<Long>();
        int count = 0;
        Element current = null;
        while(count < k) {
            current = heap.poll();
            Element e1 = new Element(current.x + 1, current.y, current.z);
            if(!set.contains(e1.value)) {
                heap.offer(e1);
                set.add(e1.value);
            }

            Element e2 = new Element(current.x, current.y + 1, current.z);
            if(!set.contains(e2.value)) {
                heap.offer(e2);
                set.add(e2.value);
            }

            Element e3 = new Element(current.x, current.y, current.z + 1);
            if(!set.contains(e3.value)) {
                heap.offer(e3);
                set.add(e3.value);
            }

            count++;
        }
        return current.value;
    }

}
