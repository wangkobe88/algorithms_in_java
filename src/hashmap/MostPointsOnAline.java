package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by kewang on 5/11/18.
 */
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

/*
* 线段的slope与intercept的精度问题是一个大坑。
* 从int进行操作转化为float，需要加入float的乘子，而且需要有一定精度。
* Map的Set<Map.Entry<K,V>>	entrySet() 需要记住。
*/

public class MostPointsOnAline {
    public static void main(String[] args) {
        MostPointsOnAline m = new MostPointsOnAline();
        //<1,1>, <2,3>, <1,1>, <2,3>, <1,1>, <2,2>, <3,4>, <9,10>
        Line l = m.buildLine(new Point(2, 3), new Point(3, 4));
        System.out.println(String.valueOf(l.a) + ":" + String.valueOf(l.b));
        //m.maxPoints(new Point[]{new Point(1,1),new Point(2,3),new Point(1,1),new Point(2,3),new Point(1,1),new Point(2,2),new Point(3,4),new Point(9,10)});
        //[[0,0],[94911151,94911150],[94911152,94911151]]
        m.most(new Point[]{new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)});
    }

    private Line buildLine(Point p1, Point p2) {
        if ((p1.x - p2.x) != 0) {
            float a = (p1.y - p2.y) * 1.00000f / (p1.x - p2.x);
            float b = (p1.y * p2.x - p2.y * p1.x) * 1.00000f / (p2.x - p1.x);
            return new Line(a, b);
        } else {
            return null;
        }
    }

    public int most(Point[] points) {
        // Write your solution here.
        if (points == null || points.length == 0) {
            return 0;
        } else if (points.length == 1) {
            return 1;
        }

        Map<Line, Set<Point>> lines = new HashMap<Line, Set<Point>>();
        Map<Integer, Set<Point>> verticals = new HashMap<Integer, Set<Point>>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = buildLine(points[i], points[j]);
                if (line == null) {
                    if (verticals.containsKey(points[i].x)) {
                        verticals.get(points[i].x).add(points[i]);
                        verticals.get(points[i].x).add(points[j]);
                    } else {
                        Set<Point> set = new HashSet<Point>();
                        set.add(points[i]);
                        set.add(points[j]);
                        verticals.put(points[i].x, set);
                    }
                    continue;
                }

                if (lines.containsKey(line)) {
                    lines.get(line).add(points[i]);
                    lines.get(line).add(points[j]);
                } else {
                    Set<Point> set = new HashSet<Point>();
                    set.add(points[i]);
                    set.add(points[j]);
                    lines.put(line, set);
                }
            }
        }

        int maxGroup = 0;
        //Set<Integer> tempSet = new HashSet<Integer>();
        for (Set<Point> pointsGroup : lines.values()) {
            if (pointsGroup.size() > maxGroup) {
                maxGroup = pointsGroup.size();
                for (Point p : pointsGroup) {
                    //System.out.println(String.valueOf(p.x) + ":" +String.valueOf(p.y));
                }
            }
        }

        for (Set<Point> pointsGroup : verticals.values()) {
            if (pointsGroup.size() > maxGroup) {
                maxGroup = pointsGroup.size();
            }
        }

        return maxGroup;
    }

    /**
     * Definition for a point.
     */

    class Line {
        float a;
        float b;

        Line(float a, float b) {
            this.a = a;
            this.b = b;
        }

        public boolean equals(Object other) {
            Line otherLine = (Line) other;
            return otherLine.a == this.a && otherLine.b == this.b;
        }

        public int hashCode() {
            return (int) (a * 100) * 31 + (int) (b * 100);
        }
    }
}
