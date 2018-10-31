package heap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kewang on 31/10/18.
 */
/*
* = 与 == 要区分好。
* */
public class KthClosestPointTo000 {
    class Element{
        int aIndex;
        int bIndex;
        int cIndex;
        int value;

        Element(int aIndex, int bIndex, int cIndex) {
            this.aIndex = aIndex;
            this.bIndex = bIndex;
            this.cIndex = cIndex;
            this.value = a[aIndex] * a[aIndex] + b[bIndex] * b[bIndex] + c[cIndex] * c[cIndex];
        }

        public boolean equals(Object other) {
            Element otherElement = (Element) other;
            if(otherElement.aIndex == this.aIndex && otherElement.bIndex == this.bIndex && otherElement.cIndex == this.cIndex) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode(){
            return this.aIndex * 911 + this.bIndex * 31 + this.cIndex;
        }
    }

    int[] a;
    int[] b;
    int[] c;

    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        if(a == null || b == null || c == null) {
            return null;
        }

        // Write your solution here
        this.a = a;
        this.b = b;
        this.c = c;

        PriorityQueue<Element> heap = new PriorityQueue<Element>( new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                if(e1.value < e2.value) {
                    return -1;
                } else if( e1.value > e2.value ) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        heap.offer(new Element(0,0,0));
        Set<Element> set = new HashSet<Element>();
        int count = 0;
        Element current = null;
        while(!heap.isEmpty() && count < k) {
            current = heap.poll();

            if ((current.aIndex + 1) < a.length) {
                Element e1 = new Element(current.aIndex + 1, current.bIndex, current.cIndex);
                if(!set.contains(e1)){
                    set.add(e1);
                    heap.offer(e1);
                }
            }


            if ( (current.bIndex + 1) < b.length) {
                Element e2 = new Element(current.aIndex, current.bIndex + 1, current.cIndex);
                if(!set.contains(e2)){
                    set.add(e2);
                    heap.offer(e2);
                }
            }

            if ((current.cIndex + 1) < c.length) {
                Element e3 = new Element(current.aIndex, current.bIndex, current.cIndex + 1);
                if(!set.contains(e3)) {
                    set.add(e3);
                    heap.offer(e3);
                }
            }
            count++;
        }
        List<Integer> result = new ArrayList<Integer>();
        if(count == k) {
            result.add(a[current.aIndex]);
            result.add(b[current.bIndex]);
            result.add(c[current.cIndex]);
        }
        return result;

    }
}
