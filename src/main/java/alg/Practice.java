package alg;

import alg.array.SingleLink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
}
