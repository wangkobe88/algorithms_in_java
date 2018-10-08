package stack;

import java.util.LinkedList;

/**
 * Created by kewang on 20/9/18.
 */
public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // Write your solution here.
        while (!s1.isEmpty()) {
            Integer minValue = Integer.MAX_VALUE;
            Integer minValueCount = 0;
            while (!s1.isEmpty()) {
                Integer currentValue = s1.pop();
                if (currentValue < minValue) {
                    minValue = currentValue;
                }
                if (currentValue == minValue) {
                    minValueCount += 1;
                }
                s2.push(currentValue);
            }
            while (!s2.isEmpty()) {
                if (s2.peek() < minValue) {
                    break;
                }
                Integer currentValue = s2.pop();
                if (!currentValue.equals(minValue)) {
                    s1.push(currentValue);
                }
            }
            while (minValueCount > 0) {
                s2.push(minValue);
                minValueCount--;
            }
        }

    }

    public void sortV2(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        Integer previousMinValue = Integer.MAX_VALUE;

        while ( true ) {
            Integer minValue = Integer.MAX_VALUE;
            Integer minValueCount = 0;

            while (!s1.isEmpty()) {

                if (s1.peek() <= previousMinValue && !(previousMinValue == Integer.MAX_VALUE)) {
                    break;
                }

                Integer currentValue = s1.pop();
                if (currentValue < minValue) {
                    minValue = currentValue;
                    minValueCount = 0;
                }

                if (currentValue == minValue) {
                    minValueCount += 1;
                }
                s2.push(currentValue);
            }
            //System.out.println(minValue);
            //System.out.println(s2.size());

            while (minValueCount > 0) {
                s1.push(minValue);
                minValueCount--;
            }
            if( s2.isEmpty()){
                break;
            }

            while (!s2.isEmpty()) {
                Integer currentValue = s2.pop();
                if (!currentValue.equals(minValue)) {
                    s1.push(currentValue);
                }
            }
            previousMinValue = minValue;

        }


    }

    //passed
    public void sortV3(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        Integer previousMaxValue = Integer.MIN_VALUE;

        while (true) {
            Integer maxValue = Integer.MIN_VALUE;
            Integer maxValueCount = 0;

            while (!s1.isEmpty()) {

                if (s1.peek() >= previousMaxValue && !(previousMaxValue == Integer.MIN_VALUE)) {
                    break;
                }

                Integer currentValue = s1.pop();
                if (currentValue > maxValue) {
                    maxValue = currentValue;
                    maxValueCount = 0;
                }

                if (currentValue == maxValue) {
                    maxValueCount += 1;
                }
                s2.push(currentValue);
            }
            //System.out.println(maxValue);

            while (maxValueCount > 0) {
                s1.push(maxValue);
                maxValueCount--;
            }
            if (s2.isEmpty()) {
                break;
            }

            while (!s2.isEmpty()) {
                Integer currentValue = s2.pop();
                if (!currentValue.equals(maxValue)) {
                    s1.push(currentValue);
                }
            }
            previousMaxValue = maxValue;

        }
    }

    public static void main(String[] args) {
        QueueByTwoStacks.SortWith2Stacks sortWith2Stacks = new QueueByTwoStacks.SortWith2Stacks();
        LinkedList<Integer> s1 = new LinkedList<Integer>();
        s1.push(4);
        s1.push(3);
        s1.push(2);
        s1.push(1);
        sortWith2Stacks.sortV3(s1);
        //System.out.println(s1.size());
        while(!s1.isEmpty()){
            System.out.println(s1.pop());
        }
        System.out.println("###################");
        s1.clear();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        sortWith2Stacks.sortV3(s1);
        //System.out.println(s1.size());
        while(!s1.isEmpty()){
            System.out.println(s1.pop());
        }

    }
}