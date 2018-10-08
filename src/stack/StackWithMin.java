package stack; /**
 * Created by kewang on 20/9/18.
 */
import java.util.Stack;
public class StackWithMin {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMinValue;
    private int currentMinValue = Integer.MAX_VALUE;
    public StackWithMin() {
        stackData = new Stack<Integer>();
        stackMinValue = new Stack<Integer>();
    }

    public int pop() {
        if ( ! this.stackData.isEmpty()) {
            this.stackMinValue.pop();
            if(this.stackData.size() == 1){
                this.currentMinValue = Integer.MAX_VALUE;
            }
            return this.stackData.pop();
        }else{
            return -1;
        }
    }

    public void push(int element) {
        this.stackData.push(element);
        if(element < this.currentMinValue){
            this.currentMinValue = element;
        }
        this.stackMinValue.push(this.currentMinValue);
    }

    public int top() {
        if ( ! this.stackData.empty()) {
            return this.stackData.peek();
        }else{
            return -1;
        }
    }

    public int min() {
        if( ! this.stackMinValue.empty()) {
            return this.stackMinValue.peek();
        }else{
            return -1;
        }
    }

    public static void main(String[] args){
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(5);
        stackWithMin.top();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.top();
        stackWithMin.push(10);
        stackWithMin.top();
        System.out.println(stackWithMin.min());
    }
}
