package wiki.test;

import java.util.HashMap;
import java.util.Map;

public class IpDemo {

    public static long ip2Int(String ip) {
        String[] split = ip.split("\\.");
        long res = 0;
        int len = split.length;
        for (int i = 3; i>=0; i--) {
            long v = Integer.parseInt(split[3-i]);
            res|=v<<(i*8);
        }
        return res;
    }

    public static long ip2Int2(String ip) {
        String[] split = ip.split("\\.");
        long res = 0;
        for (int i = 0; i < split.length; i++) {
            int pow=3-i;
            int v = Integer.parseInt(split[i]);
            res += v * Math.pow(256, pow);
        }
        return res;
    }

    public static void main(String[] args) {
        String ip = "192.168.2.1";
        long l = ip2Int(ip);
         double m;
        double n;
        m = 192 << 24;
        n= 192 * Math.pow(256, 3);
        System.out.println(m);
        System.out.println(n);

        System.out.println();
        String ss = "4124";
        Map<String, Object> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring1(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int  lengthOfLongestSubstring1(String s) {
        Map<Character,Integer> map=new HashMap();
        int res=0;
        for(int j=0,i=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(i,map.get(s.charAt(j)));
            }
            res=Math.max(res,j-i+1);
            map.put(s.charAt(j),j+1);

        }
        return res;
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        if (x == 0 || y == 0) {
            return z==0||x+y==z;
        }
        return z % gcd(x, y) == 0;
    }

    public int gcd(int m, int n) {
        m = Math.max(m, n);
        n = Math.min(m, n);

        return m % n == 0 ? n : gcd(n, m % n);
    }

}
