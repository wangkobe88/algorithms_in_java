package math;

import java.util.Random;

/**
 * Created by kewang on 17/10/18.
 */
public class PerfectShuffle {

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public void shuffle(int[] array) {
        // Write your solution here.
        if (array == null || array.length == 0){
            return;
        }

        Random r = new Random();
        for (int i = array.length; i > 0; i--){
            int randomIndex = r.nextInt(i);
            swap(array,randomIndex,array.length - 1);
        }
    }
}
