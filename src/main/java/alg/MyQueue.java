package alg;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by chen on 2020/3/18.
 */
public class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<>();
        outStack=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()&&inStack.isEmpty()) {
            return -1;
        }
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(inStack.isEmpty()&&outStack.isEmpty()) return -1;
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }

    public int longestPalindrome(String s) {
        int len=s.length();
        Map<Character,Integer> map=new HashMap(s.length());
        for (int i = 0;i<len ; i++) {
            Integer count = map.get(s.charAt(i));
            map.put(s.charAt(i), count == null ? 1 : count + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        int res=0;
        for (Map.Entry entry : entries) {
            int count = (Integer) entry.getValue()/2;
            res+=count<<1;
        }
        return res==len?len:res+1;
    }

    public int longestPalindrome1(String s) {
        int res=0;
        int [] chr = new int[58];
        int len = s.length();
        for (int i = 0; i <len; i++) {
            chr[s.charAt(i)-'A']++;
        }
        for (int i = 0; i < chr.length; i++) {
            res+=chr[i]*2/2;
        }
        return res==len?len:res+1;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return  new int[]{};
        int p=0,q=p+k-1;
        int res []=new int[nums.length-k+1];
        int max;
        while(q<nums.length){
            max=nums[p];
            for(int i=p+1;i<=q;i++){
                max=Math.max(max,nums[i]);
            }
            res[p]=max;
            p++;
            q++;
        }
        return res;
    }
}
