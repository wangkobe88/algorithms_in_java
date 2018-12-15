package math;

/**
 * Created by kewang on 12/11/18.
 */
public class SqrtX {
    public int mySqrtSlow(int x) {
        if(x == 0) {
            return 0;
        }
        for(int i = 1; i <= (x/2 + 1); i++){
            if(i == x/i){
                return i;
            }else if(i > x/i) {
                return i-1;
            }
        }
        return -1;
    }
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int start = 1;
        int end = x/2 + 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mid == x/mid) {
                return mid;
            } else if(mid > x/mid){
                end = mid - 1;
            } else {
                if((mid + 1) > x/(mid + 1)){
                    return mid;
                }
                start = mid + 1;
            }
        }
        return 0;
    }
}
