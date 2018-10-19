package math;

import java.util.Random;

/**
 * Created by kewang on 17/10/18.
 */
class RandomFive{
    private static Random random = new Random();
    public static int random5(){
        return random.nextInt(5);
    }
}
public class Random7UsingRandom5 {


    public int random7() {
        // write your solution here
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        int random24 = RandomFive.random5() * 5 + RandomFive.random5();
        while(random24 >= 21){
            random24 = RandomFive.random5() * 5 + RandomFive.random5();
        }
        return random24 % 7;
    }

}
