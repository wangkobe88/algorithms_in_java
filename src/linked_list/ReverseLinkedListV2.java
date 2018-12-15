package linked_list;

/**
 * Created by kewang on 10/11/18.
 */

/*反转链表的操作，需要非常非常谨慎。*/
public class ReverseLinkedListV2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseListV2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode previous = head;
        ListNode current = head.next;
        while(current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head.next = null;
        return previous;
    }
}
