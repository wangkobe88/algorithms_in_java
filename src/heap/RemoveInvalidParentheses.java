package heap;
import java.util.*;
/**
 * Created by kewang on 9/11/18.
 */
/*
* BFS 算法适合"最X的合法结果寻找"，可以将"最X"的未判断结果逐次进入PriorityQueue，加快搜索速度。
* */

public class RemoveInvalidParentheses {
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] sChars = s.toCharArray();

        for(int i = 0; i < sChars.length; i++) {
            char c = sChars[i];
            if(c != '(' && c != ')') {
                continue;
            }

            if( c == ')') {
                if( !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        if(stack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private void removeInvalidParentheses(String s, List<String> result) {
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String s1,String s2) {
                if(s1.length() > s2.length()) {
                    return -1;
                } else if (s1.length() < s2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        pq.offer(s);
        int maxLength = 0;
        boolean isFound = false;
        Set<String> dedup = new HashSet<String>();
        while(!pq.isEmpty()) {
            String current = pq.poll();
            if(isFound == true && current.length() < maxLength) {
                pq.clear();
                break;
            }

            //System.out.println("Judge:" + current);
            if(isValid(current)) {
                //System.out.println("Valid:" + current);
                if(isFound == true && current.length() == maxLength){
                    result.add(current);
                } else if(isFound == false){
                    maxLength = current.length();
                    isFound = true;
                    result.add(current);
                }
            } else {

                for(int i = 0; i < current.length(); i ++) {
                    StringBuilder sb = new StringBuilder(current);
                    sb.deleteCharAt(i);
                    String next = sb.toString();
                    if(!dedup.contains(next)) {
                        pq.offer(next);
                        dedup.add(next);
                    }

                }
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<String>();
        if(s == null) {
            return results;
        }

        removeInvalidParentheses(s, results);
        return results;
    }
}
