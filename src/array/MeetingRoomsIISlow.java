package array;
import java.util.*;

/**
 * Created by kewang on 9/11/18.
 */
public class MeetingRoomsIISlow {
    /**
     * Definition for an interval.
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

        int maxCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            int count = 0;
            for (int j = i; j >= 0; j--) {
                if(intervals[j].end > intervals[i].start){
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
