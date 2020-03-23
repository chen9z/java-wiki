package alg;

/**
 * Created by chen on 2019/8/14.
 */
public class Node<T> {
    public T val;

    public Node next;

    public Node(Node next, T val) {
        this.next=next;
        this.val=val;
    }
    public Node(T val) {
        this.val=val;
    }
    public Node(Node node) {
        this.next = node;
    }
    public Node addNode(Node node){
        this.next=node;
        return node;
    }

}

