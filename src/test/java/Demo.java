import org.junit.Test;

public class Demo {


    @Test
    public void func1() throws Exception{
        String s1=new StringBuilder("计算").append("科学").toString();
        System.out.println(s1.intern() == s1);

        String s2 = "java";
        System.out.println(s2.intern() == s2);

        System.out.println(s1.getBytes("utf-8").length);
        System.out.println(s2.getBytes("utf-8").length);

    }
}
