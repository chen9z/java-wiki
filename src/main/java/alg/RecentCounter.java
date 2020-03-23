package alg;

import java.util.*;

/**
 * Created by chen on 2020/3/19.
 */
public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    public int getKthMagicNumber(int k) {
        int p3 = 0, p5 = 0, p7 = 0;
        int[] num = new int[k - 1];
        num[0] = 1;
        for (int i = 1; i < k; i++) {
            num[i] = Math.min(num[p3] * 3, Math.min(num[p5] * 5, num[p7] * 7));
            if (num[i] == num[p3] * 3) p3++;
            if (num[i] == num[p5] * 5) p5++;
            if (num[i] == num[p7] * 7) p7++;
        }
        return num[k - 1];
    }

    public int[] sortedSquares(int[] A) {
        if (A.length == 1) {
            return new int[]{A[0] * A[0]};
        }
        int index = 0;
        while (A[index] < 0) {
            index++;
        }
        int p = index - 1, q = index;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (p >= 0 && q < A.length) {
                res[i] = Math.min(A[p] * A[p], A[q] * A[q]);
                if (A[p] * A[p] <= A[q] * A[q]) {
                    res[i] = A[p] * A[p];
                    p--;
                } else {
                    res[i] = A[q] * A[q];
                    q++;
                }
            } else if (p < 0 && q < A.length) {
                res[i] = A[q] * A[q];
                q++;
            } else if (q == A.length && p >= 0) {
                res[i] = A[p] * A[p];
                p--;
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);

        }
        return new int[]{};
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[]{0};
        return quickSortLeastNumbers(arr, 0, arr.length - 1, k-1);
    }

    private int[] quickSortLeastNumbers(int[] arr, int start, int end, int k) {
        int partition = partition(arr, start, end);
        if (partition == k) return Arrays.copyOf(arr, partition);
        return partition < k ?
                quickSortLeastNumbers(arr, partition + 1, end, k) : quickSortLeastNumbers(arr, start, partition-1, end);
    }

    private  int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }
}
