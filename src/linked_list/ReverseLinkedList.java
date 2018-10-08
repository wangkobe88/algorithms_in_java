package linked_list;

/**
 * Created by kewang on 20/9/18.
 */


class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        // Write your solution here
        if (head == null){
            return null;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return  previous;
    }

    public ListNode reverseBasedOnRecursion(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null){
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;

        ListNode new_head = reverseBasedOnRecursion(next);
        next.next = current;
        current.next = null;
        return  new_head;
    }

}
