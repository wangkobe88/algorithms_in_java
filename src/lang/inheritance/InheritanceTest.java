package lang.inheritance;

/**
 * Created by kewang on 13/10/18.
 */
public class InheritanceTest {
    public static void main(String[] args){
        InheritanceExample1 a1 = new InheritanceExample1();
        InheritanceExample1 a2 = new InheritanceExample2();
        InheritanceExample2 b = new InheritanceExample2();
        InheritanceExample3 c = new InheritanceExample3();
        InheritanceExample4 d = new InheritanceExample4();
        System.out.println("1---" + a1.show(b));    // A and A
        System.out.println("2---" + a1.show(c));    // A and A
        System.out.println("3---" + a1.show(d));    // A and D

        System.out.println("4---" + a2.show(b));    // B and A
        System.out.println("5---" + a2.show(c));    // B and A
        System.out.println("6---" + a2.show(d));    // A and D

        System.out.println("7---" + b.show(b));     // B B
        System.out.println("8---" + b.show(c));     // B B
        System.out.println("9---" + b.show(d));     // A D 继承
    }
}
