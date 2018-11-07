package stack;
import java.util.Stack;
import java.util.Arrays;

/**
 * Created by kewang on 31/10/18.
 */
/*
栈数据结构应用，不好想。
* */
public class LargestRectangleInHistogram {
    class Element{
        int index;
        int value;
        Element(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public int largestRectangleArea(int[] heights) {
        // Write your solution here
        if(heights == null || heights.length == 0) {
            return -1;
        }
        int[] dummyArray = new int[heights.length + 2];
        for(int i = 0; i < heights.length; i++){
            dummyArray[i + 1] = heights[i];
        }

        dummyArray[0] = 0;
        dummyArray[heights.length + 1] = 0;

        int[] results = new int[dummyArray.length];
        int maxRec = 0;
        Stack<Element> stack = new Stack<Element>();
        stack.push(new Element(0, dummyArray[0]));
        int index = 1;
        while(index < dummyArray.length) {
            if( dummyArray[index] >= stack.peek().value) {
                stack.push(new Element(index, dummyArray[index]));
                index++;
            } else {
                Element right = stack.pop();
                results[right.index] = right.value * (right.index - stack.peek().index);
                while((!stack.isEmpty()) && stack.peek().value > dummyArray[index]) {
                    Element element = stack.pop();
                    results[element.index] = element.value * (right.index - stack.peek().index);
                }
            }
            //index++;
        }

        for(int i = 0; i < dummyArray.length; i++) {
            System.out.println(String.valueOf(i) +" : "+ String.valueOf(results[i]));
            maxRec = Math.max(maxRec, results[i]);
        }

        return maxRec;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        //System.out.println( l.largestRectangleArea(new int[]{5,4,1,2}) );
        System.out.println( l.largestRectangleArea(new int[]{1}) );
        // array 0 2 1 2 0
        // stack = [0] index = 1
        // stack = [0,2] index = 2 cur = 1
        // stack = [0] 2 righindex = 1,peekindex = 0 results = 2
        // stack = [0, 1] index = 3
        // stack = [0,1,2] index = 4
        // stack = [0,1] rightindex = 3,peekindex = 2 results = 2
        // stack = [0] cur = 1, righindex = 3 peekindex = 0 result = 3

    }
}
