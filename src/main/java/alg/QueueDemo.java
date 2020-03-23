package alg;

/**
 * 实现可以自动扩容的队列
 * Created by chen on 2019/8/15.
 */
public class QueueDemo {

    private String[] items = null;
    private int head;
    private int tail;


    public QueueDemo(int n) {
        this.items = new String[n];
    }

    public boolean push(String item) {
        if (tail >= items.length) {
            if (head == 0) return false;
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail-=head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String pop() {
        if (head > tail) return "已取出全部数据";
        if (head >= items.length) return "数组越界";
        String res = items[head];
        head++;
        return res;
    }
}
