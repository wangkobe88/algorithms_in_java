package linked_list;

/**
 * Created by kewang on 20/9/18.
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        // Write your solution here
        ListNode dummySmallHead = new ListNode(-1);
        ListNode dummyBigHead = new ListNode(-1);
        ListNode currentSmall = dummySmallHead;
        ListNode currentBig = dummyBigHead;
        ListNode current = head;

        while( current != null ){
            if (current.value < target){
                currentSmall.next = current;
                currentSmall = currentSmall.next;
            }else{
                currentBig.next = current;
                currentBig = currentBig.next;
            }
            current = current.next;
        }
        currentSmall.next = dummyBigHead.next;
        currentBig.next = null;
        return dummySmallHead.next;
    }
}
