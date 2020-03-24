package alg.sort;

/**
 * 排序算法
 * Created by chen on 2019/8/21.
 */
public class SortDemo {

    /**
     * 冒泡排序
     *
     * @param items
     */
    public int[] bubbleSort(int[] items) {
        if (items.length <= 1) return items;

        int len = items.length;
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (items[j] > items[j + 1]) {
                    int t = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = t;
                    flag = true;
                }
            }
            if (flag = false) break;
        }
        return items;
    }

//    /**
//     * 插入排序
//     *
//     * @param items
//     * @return
//     */
//    public int[] insertSort(int[] items) {
//        if (items.length <= 1) return items;
//
//        int len = items.length;
//        for (int i = 1; i < len; i++) {
//            int value = items[i];
//            int j = i - 1;
//            for (; j >= 0; --j) {
//                if (items[j] > value) {
//                    items[j + 1] = items[j];
//                } else {
//                    break;
//                }
//            }
//            items[j + 1] = value;
//        }
//        return items;
//    }

    /**
     * 快速排序
     *
     * @param items
     * @return
     */
    public int[] quickSort(int[] items) {
        megreSort(items, 0, items.length - 1);
        return items;
    }

//    private int partition(int[] items,int start,int end) {
//        int pivot = items[end];
//        int i=start;
//        for (int j = start; j < end; j++) {
//            if (items[j] < pivot) {
//                if (i == j) {
//                    i++;
//                }else {
//                    int t = items[i];
//                    items[i++] = items[j];
//                    items[j]=t;
//                }
//            }
//        }
//
//        int tmp = items[i];
//        items[i] = items[end];
//        items[end] = tmp;
//        return i;
//    }

    private void megreSort(int[] items, int start, int end) {

        if (start >= end) {
            return;
        }
        int pivot = partIndex(items, start, end);
        megreSort(items, start, pivot - 1);
        megreSort(items, pivot + 1, end);
    }


    private int partIndex(int[] items, int start, int end) {
        int pivot = items[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (items[i] < pivot) {
                if (left == i) {
                    left++;
                } else {
                    int temp = items[left];
                    items[left++] = items[i];
                    items[i] = temp;
                }
            }
        }
        int temp = items[left];
        items[left] = pivot;
        items[end] = temp;
        return left;
    }


    /**
     * 简单的二分查找
     *
     * @param items
     * @param value
     * @return
     */
    public int simpleHalf(int[] items, int value) {
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("》》》》》》》》》》》》" + "执行了几次：" + mid + ":left" + left + ":right:" + right);
            if (items[mid] == value) {
                return 1;
            } else {
                if (items[mid] > value) {
                    right = mid + 1;
                } else {
                    left = mid + 1;
                }

            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     *
     * @param items
     * @param value
     * @return
     */
    public int recursionHalf(int[] items, int value) {

        int left = 0;
        int right = items.length - 1;

        return rh(items, left, right, value);

    }

    private int rh(int[] items, int left, int right, int value) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (items[mid] == value) {
            return mid;
        } else {
            if (items[mid] > value) {
                return rh(items, left + 1, mid, value);
            } else {
                return rh(items, mid + 1, right, value);
            }
        }
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public int[] insertSort(int[] array) {
        int n = array.length;
        if (n <= 1) return array;
        int value;
        for (int i = 1; i < n; i++) {
            value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
        return array;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotValue = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivotValue) {
                i++;
                int tem = array[i];
                array[i] = array[j];
                array[j] = tem;
            }
        }
        int tem = array[i + 1];
        array[i + 1] = pivotValue;
        array[right] = tem;
        return i + 1;
    }

}
