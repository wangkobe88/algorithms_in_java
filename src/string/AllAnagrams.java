package string;
import java.util.*;

/**
 * Created by kewang on 4/10/18.
 */

public class AllAnagrams {

    public List<Integer> allAnagramsBak(String lo, String sh) {
        // Write your solution here
        if(lo == null || sh == null || lo.length() <= 0 || sh.length() <= 0){
            return new ArrayList<Integer>();
        }

        char[] loChars = lo.toCharArray();
        char[] shChars = sh.toCharArray();
        Map<Character,Integer> shMap = new HashMap<Character,Integer>();
        for(char shChar : shChars){
            if (shMap.containsKey(shChar)){
                shMap.put(shChar, shMap.get(shChar) + 1);
            } else {
                shMap.put(shChar,1);
            }
        }

        List<Integer> results = new ArrayList<Integer>();
        Map<Character,Integer> loMap = new HashMap<Character,Integer>();
        int i = 0;
        int j = 0;
        int matched_count = 0;
        while (j < loChars.length){


            if(shMap.containsKey(loChars[j])) {
                if (loMap.containsKey(loChars[j])) {
                    loMap.put(loChars[j], loMap.get(loChars[j]) + 1);
                } else {
                    loMap.put(loChars[j], 1);
                }

                if (loMap.get(loChars[j]).equals(shMap.get(loChars[j]))) {
                    matched_count++;
                }
            }

            if ((j - i) == shChars.length && shMap.containsKey(loChars[i])) {
                if (loMap.get(loChars[i]) > 1) {
                    loMap.put(loChars[i], loMap.get(loChars[i]) - 1);
                } else {
                    loMap.remove(loChars[i]);
                }

                if ((loMap.get(loChars[i]) == null) || !loMap.get(loChars[i]).equals(shMap.get(loChars[i]))) {
                    matched_count--;
                }
            }

            if((j - i) == shChars.length){
                i++;
            }
            j++;

            if(matched_count == shMap.size()){
                results.add(i);
            }

        }
        return results;

    }

    public List<Integer> allAnagrams(String lo, String sh) {
        // Write your solution here
        if(lo == null || sh == null || lo.length() <= 0 || sh.length() <= 0 || sh.length() > lo.length()){
            return new ArrayList<Integer>();
        }

        char[] loChars = lo.toCharArray();
        char[] shChars = sh.toCharArray();
        Map<Character,Integer> shMap = new HashMap<Character,Integer>();
        for(char shChar : shChars){
            if (shMap.containsKey(shChar)){
                shMap.put(shChar, shMap.get(shChar) + 1);
            } else {
                shMap.put(shChar,1);
            }
        }

        List<Integer> results = new ArrayList<Integer>();
        Map<Character,Integer> loMap = new HashMap<Character,Integer>();
        int i = 0;
        int j = 0;
        while (j < loChars.length){


            if(shMap.containsKey(loChars[j])) {
                if (loMap.containsKey(loChars[j])) {
                    loMap.put(loChars[j], loMap.get(loChars[j]) + 1);
                } else {
                    loMap.put(loChars[j], 1);
                }
            }

            if ((j - i) == shChars.length && shMap.containsKey(loChars[i])) {
                if (loMap.get(loChars[i]) > 1) {
                    loMap.put(loChars[i], loMap.get(loChars[i]) - 1);
                } else {
                    loMap.remove(loChars[i]);
                }
            }

            if((j - i) == shChars.length){
                i++;
            }
            j++;

            if(loMap.equals(shMap)){
                results.add(i);
            }

        }
        return results;

    }

    public static void main(String[] args){
        AllAnagrams a = new AllAnagrams();
        List<Integer> results = new ArrayList<>();
        results = a.allAnagrams("baaaa","aa");
        for(Integer i : results){
           System.out.println(i);
        }

        //results = a.allAnagrams("bacbabc","abc");
        for(Integer i : results){
            //System.out.println(i);
        }

        //results = a.allAnagrams("aaa","a");
        //results = a.allAnagrams("ababacbbaac","aab");
        for(Integer i : results){
            //System.out.println(i);
        }

    }
}
