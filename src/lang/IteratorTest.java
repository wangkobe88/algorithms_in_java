package lang;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by kewang on 15/10/18.
 */
public class IteratorTest {
    public static void main(String args[]){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }

        for(ListIterator<Integer> it = list.listIterator(); it.hasNext();){
            System.out.println(it.next());
            if(it.hasNext()){
                System.out.println(it.next());
                System.out.println(it.previous());
            }
        }
    }
}
