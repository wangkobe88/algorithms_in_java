package hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Created by kewang on 30/9/18.
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        //int[] results = kSmallestInUnsortedArray.kSmallest(new int[]{1}, 1);
        String[] results = topKFrequentWords.topKFrequent(new String[]{"d", "a", "c", "b", "d", "a", "b", "b", "a", "d", "d", "a", "d"}, 5);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for (String word : combo) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> topKFrequentWords = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return -1;
                } else if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (topKFrequentWords.size() < k) {
                topKFrequentWords.offer(entry);
            } else if (entry.getValue() > topKFrequentWords.peek().getValue()) {
                topKFrequentWords.poll();
                topKFrequentWords.offer(entry);
            }
        }

        String[] topKFrequentResult = new String[topKFrequentWords.size()];
        int i = topKFrequentWords.size() - 1;
        while (!topKFrequentWords.isEmpty()) {
            topKFrequentResult[i--] = topKFrequentWords.poll().getKey();
        }
        return topKFrequentResult;

    }
}
