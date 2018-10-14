package lang.inheritance;

/**
 * Created by kewang on 13/10/18.
 */
public class InheritanceExample2 extends InheritanceExample1 {
    public String show(InheritanceExample2 obj) {
        return ("B and B");
    }

    public String show(InheritanceExample1 obj) {
        return ("B and A");
    }
}
