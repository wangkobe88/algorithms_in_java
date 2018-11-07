package design;
import java.util.*;

/**
 * Created by kewang on 3/11/18.
 */

/*
* 链表：处理元素是链表的尾巴或者头的时候，往往需要特殊策略；
* */
public class LRUCache {
    class Node{
        private int key;
        private int value;

        private Node previous;
        private Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,Node> dataMap;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        dataMap = new HashMap<Integer,Node>();
        this.capacity = capacity;
        this.size = 0;
    }
    private int countFromHead(){
        int count = 0;
        Node current = this.head;
        while(current != null) {
            count += 1;
            current = current.next;
        }
        return count;
    }

    private int countFromTail(){
        int count = 0;
        Node current = this.tail;
        while( current != null ) {
            count += 1;
            current = current.previous;
        }
        return count;
    }

    public int get(int key) {
        //System.out.println("get: " + String.valueOf(key) + " head: " + String.valueOf(this.countFromHead()) + " tail: " + String.valueOf(this.countFromTail()));

        if( dataMap.containsKey(key) && dataMap.get(key) != null) {
            Node node = dataMap.get(key);

            if(node == head) {
                return node.value;
            }
            if(tail == node) {
                tail = node.previous;
            }
            node.previous.next = node.next;

            if(node.next != null) {
                node.next.previous = node.previous;
            }

            node.next = head;
            this.head.previous = node;
            node.previous = null;
            this.head = node;

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        //System.out.println("put: " + String.valueOf(key) + " head: " + String.valueOf(this.countFromHead()) + " tail: " + String.valueOf(this.countFromTail()));
        if(dataMap.containsKey(key) && dataMap.get(key) != null) {
            Node node = dataMap.get(key);
            node.value = value;
            if(node == head) {
                return;
            }

            if(tail == node) {
                tail = node.previous;
            }
            node.previous.next = node.next;

            if(node.next != null) {
                node.next.previous = node.previous;
            }

            node.next = head;
            this.head.previous = node;
            node.previous = null;
            this.head = node;
        } else {
            Node node = new Node(key, value);
            if (tail == null && head == null) {
                tail = node;
                head = node;
                dataMap.put(key, node);
                this.size++;
                return;
            }

            node.next = this.head;
            this.head.previous = node;
            this.head = node;

            dataMap.put(key, node);
            this.size++;

            if(this.size > this.capacity) {
                this.dataMap.put(tail.key, null);
                this.tail.previous.next = null;
                this.tail = this.tail.previous;
                this.size --;
            }
        }
    }
}
