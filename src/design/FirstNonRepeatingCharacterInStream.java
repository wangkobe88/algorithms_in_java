package design;
import java.util.*;
/**
 * Created by kewang on 3/11/18.
 */

/*
* 需要保存顺序，又要知道位置支持随机访问，往往结合HashMap与双向链表Deque;
* Deque 中获取最后一个或者第一个元素为getLast(),以及getFirst()两个函数。
* */
public class FirstNonRepeatingCharacterInStream {
    class Node{
        int count;
        char character;
        Node(char character, int count) {
            this.count = count;
            this.character = character;
        }
    }

    private Map<Character, Node> map = new HashMap<Character,Node>();
    private Deque<Node> deque = new LinkedList<Node>();

    public FirstNonRepeatingCharacterInStream() {
        // Initialize the class.
    }

    public void read(char ch) {
        // Implement this method here.
        if( !map.containsKey(ch)) {
            Node node = new Node(ch, 1);
            map.put(ch, node);
            deque.offerLast(node);
        } else {
            if(map.get(ch) == null) {
                return;
            } else if(map.get(ch).count == 1) {
                deque.remove(map.get(ch));
                map.put(ch, null);
            }
        }
    }

    public Character firstNonRepeating() {
        // Implement this method here.
        if ( deque.isEmpty() ) {
            return null;
        } else {
            return deque.getFirst().character;
        }
    }
}
