package linked_list;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kewang on 24/10/18.
 */


class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
      this.value = value;
    }
}
/*
*
* 1.Map的containsKey API 需要记住；
* 2.需要进行遍历的是老链表而不是新链表，这个要想明白。
*
*/

public class DeepCopyLinkedListWithRandomPointer {

    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if (head == null) {
            return null;
        }

        RandomListNode newHead = new RandomListNode(head.value);
        RandomListNode current = head;
        RandomListNode currentNew = newHead;
        Map<RandomListNode,RandomListNode> lookup = new HashMap<RandomListNode,RandomListNode>();
        lookup.put(head, newHead);
        while (current != null) {
            if(current.next != null){
                if(!lookup.containsKey(current.next)){
                    lookup.put(current.next, new RandomListNode(current.next.value));
                }
                currentNew.next = lookup.get(current.next);
            }

            if(current.random != null) {
                if(!lookup.containsKey(current.random)) {
                    lookup.put(current.random, new RandomListNode(current.random.value));
                }
                currentNew.random = lookup.get(current.random);
            }

            current = current.next;
            currentNew = currentNew.next;
        }
        return newHead;
    }
}
