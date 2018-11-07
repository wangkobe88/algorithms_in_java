package linked_list;
import java.util.*;
/**
 * Created by kewang on 6/11/18.
 */

//Definition for singly-linked list.

/*
* Time complexity = O(n)
* Space complexity = O(n)
* Space complexity将进一步降低，必须修改ListNode的结构。
*/

public class PalindromeLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if( head == null) {
            return true;
        }

        ListNode current = head;
        int count = 0;
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        while(current != null) {
            tempMap.put(count, current.val);
            count += 1;
            current = current.next;
        }

        for(int i = 0; i <= tempMap.size()/2; i++) {
            if(!tempMap.get(tempMap.size() - i - 1).equals(tempMap.get(i))) {
                return false;
            }
        }
        return true;
    }
}
