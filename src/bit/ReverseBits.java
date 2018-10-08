package bit;

/**
 * Created by kewang on 6/10/18.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int i = 0;
        int j = 31;
        while (i < j){
            if ( ((n>>i)&1) != ((n>>j)&1) ){
                n = n ^ ( (1<<i) | (1<<j));
            }
            i++;
            j--;
        }
        return n;
    }
}
