package math;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by kewang on 17/10/18.
 */
public class GeneralizedReservoirSampling {
    private final int k;
    private ArrayList<Integer> currentSamples;
    private int count = 0;
    private Random random = new Random();
    public GeneralizedReservoirSampling(int k) {
        // Complete the constructor if necessary.
        this.k = k;
        currentSamples = new ArrayList<Integer>();
    }

    public void read(int value) {
        // Write your implementation here.
        this.count ++;
        if(this.count <= this.k) {
            this.currentSamples.add(value);
            return;
        }

        int sampleIndex = random.nextInt(this.count);
        if(sampleIndex < this.k){
            this.currentSamples.set(sampleIndex, value);
        }
    }

    public List<Integer> sample() {
        // Write your implementation here.
        return this.currentSamples;
    }
}
