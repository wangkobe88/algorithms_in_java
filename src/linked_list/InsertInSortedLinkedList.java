package linked_list;

/**
 * Created by kewang on 20/9/18.
 */
public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        // Write your solution here
        if ( head == null ) {
            return new ListNode(value);
        }
        ListNode current = head;
        if ( current.value >= value ){
            ListNode newHead = new ListNode(value);
            newHead.next = head;
            return newHead;
        }

        while ( current != null ){
            ListNode next = current.next;
            if( next == null ) {
                ListNode newNode = new ListNode(value);
                current.next = newNode;
                break;
            }else if( current.value <= value && next.value >= value ){
                ListNode newNode = new ListNode(value);
                current.next = newNode;
                newNode.next = next;
                break;
            }else{
                current = next;
            }
        }

        return head;

    }
}
