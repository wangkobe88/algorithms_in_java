package sorting;

/**
 * Created by kewang on 24/9/18.
 */
public class QuickSort {

    private void swap(int[] array, int indexA, int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    private void quickSort(int[] array, int start, int end){
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
        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);
    }

    public int[] quickSort(int[] array) {
        // Write your solution here
        quickSort(array, 0, array.length -1);
        return array;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] results = quickSort.quickSort(new int[]{1});
        results = quickSort.quickSort(new int[]{5, 3, 4, 2, 1, 1, 2, 1, 8, 4, 4, 9, 13, 5, 8});
        //results = quickSort.sort.kSmallestSolution2(new int[]{}, 0);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

}
