package heap;
import java.util.*;
/**
 * Created by kewang on 9/11/18.
 */

/*
* TopK问题使用堆的时候，一定要想明白堆的元素比较条件。
* Collections.reverse()可以用于反转链表。
* Map.Entry<String,Integer> 以及 entry.getKey(),entry.getValue() 作为遍历Map中元素的方法要记好。
* */
public class TopKFrequentWords {
    class Element{
        String value;
        int count;
        Element(String value,int count) {
            this.value = value;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<String>();
        if(words == null || k <= 0) {
            return result;
        }
        Map<String,Integer> wordMap = new HashMap<String,Integer>();
        for(String word : words) {
            if(wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word,1);
            }
        }

        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
            public int compare(Element e1,Element e2) {
                if(e1.count < e2.count) {
                    return -1;
                } else if (e1.count > e2.count) {
                    return 1;
                } else {
                    return e2.value.compareTo(e1.value);
                }
            }
        });

        for(Map.Entry<String,Integer> entry : wordMap.entrySet()) {
            pq.offer(new Element(entry.getKey(),entry.getValue()));
            if(pq.size() > k) {
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            result.add(pq.poll().value);
        }
        Collections.reverse(result);
        return result;

    }
}
