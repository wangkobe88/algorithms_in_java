package array;
import java.util.*;
/**
 * Created by kewang on 9/11/18.
 */
public class MeetingRoomsII {
    /**
     * Definition for an interval.
     * */
    /*
    * 在某个状态时，快速获得满足条件的结果的个数。
    * 可以使用堆，在这个状态将不满足条件的结果Poll出去，从而堆的大小就是结果的个数。
    * */
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if(i1.start < i2.start) {
                    return -1;
                } else if(i1.start > i2.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if(i1.end < i2.end) {
                    return -1;
                } else if(i1.end > i2.end) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int maxCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            pq.offer(intervals[i]);

            while(!pq.isEmpty() &&intervals[i].start >= pq.peek().end){
                pq.poll();
            }
            maxCount = Math.max(maxCount, pq.size());
        }
        return maxCount;
    }
}
