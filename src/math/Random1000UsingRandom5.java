package math;

/**
 * Created by kewang on 17/10/18.
 */
public class Random1000UsingRandom5 {
    private int getrandom3125(){
        int counter = 0;
        int random3125 = 0;
        while( counter < 5){
            random3125 = RandomFive.random5()  + random3125 * 5;
            counter++;
        }
        return random3125;
    }

    public int random1000() {
        // write your solution here
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.

        int random3000 = getrandom3125();
        while( random3000  >= 3000){
            random3000 = getrandom3125();
        }
        return random3000%1000;
    }
}
