package heap;
import java.util.*;
/**
 * Created by kewang on 10/11/18.
 */
/*
* 用优先队列归并K个数组或者列表，需要明白在优先队列中，必须要记录下元素属于哪个位置，不然无法寻址。
* 在迭代中，使用Previous变量，要知道第一次迭代的时候其为空。
* */
public class MergeKSortedLists {

    /**
     * Definition for singly-linked list.
     * */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Element{
        ListNode node;
        int indexOfList;
        Element(ListNode node,int indexOfList){
            this.node = node;
            this.indexOfList = indexOfList;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) {
            return null;
        }
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
            public int compare(Element e1, Element e2){
                if(e1.node.val < e2.node.val) {
                    return -1;
                } else if(e1.node.val > e2.node.val) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.offer(new Element(lists[i], i));
                lists[i] = lists[i].next;
            }
        }

        ListNode head = null;
        ListNode previous = null;
        while(!pq.isEmpty()) {
            Element current = pq.poll();
            ListNode currentNode = current.node;
            if(head == null) {
                head = currentNode;
            }
            if(previous != null) {
                previous.next = currentNode;
            }
            if(lists[current.indexOfList] != null){
                pq.offer(new Element(lists[current.indexOfList], current.indexOfList));
                lists[current.indexOfList] = lists[current.indexOfList].next;
            }
            previous = currentNode;
        }
        return head;
    }
}
