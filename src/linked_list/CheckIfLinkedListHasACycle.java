package linked_list;

/**
 * Created by kewang on 20/9/18.
 */
public class CheckIfLinkedListHasACycle {
    public boolean hasCycle(ListNode head) {
        // write your solution here
        ListNode oneStep = head;
        ListNode twoStep = head;

        while(twoStep != null && twoStep.next != null && twoStep.next.next != null){
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
            if(twoStep == oneStep){
                return true;
            }
        }

        return false;
    }
}
