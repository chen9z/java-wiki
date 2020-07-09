package wiki.reflect;

/**
 * Created by chen on 2020/5/15.
 */
public class Student {

    private  String name;

    static {
        System.out.println("静态代码执行了");
    }

    {
        System.out.println("构造代码块执行了");
    }

    public  Student() {
        System.out.println("无参构造方法执行了");
    }

    public  Student(String name) {
        this.name = "晓明";
        System.out.println("带参构造方法执行了");
    }

    public void hello() {
        System.out.println("hello world" + name);
    }
    private void hi(String kk) {
        System.out.println("hi world" + kk);
    }


}
