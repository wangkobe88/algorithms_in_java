package array;
import java.util.*;
/**
 * Created by kewang on 7/11/18.
 */

/*
* List 要做排序要用Collections.sort()
* List获取第N个元素要用get()
* 最好在纸上把变量与迭代逻辑全部布局清楚再进行代码撰写。
* */
public class MergeIntervals {
    /**
     * Definition for an interval.
     */

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
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

        Interval start = intervals.get(0);
        Interval previous = intervals.get(0);
        int largestEnd = start.end;
        for(int i = 0; i < intervals.size(); i++) {
            largestEnd = Math.max(largestEnd, previous.end);
            Interval current = intervals.get(i);
            if(current.start > largestEnd){
                Interval mergedInterval = new Interval(start.start, largestEnd);
                result.add(mergedInterval);
                start = current;
                largestEnd = start.end;
            }

            if (i == intervals.size() - 1) {
                largestEnd = Math.max(largestEnd, current.end);
                Interval mergedInterval = new Interval(start.start, largestEnd);
                result.add(mergedInterval);
            }
            previous = current;
        }
        return result;
    }
}
