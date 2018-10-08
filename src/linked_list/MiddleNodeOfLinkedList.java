package linked_list;

/**
 * Created by kewang on 20/9/18.
 */


public class MiddleNodeOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;
        while(twoStep != null && twoStep.next != null && twoStep.next.next != null){
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
        }
        return oneStep;
    }
}
