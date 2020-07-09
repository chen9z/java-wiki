package wiki.reflect;

/**
 * Created by chen on 2020/7/8.
 */
public class Pear implements Food {
    @Override
    public void eat() {
        System.out.println("eat pear");
    }

    @Override
    public void eatMore(int num) {
        System.out.printf("eat %s 个 pear\n", num);
    }
}
