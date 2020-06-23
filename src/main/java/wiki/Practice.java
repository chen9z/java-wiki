package wiki;

import java.util.*;
import java.lang.String;

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
        int tem = 0;
        while (n != 1) {
            tem = ((tem + m - 1) % n);
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
        StringBuilder builder = new StringBuilder();
        String[] chars = s.trim().split(" +");
        Collections.reverse(Arrays.asList(chars));
        return String.join(" ", chars);
    }

    public synchronized int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) return length;
        int j = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                max = Math.max(max, i - j);
                j = Math.max(map.get(s.charAt(i)) + 1, j);
                System.out.println("j:" + j);
            }
            map.put(s.charAt(i), i);
        }
        max = Math.max(max, length - j);
        return max;
    }

//    public int findDuplicate(int[] nums) {
//        int pos=0;
//        boolean b=false;
//        while(!b){
//            for(int i=pos+1;i<nums.length;i++){
//                if(nums[pos]==nums[i]){
//                    System.out.println("pos:"+pos+" i:"+i);
//                    b=true;
//                    break;
//                }
//            }
//            pos++;
//        }
//        return nums[pos-1];
//    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (cal(nums1, 0, nums2, 0, left) + cal(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public int cal(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i == nums1.length) return nums2[j + k - 1];
        if (j == nums2.length) return nums1[i + k - 1];
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return cal(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return cal(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int dp = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int n = (i) % dp;
            if (n < numRows) {
                list.get(n).append(s.charAt(i));
            } else {
                list.get(2 * numRows - n - 2).append(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < numRows; i++) {
            System.out.println(list.get(i).toString());
            builder.append(list.get(i));
        }

        return builder.toString();
    }

    public int reverse(int x) {
        StringBuilder builder = new StringBuilder();
        try {
            if (x >= 0) {
                return Integer.parseInt(builder.append(x).reverse().toString());
            } else {
                return -Integer.parseInt(builder.append(-x).reverse().toString());
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isValid(String s) {
        Stack<Integer> ss = new Stack<>();

        Deque<Character> stack = new ArrayDeque<>();
        for (Character chr : s.toCharArray()) {
            if ('(' == chr || '[' == chr || '{' == chr) {
                stack.push(chr);
            } else {
                Character left = stack.poll();
                if ((chr == ')' && '(' != left) || (chr == '}' && '{' != left) || (chr == ']' && '[' != left)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[right] + nums[left] == -value) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                } else if (nums[left] + nums[right] > -value) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 1) return matrix[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int i = 0, j = 0, m = 1;
        for (int k = 0; k < res.length; k++) {
            if (i == m - 1 && j <= matrix[0].length - m) {
                res[k] = matrix[i][j];
                if (j < matrix[0].length - m) {
                    j++;
                }
            } else if (j == matrix[0].length - 1 - m && i < matrix.length - m) {

                res[k] = matrix[i++][j];

            } else if (i == matrix.length - m && j > m - 1) {

                res[k] = matrix[i][j--];

            } else if (j == m - 1 && i > m - 1) {
                res[k] = matrix[i][j];
                if (i == m) {
                    if (m <= (matrix[0].length + 1) / 2) {
                        m++;
                        j++;
                    }
                } else {
                    i--;
                }
            }
        }
        return res;
    }

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> list) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
        res.add(new ArrayList<>(list));
    }

    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int i=len-1;
        for(;i>0;i--){
            if(nums[i-1]<nums[i]){
                break;
            }
        }
        if(i==0){
            Arrays.sort(nums);
        }else {
            int j=i;
            for(;j<len;j++){
                if(nums[i-1]>=nums[j]){
                    break;
                }
            }
            swap(nums,i-1,j-1);
            for(int k=i;k<len-1;k++){
                for(int m=i;m<len-1+i-k;m++){
                    if(nums[m]>nums[m+1]){
                        swap(nums,m,m+1);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public void swap(int[] nums,int m,int n){
        int tem=nums[m];
        nums[m] = nums[n];
        nums[n]=tem;
    }
}
