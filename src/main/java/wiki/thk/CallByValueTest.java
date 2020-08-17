package wiki.thk;

/**
 * Created by chen on 2020/8/17.
 */
public class CallByValueTest {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        changeUser(user);
        System.out.println(user.toString());
    }

    public static void changeUser(User user) {
        user = new User();
        user.setUsername("李四");
        user.setPassword("654321");
        System.out.println(user.toString());
    }
    public static void addValue(int a) {
        a++;
        System.out.println(a);
    }
}
