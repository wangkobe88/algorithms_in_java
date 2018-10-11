package hashmap;

import java.util.Arrays;

/**
 * Created by kewang on 8/10/18.
 */
public class MyHashMap<K,V> {
    public static class Node<K,V> {
        final K key;
        V value;
        Node next;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        void setValue(V value){
            this.value = value;
        }

        K getKey() {
            return this.key;
        }

        V getValue() {
            return this.value;
        }
    }


    private Node<K,V> [] array;
    private int size;
    private float loadFactor;

    //static final varibales
    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public MyHashMap(int cap, float loadFactor){
        this.array = (Node<K, V>[]) (new Node[cap]);
        this.loadFactor = loadFactor;
    }

    public MyHashMap(int cap){
        this(cap, DEFAULT_CAPACITY);
    }

    public MyHashMap(){
        this(DEFAULT_CAPACITY, DEFAULT_CAPACITY);
    }


    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }

        int hash = key.hashCode();
        if (hash < 0){
            hash = hash & 0X7FFFFFFF;
        }
        return hash % array.length;
    }

    private boolean equalsKey(K key1, K key2) {
        if(key1 == null && key2 == null){
            return true;
        }else if (key1 == null || key2 == null){
            return false;
        }else{
            return key1.equals(key2);
        }
    }

    private boolean equalsValue(V value1, V value2) {
        if(value1 == null && value2 == null){
            return true;
        }else if (value1 == null || value2 == null){
            return false;
        }else{
            return value1.equals(value2);
        }
    }

    public Node<K,V> get(K key){
        Node<K,V> node = this.array[getIndex(key)];
        while (node != null){
            if (equalsKey(node.key, key)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public boolean containKey(K key){
        Node<K,V> node = this.array[getIndex(key)];
        while (node != null){
            if (equalsKey(node.key, key)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean containValue(V value){
        for(Node<K,V> node : this.array){
            while (node != null){
                if (equalsValue(node.value, value)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private boolean needReHashing(){
        return this.loadFactor < (this.size + 0.0f)/this.array.length;
    }

    public void put(K key, V value){
        int index = getIndex(key);
        Node<K,V> head = this.array[index];
        Node<K,V> node = head;
        while (head != null){
            if (equalsKey(node.key, key)){
                head.value = value;
                return;
            }
            node = node.next;
        }


        Node<K,V> newNode = new Node<K,V>(key,value);
        newNode.next = head;
        this.array[index] = newNode;
        this.size++;
    }

    public Node<K,V> remove(K key){
        int index = getIndex(key);
        Node<K,V> head = this.array[index];
        if (this.equalsKey(head.key, key)){
            this.array[index] = null;
        }

        Node<K,V> node = head;
        Node<K,V> previous = head;

        while (node != null){
            if (this.equalsKey(node.key ,key)) {
                previous.next = node.next;
                this.size--;
                break;
            }
            previous = node;
            node = node.next;
        }
        return null;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void clear(){
        //this.array = (Node<K, V>[]) (new Node[this.array.length]);
        Arrays.fill(this.array, null);
        this.size = 0;
    }
}
