package alg;

/**
 * 数组实现循环队列
 * Created by chen on 2019/8/15.
 */
public class CircleQueueDemo {

    private String[] items;
    private int head;
    private int tail;
    private int capacity;

    public CircleQueueDemo(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean push(String item) {
        if ((tail + 1) % head == 0) return false;
        items[tail] = item;
        tail++;

        if (tail > capacity) tail = tail % capacity;
        return true;
    }

    public String pop() {
        if (head == tail) return "已取出全部数据";
        head++;
        if (head > capacity) head = head % capacity;
        return items[head];
    }
}
