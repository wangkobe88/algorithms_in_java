package dynamic_programming;
import java.util.Arrays;
import java.util.Comparator;
/**
 * Created by kewang on 5/11/18.
 */
/*
* 注意，用判断点的方式找到线段的集合，需要记住如果只有一个点，是没有形成线段的。
* 这跟题是subsequence问题，而不是substring问题。
* */
class Point {
   public int x;
   public int y;
   public Point(int x, int y) {
     this.x = x;
     this.y = y;
   }
}

public class LargestSetOfPointsWithPositiveSlope {
    public int largest(Point[] points) {
        // Write your solution here.
        if(points == null || points.length <= 1) {
            return 0;
        }

        Arrays.sort(points, new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                if(p1.x < p2.x) {
                    return -1;
                } else if(p1.x > p2.x) {
                    return 1;
                } else if(p1.y < p2.y){
                    return -1;
                } else if(p1.y > p2.y){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int[] result = new int[points.length];
        result[0] = 1;
        int maxLength = 0;
        for(int i = 1; i < result.length; i++) {
            int currentMaxLength = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(points[i].y > points[j].y) {
                    currentMaxLength = Math.max(currentMaxLength, result[j] + 1);
                }
                result[i] = currentMaxLength;
            }
            maxLength = Math.max(maxLength, result[i]);
        }
        return maxLength > 1 ? maxLength : 0;
    }
}
