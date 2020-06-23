package wiki.test;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        mergeKLists(lists,0,lists.length-1);
        return lists[0];
    }
    public void mergeKLists(ListNode[] lists,int left,int right){
        if(left>=right) return;
        int mid=(left+right)/2;
        mergeKLists(lists,left,mid);
        mergeKLists(lists,mid+1,right);
        System.out.printf("left:%d right:%d \n",left,right);
        System.out.println("left:"+lists[left]);
        System.out.println("right:"+lists[right]);
        lists[left]= merge(lists[left],lists[right]);
        System.out.println("left+right:"+lists[left]);
    }
    public ListNode merge(ListNode l,ListNode r){
        ListNode node=new ListNode(0);
        ListNode tem=node;
        while(l!=null&&r!=null){
            if(l.val<=r.val){
                tem.next=l;
                l=l.next;
            }else{
                tem.next=r;
                r=r.next;
            }
            tem=tem.next;
        }
        if(r!=null){
            tem.next=r;
        }
        if(l!=null){
            tem.next=l;
        }
        System.out.println(">>>>>>>>>>>>>>>>");
        System.out.println("r:"+r.toString());
        System.out.println(">>>>>>>>>>>>>>>>");
        return node.next;
    }

    public ListNode generate(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node=node.next;
        }
        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
        public String toString() {
            StringBuilder builder = new StringBuilder(val+"");
            ListNode node=next;
            while (node != null) {
                builder.append(node.val);
                node=node.next;
            }
            return builder.toString();
        }
    }



}