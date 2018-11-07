package design;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * Created by kewang on 3/11/18.
 */

/*
* 链表：Deque支持remove功能，所以可以使用双向链表LinkedList。
* */
public class ImplementLRUCache <K, V>{
    class Node{
        private K key;
        private V value;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<K,Node> dataMap;
    private Deque<Node> list;
    private int capacity;
    private int size;

    public ImplementLRUCache (int capacity) {
        dataMap = new HashMap <K, Node>();
        list = new LinkedList<Node>();
        this.capacity = capacity;
        this.size = 0;
    }

    public V get(K key) {
        //System.out.println("get: " + String.valueOf(key) + " head: " + String.valueOf(this.countFromHead()) + " tail: " + String.valueOf(this.countFromTail()));

        if( dataMap.containsKey(key) && dataMap.get(key) != null) {
            Node node = dataMap.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        } else {
            return null;
        }
    }

    public void set(K key, V value) {
        //System.out.println("put: " + String.valueOf(key) + " head: " + String.valueOf(this.countFromHead()) + " tail: " + String.valueOf(this.countFromTail()));
        if(dataMap.containsKey(key) && dataMap.get(key) != null) {
            Node node = dataMap.get(key);
            node.value = value;
            list.remove(node);
            list.addFirst(node);
        } else {
            Node node = new Node(key, value);
            list.addFirst(node);
            dataMap.put(key, node);
            this.size++;

            if(this.size > this.capacity) {
                Node tail = list.getLast();
                this.dataMap.put(tail.key, null);
                list.removeLast();
                this.size --;
            }
        }
    }
}
