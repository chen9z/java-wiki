package alg.array;

import java.util.PriorityQueue;

/**
 * Created by chen on 2020/5/25.
 */
public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.size() == 0) {
            minHeap.add(num);
        }else {
            Integer peek = minHeap.peek();
            if (num >=peek) {
                if (minHeap.size() == maxHeap.size()) {
                    minHeap.add(num);
                }else {
                    minHeap.add(num);
                    maxHeap.add(minHeap.poll());
                }
            }else {
                if (minHeap.size()==maxHeap.size()) {
                    maxHeap.add(num);
                    minHeap.add(maxHeap.poll());
                }else {
                    maxHeap.add(num);
                }
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else {
            return minHeap.peek();
        }
    }
}
