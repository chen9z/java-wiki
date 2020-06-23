package wiki.alg.array;

import java.util.Arrays;

/**
 * 获取前k大数据
 * Created by chen on 2020/5/25.
 */
public class QuickSort1 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0) return new int[]{};
        int len=arr.length;
        int[] res=quickSort(arr,0,len-1,k-1);
        return res;
    }

    public int[] quickSort(int[] arr,int start,int end,int k){
        int p=partition(arr,start,end);
        if (p == k) {
            return Arrays.copyOf(arr, k+1);
        }
        return p > k ? quickSort(arr, start, p - 1, k) : quickSort(arr, p + 1, end, k);
    }
    public int partition(int[] arr,int start,int end){
        int value=arr[end];
        int j=start;
        for(int i=start;i<end;i++){
            if(arr[i]<=value){
                int tem=arr[j];
                arr[j]=arr[i];
                arr[i]=tem;
                j++;
            }
        }
        arr[end]=arr[j];
        arr[j]=value;
        return j;
    }
}
