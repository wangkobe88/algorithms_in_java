package math;
import java.util.Random;
/**
 * Created by kewang on 17/10/18.
 */
public class ReservoirSampling {
    private int count = 0;
    private int currentSample = 0;
    private Random r = new Random();
    public void read(int value) {
        // Write your implementation here.
        count++;
        if(r.nextInt(count) == 0){
            this.currentSample = value;
        }
    }

    public Integer sample() {
        // Write your implementation here.
        if(this.count == 0) {
            return null;
        } else {
            return this.currentSample;
        }
    }
}
