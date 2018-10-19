package math;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Created by kewang on 17/10/18.
 */
public class FindMedianFromDataStream {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> smallerHeap;
    private PriorityQueue<Integer> biggerHeap;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        smallerHeap = new PriorityQueue<Integer>( new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1 > o2){
                    return -1;
                } else if(o1 < o2){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        biggerHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(this.smallerHeap.size() == 0 && this.biggerHeap.size() == 0){
            this.smallerHeap.offer(num);
        } else if( this.biggerHeap.size() > 0 && num > this.biggerHeap.peek()){
            this.biggerHeap.offer(num);
        } else {//(num < this.smallerHeap.peek()){
            this.smallerHeap.offer(num);
        }

        if(this.biggerHeap.size() > this.smallerHeap.size()){
            this.smallerHeap.offer(this.biggerHeap.poll());
        } else if (this.smallerHeap.size() > this.biggerHeap.size() + 1){
            this.biggerHeap.offer(this.smallerHeap.poll());
        }
    }

    public double findMedian() {
        if(this.biggerHeap.size() == 0 && this.smallerHeap.size() == 0){
            return 0d;
        }else if(this.biggerHeap.size() == 0){
            return this.smallerHeap.peek();
        } else if(this.smallerHeap.size() == 0){
            return this.biggerHeap.peek();
        }else if(this.biggerHeap.size() == this.smallerHeap.size()){
            return (this.biggerHeap.peek() + this.smallerHeap.peek())/2.0d;
        } else {
            return this.smallerHeap.peek();
        }
    }
}
