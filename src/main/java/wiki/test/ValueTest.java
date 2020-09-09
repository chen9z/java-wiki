package wiki.test;

/**
 * 值传递还是引用传递
 * Created by chen on 2020/8/31.
 */
public class ValueTest {

    public static void main(String[] args) {
        int a=10;
        System.out.println(a);
        add(a);
        System.out.println(a);
    }

    public static void add(int a) {
        a++;
    }
}
