package wiki.reflect;

/**
 * Created by chen on 2020/5/15.
 */
public class Student {

    private final String name;

    public  Student(String name) {
        this.name = name;
        System.out.println(name);
    }

    public void hello() {
        System.out.println("hello world" + name);
    }
    private void hi(String kk) {
        System.out.println("hi world" + kk);
    }

}
