package binary_search;

/**
 * Created by kewang on 22/9/18.
 */
public class KClosestInSortedArray {
    private int[] kClosest(int[] array, int target, int k, int nearestIndex){
        int left = nearestIndex - 1;
        int right = nearestIndex + 1;
        int[] results = new int[k];
        results[0] = array[nearestIndex];

        int resultCount = 1;
        while(resultCount <= k - 1 && left >= 0 && right <= array.length - 1){
            if( Math.abs(array[left] - target) < Math.abs(array[right] - target)  ){
                results[ resultCount++ ] = array[ left-- ];
            } else {
                results[ resultCount++ ] = array[ right++ ];
            }
        }
        while (resultCount <= k - 1 && left >= 0){
            results[ resultCount++ ] = array[ left-- ];
        }
        while(resultCount <=  k - 1 && right <= array.length - 1){
            results[ resultCount++ ] = array[ right++ ];
        }
        return results;
    }

    private int nearestIndex(int[] array,int target){
        int start = 0;
        int end = array.length - 1;

        if (start == end){
            return start;
        }

        while(start < end - 1){
            int mid = start + (end - start)/2;
            if (array[mid] == target){
                return mid;
            }else if (array[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(Math.abs(array[start] - target ) < Math.abs(array[end] - target)){
            return start;
        }else{
            return end;
        }
    }

    public int[] kClosest(int[] array, int target, int k){
        if( k == 0 ){
            return new int[0];
        }

        int nearestIndex = nearestIndex(array, target);
        //System.out.println(nearestIndex);
        return kClosest(array, target, k, nearestIndex);

    }

    public static void main(String[] args) {
        KClosestInSortedArray kClosestInSortedArray = new KClosestInSortedArray();
        //kClosestInSortedArray.kClosest(new int[]{1,5}, 10, 1);
        kClosestInSortedArray.kClosest(new int[]{1}, 0, 1);
        kClosestInSortedArray.kClosest(new int[]{1,5}, 0, 0);
    }

}
