package HEAP.Problems;

import java.util.*;

public class _295_MedianOfDataStream {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder() ;
        int element = -1 ;
        int choice = -99999999 ;
        while (choice != -1){
            System.out.println("add : 1\nbreak : -1\n->");
            choice = new Scanner(System.in).nextInt() ;
            if (choice == 1) {
                System.out.println("element ->");
                element = new Scanner(System.in).nextInt();
                obj.addNum(element);
                System.out.println("median -> " + obj.findMedian());
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder {
    private double median = 0;
    private Queue<Integer> minHeap ;
    private Queue<Integer> maxHeap ;
    public MedianFinder() {
        minHeap = new PriorityQueue<>() ;
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder()) ;
    }

    public void addNum(int num) {
        callMedian(num);
    }

    public double findMedian() {
        return median ;
    }


    private int sigNum(int a , int b){
        if(a == b)
            return 0 ;
        else if(a > b)
            return 1 ;
        return -1 ;
    }
    private void callMedian(int element){
        switch (sigNum(maxHeap.size(), minHeap.size())) {
            case 0 -> {
                if (element > median) {
                    minHeap.offer(element);
                    median = minHeap.peek();
                } else {
                    maxHeap.offer(element);
                    median = maxHeap.peek();
                }
            }
            case 1 -> {
                if (element > median) {
                    minHeap.offer(element);
                } else {
                    minHeap.offer(maxHeap.peek());
                    maxHeap.poll();
                    maxHeap.offer(element);
                }
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            case -1 -> {
                if (element > median) {
                    maxHeap.offer(minHeap.peek());
                    minHeap.poll();
                    minHeap.offer(element);
                } else {
                    maxHeap.offer(element);
                }
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
}