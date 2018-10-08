package sorting;
import java.util.Arrays;

/**
 * Created by kewang on 24/9/18.
 */
public class QuickPartation {

    private void swap(int[] array, int indexA, int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    private void quickPartition(int[] array, int start, int end, int k){
        if(start >= end){
            return;
        }

        int i = start;
        int j = end - 1;
        while (i <= j){
            if (array[i] <= array[end]) {
                i++;
            }else if (array[j] >= array[end]) {
                j--;
            }else {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, i, end);
        if(k < i) {
            quickPartition(array, start, i - 1, k);
        } else if(k > i) {
            quickPartition(array, i + 1, end, k);
        }
    }

    public int[] kSmallest(int[] array,int k) {
        // Write your solution here
        quickPartition(array, 0, array.length -1, k);
        int[] results = new int[k];
        for (int i = 0; i < k; i++){
            results[i] = array[i];
        }
        Arrays.sort(results);
        return results;
    }

    public static void main(String[] args) {
        QuickPartation quickPartation = new QuickPartation();

        int[] results = quickPartation.kSmallest(new int[]{3, 1, 5, 2, 4}, 3);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
