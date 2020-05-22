package alg;

import alg.array.SingleLink;

import java.util.*;
import java.lang.String;
import java.sql.*;
import java.io.*;
import java.nio.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chen on 2019/8/22.
 */
public class Practice {


    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (Integer i : deck) {
            count[i]++;
        }

        int g = count[deck[0]];
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                g = gcd(count[i], g);
                if (g < 2) {
                    return false;
                }
            }
        }
        System.out.println("公约数：" + g);
        return true;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            int tem = a;
            a = b;
            b = tem;
        }
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int tem=0;
        while (n != 1) {
            tem = ((tem + m - 1)% n);
            System.out.println("delete:" + tem);
            list.remove(tem);
            n--;
        }
        return list.get(0);
    }

//    public String reverseWords(String s) {
//        StringBuilder builder=new StringBuilder();
//        char[] chars = s.toCharArray();
//        int i=chars.length-1,j=i;
//        while (i >=0) {
//            if (chars[i] == ' ') {
//                if (i!=j) {
//                    builder.append(s, i+1, j+1).append(" ");
//                    j=i;
//                }
//                i--;
//                j--;
//            }else {
//                i--;
//            }
//        }
//        return builder.toString().trim();
//    }

    public String reverseWords(String s) {
        StringBuilder builder=new StringBuilder();
        String[] chars = s.trim().split(" +");
        Collections.reverse(Arrays.asList(chars));
        return String.join(" ",chars);
    }

    public synchronized int lengthOfLongestSubstring(String s) {
        int length=s.length();
        if(length<=1) return length;
        int j=0,max=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++){
            if(map.containsKey(s.charAt(i))){
                max=Math.max(max,i-j);
                j = Math.max(map.get(s.charAt(i)) + 1, j);
                System.out.println("j:"+j);
            }
            map.put(s.charAt(i),i);
        }
        max=Math.max(max,length-j);
        return max;
    }
}
