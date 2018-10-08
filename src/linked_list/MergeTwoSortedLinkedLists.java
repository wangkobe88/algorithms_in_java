package linked_list;

/**
 * Created by kewang on 20/9/18.
 */
public class MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        // Write your solution here
        ListNode current1 = one;
        ListNode current2 = two;
        ListNode newDummyHead = new ListNode(-1);
        ListNode current = newDummyHead;
        while(current1 != null && current2 != null){
            if (current1.value <= current2.value){
                current.next = current1;
                current1 = current1.next;
            }else{
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }
        if(current1 != null){
            current.next = current1;
        }
        if(current2 != null){
            current.next = current2;
        }
        return newDummyHead.next;
    }


}
