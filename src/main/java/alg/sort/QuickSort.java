package alg.sort;

/**
 * Created by chen on 2020/3/31.
 */
public class QuickSort {

    public int[] Sort(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(nums, start, end);
        quickSort(nums, start, p-1);
        quickSort(nums, p + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int partValue = nums[end];
        int i=start;
        for (int j = start; j <end; j++) {
            if (nums[j] <partValue) {
                if (i != j) {
                    int tem = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tem;
                }
                i++;
            }
        }
        int tem = nums[i];
        nums[i] = partValue;
        nums[end]=tem;
        return i;
    }


}
