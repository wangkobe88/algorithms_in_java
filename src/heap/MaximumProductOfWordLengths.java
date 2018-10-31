package heap;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kewang on 31/10/18.
 */

public class MaximumProductOfWordLengths {
    class Pair{
        int index1;
        int index2;
        int value;
        char[] s1;
        char[] s2;

        Pair(int index1,int index2) {
            this.index1 = index1;
            this.index2 = index2;
            this.value = words[index1].length() * words[index2].length();
            this.s1 = words[index1].toCharArray();
            this.s2 = words[index2].toCharArray();
        }

        boolean isValid() {
            for (int i = 0; i < this.s1.length; i++) {
                for (int j = 0; j < this.s2.length; j++) {
                    if (this.s1[i] == this.s2[j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    private String[] words;

    public int maxProduct(String[] words) {
        if(words == null || words.length < 2) {
            return 0;
        }

        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1.length() > s2.length()) {
                    return -1;
                } else if (s1.length() < s2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        this.words = words;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair one, Pair two) {
                if(one.value > two.value) {
                    return -1;
                } else if(one.value < two.value) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        heap.offer(new Pair(0,1));
        while(!heap.isEmpty()) {
            Pair current = heap.poll();
            if(current.isValid()) {
                return current.value;
            } else {
                if(current.index1 + 1 < this.words.length && current.index1 + 1 != current.index2) {
                    heap.offer( new Pair( current.index1 + 1, current.index2) );
                }

                if(current.index2 + 1 < this.words.length && current.index1 != current.index2 + 1) {
                    heap.offer( new Pair( current.index1, current.index2 + 1) );
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        MaximumProductOfWordLengths f = new   MaximumProductOfWordLengths();
        String[] words = new String[] {"a","ab","abc","abcd","abcde","abcdef","abcdefg","abcdefgh","abcdefghi","abcdefghij","abcdefghijk","abcdefghijkl","abcdefghijklm","nopqrstuvwxyz","mnopqrstuvwxyz","lmnopqrstuvwxyz","klmnopqrstuvwxyz","jklmnopqrstuvwxyz","ijklmnopqrstuvwxyz","hijklmnopqrstuvwxyz","ghijklmnopqrstuvwxyz","fghijklmnopqrstuvwxyz","efghijklmnopqrstuvwxyz","defghijklmnopqrstuvwxyz","cdefghijklmnopqrstuvwxyz","bcdefghijklmnopqrstuvwxyz"};
        long start = System.currentTimeMillis();
        f.maxProduct(words);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
