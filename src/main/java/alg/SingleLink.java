package alg;

/**
 * Created by chen on 2019/8/14.
 */
public class SingleLink<T> {

    public Node<T> head;
    public T val;


    public SingleLink(T[] array) {
        insertLink(array);
    }

    /**
     * 链表反转
     *
     * @param node
     * @return
     */
    public static Node reverse(Node node) {
        Node cur = node, pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 链表中环的检测
     *
     * @param node
     * @return
     */
    public static boolean isCircle(Node node) {
        if (node == null) return false;
        Node fast = node.next;
        Node slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }
        return false;
    }

    /**
     * 合并两个有序的链表
     *
     * @param m
     * @param n
     * @return
     */
//    public static Node addNode(Node m, Node n) {
//        Node res = new Node(null);
//        while (m != null && n != null) {
//            if (m.val > n.val) {
//                res.next = n;
//                n = n.next;
//            } else {
//                res.next = m;
//                m = m.next;
//            }
//            res = res.next;
//        }
//        if (m != null) res.next = m;
//        if (n != null) res.next = n;
//        return res.next;
//    }

    /**
     * 删除倒序第n个节点
     *
     * @param list
     * @param k
     * @return
     */
    public static Node deleteNode(Node list, int k) {
        Node cur = list, pre = list;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        if (cur.next == null) return pre;

        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return list;
    }

    /**
     * 求中间节点
     *
     * @param list
     * @return
     */
    public static Node getCenterNode(Node list) {
        if (list == null) return null;
        Node fast = list;
        Node slow = list;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 算法重新实现
     * 判断字符传是不是回文
     * 基于链表
     * @param array
     * @return
     */
    public  boolean isCircleString(T[] array) {
        insertLink(array);
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        Node p=head;
        Node q=head;
        Node after = new Node(null, p.val);
        while (q.next!=null&&q.next.next!=null) {
            p=p.next;
            q=q.next.next;
            after = new Node(after, p.val);
        }
        if (q.next == null) {
            System.out.println("链表长度奇数");
//            p=p.next.next;
        }else {
            System.out.println("链表长度偶数");
            p=p.next;
        }
        String afterString = getLinkValue(after);
        String pValue = getLinkValue(p);
        if (afterString != null && afterString.equals(pValue)) {
            return true;
        }
        return false;
    }

    /**
     * 插入数据，生成链表
     * @param array
     * @param <T>
     */
    public  <T> Node insertLink(T[] array) {
        Node temp = null;
        for (T t : array) {
            if (head == null) {
                head = new Node(null, t);
                temp=head;
            }else {
                Node next = new Node(t);
                temp.next=next;
                temp=next;
            }
        }
        return head;
    }


    /**
     * 打印所有的节点数据
     */
    public void printAll() {
        if (head == null) {
            System.out.println("this link is empty");
        }else {
            Node temp=head;
            while (temp!= null) {
                System.out.println(temp.val);
                temp=temp.next;
            }
        }
    }


    /**
     * 遍历获取链表value
     * @param node
     * @return
     */
    public  String getLinkValue(Node node) {
        StringBuilder builder = new StringBuilder();
        if (node == null) {
            System.out.println("this link is empty");
        }else {
            Node temp=node;
            while (temp!= null) {
                System.out.println(temp.val);
                builder.append(temp.val);
                temp=temp.next;
            }
        }
        return builder.toString();
    }

    /**
     * 反转链表
     * @param node
     * @return
     */
    public  Node revertLink(Node node) {
        if (node == null || node.next == null) {
            return head;
        }
        Node pre=null;
        Node cur=node;
        while (cur != null) {
            Node next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    /**
     * 链表中环的检测
     * @param node
     * @return
     */
    public boolean hasCircle(Node node) {
        return false;
    }

    /**
     * 有序链表合并
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeNode(Node l1, Node l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        Node node=null;
        while (l1.next == null || l2.next == null) {
        }
        return null;
    }

    /**
     * 检测是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        if(head==null||head.next==null) return false;
        Node p=head;
        Node q=head;
        while(q!=null&&q.next!=null){
            p=p.next;
            q=q.next.next;
            if(p==q) return true;
        }
        return false;
    }
    /**
     * 删除倒数第N个节点
     * @param index
     */
    public void deleteNodeByLast(int index) {

    }

    public void deleteNode(T val) {

        if (head.val.equals(val)) {
            head=head.next;
        }
        Node pre=null;
        Node cur=head;

        while (cur != null) {
            if (cur.val.equals(val)) {
                pre.next=cur.next;
                cur=cur.next;
                continue;
            }
            pre=cur;
            cur=cur.next;
        }

    }

}
