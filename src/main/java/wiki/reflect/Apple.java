package wiki.reflect;

/**
 * Created by chen on 2020/7/8.
 */
public class Apple implements Food{
    @Override
    public void eat() {
        System.out.println("eat apple");
    }

    @Override
    public void eatMore(int num) {
        System.out.printf("eat %s 个apple\n",num);
    }
}
