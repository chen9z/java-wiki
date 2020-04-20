package alg.sort;

import java.util.Arrays;

/**
 * Created by chen on 2020/3/31.
 */
public class QuickSort {


    /**快速排序
     * @param nums
     * @return
     */
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

    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        int len=nums.length;
        if(len<2) return nums;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <len; j++) {
                if (nums[i] > nums[j]) {
                    int tem = nums[i];
                    nums[i] = nums[j];
                    nums[j]=tem;
                }
            }
        }
        return nums;
    }

    /**
     * 插入排序（优化方案希尔排序）
     * @param nums
     * @return
     */
    public int[] insertSort(int[] nums) {
        int len=nums.length;
        if(len<=1) return nums;
        for (int i = 1; i < len; i++) {
            int value = nums[i];
            int j=i-1;
            for (;j>0;j--) {
                if (value <nums[j]) {
                    nums[j + 1] = nums[j];
                }else {
                    nums[j]=value;
                    break;
                }
            }
        }
        return nums;
    }

    public int[] mergeSort(int[] nums) {
        if(nums.length<=1) return nums;
        merge(nums, 0, nums.length - 1);
        return nums;
    }

    private void merge(int[] nums, int left, int end) {
        if(left>=end) return;
        int mid=(end+left)/2;
        System.out.println(">>>>>mid:" + mid+":left"+left+":right:"+end);
        merge(nums, left, mid);
        merge(nums, mid + 1, end);
        mergeAll(nums, left, mid,end);
    }

    private void mergeAll(int[] nums, int left, int mid,int end) {
        int[] array = new int[end - left+1];
        int i=left,j=mid+1;
        for (int k = 0; k < array.length; k++) {
            if (i <= mid && j <= end) {
                if (nums[i] > nums[j]) {
                    array[k] = nums[j];
                    j++;
                }else {
                    array[k] = nums[i];
                    i++;
                }
            }
            if (i >mid&&j<=end) {
                array[k] = nums[j];
                j++;
            }
            if (j >end&&i<=mid) {
                array[k] = nums[i];
                i++;
            }
        }
        for (int k = left; k <= end; k++) {
            nums[k] = array[k-left];
        }
    }
}
