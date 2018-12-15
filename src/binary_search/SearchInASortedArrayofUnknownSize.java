package binary_search;

/**
 * Created by kewang on 14/11/18.
 */
public class SearchInASortedArrayofUnknownSize {
    class ArrayReader{
        public int get(int index){
            return 1;
        }
    }
    private int binarySearch(ArrayReader reader, int target, int start, int end){
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(reader.get(mid) > target) {
                end = mid - 1;
            } else if(reader.get(mid) < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search(ArrayReader reader, int target) {
        int maxIndex = 1;
        while (reader.get(maxIndex) != Integer.MAX_VALUE) {
            maxIndex *= 2;
        }

        return binarySearch(reader, target, 0, maxIndex);
    }
}
