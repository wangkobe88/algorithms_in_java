package sorting;

/**
 * Created by kewang on 21/9/18.
 */
public class SelectionSort {
    public int[] selectionSort(int[] array){
        if (array == null || array.length <= 1){
            return array;
        }

        for (int i = 0 ; i < array.length - 1; i++){
            int global = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[global]){
                    global = j;
                }
            }
            int temp = array[i];
            array[i] = array[global];
            array[global] = temp;
        }
        return  array;
    }

    public static void main(String[] args){
        SelectionSort selectionSort = new SelectionSort();
        int[] array = new int[] {1,34,43,52,3};
        selectionSort.selectionSort(array);
    }
}


