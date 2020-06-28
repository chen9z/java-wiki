package wiki.jvm;

/**
 * staticObj、instanceObj和localObj存放在哪里？
 * -Xmx10m -Xms10m -XX:+UseSerialGC -XX:-UseCompressedOops
 * -XX:+UseSerialGC
 * Created by chen on 2020/6/28.
 */
public class JHSDB_TestCase {
    static class  Test{
        static ObjectHolder staticObj=new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObject=new ObjectHolder();
            System.out.println("done");//断点
        }
    }

    private static class ObjectHolder{}

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
