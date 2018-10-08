package recursion;

/**
 * Created by kewang on 5/10/18.
 */
public class PrintSample {
    public void print(int i){
        if(i <= 0){
            return;
        }
        print(i-1);
        System.out.println(i);
    }

    public static void main(String[] args){
        PrintSample ps = new PrintSample();
        ps.print(10);
    }
}
