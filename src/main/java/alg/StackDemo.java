package alg;

/**
 * 自己实现的栈
 * Created by chen on 2019/8/14.
 */
public class StackDemo {

    private String[] items;
    private int count;

    public StackDemo(int n) {
        this.count = 0;
        this.items = new String[n];
    }

    public boolean push(String item) {
        if (count > items.length) return false;
        items[count] = item;
        count++;
        return true;
    }

    public String pop() {
        count--;
        if (count >= 0) {
            return items[count];
        } else {
            return null;
        }
    }
}
