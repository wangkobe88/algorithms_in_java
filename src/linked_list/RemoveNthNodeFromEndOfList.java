package linked_list;

/**
 * Created by kewang on 10/11/18.
 */

/*
* 需要向面试者提问，是否确定n是合法的。
* 但即使是合法的，也需要注意头节点。
* 快慢指针方法处理距离尾部K的节点。
* */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(count < n) {
            fast = fast.next;
            count++;
        }
        if(fast == null) {
            head = slow.next;
            return head;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
