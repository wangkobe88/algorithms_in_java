package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kewang on 17/10/18.
 */
public class ReservoirSamplingMaxNumber {
    private final int k;
    private int currentMax;
    private int currentIndex;
    private int count = 0;
    private Random random = new Random();
    public ReservoirSamplingMaxNumber(int k) {
        // Complete the constructor if necessary.
        this.k = k;
    }

    public void read(int value, int index) {
        // Write your implementation here.
        if(value == this.currentMax) {
            this.count++;
        } else if (value > this.currentMax){
            this.currentMax = value;
            this.count = 1;
        } else {
            return;
        }

        int sampleIndex = random.nextInt(this.count);
        if(sampleIndex < this.k){
            this.currentIndex = index;
        }
    }

    public Integer sample() {
        // Write your implementation here.
        return this.currentMax;
    }
}
