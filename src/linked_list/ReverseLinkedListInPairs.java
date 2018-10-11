package linked_list;

/**
 * Created by kewang on 9/10/18.
 */
public class ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null){
            return head;
        }
        ListNode nextNode = reverseInPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = nextNode;
        return newHead;
    }
}
