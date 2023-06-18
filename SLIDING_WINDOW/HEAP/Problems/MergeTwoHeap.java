package HEAP.Problems;

import java.util.Arrays;

public class MergeTwoHeap {
    public static void main(String[] args) {
        _SOLVE_ obj = new _SOLVE_() ;
        System.out.println(Arrays.toString(obj.MergeHeap(new int[]{10,5,6,2} ,
                new int[]{12,7,9})));
    }
}
class _SOLVE_{
    private int size ;
    private int[] answer ;
    public int[] MergeHeap(int[] heap1 , int[] heap2){
        size = heap1.length+ heap2.length ;
        answer = new int[size] ;
        int k = 0 ;
        for (int val : heap1) answer[k++] = val;
        for (int val : heap2) answer[k++] = val;
        int index = size/2 - 1 ;
        for (int i = index ; i >= 0 ; i --){
            Heapify(size , i) ;
        }
        return answer ;
    }
    // 0 based MaxHeap
    private void Heapify(int size , int index){
        int largestIndex = index ;
        int left  = 2*index + 1  ;
        int right = 2*index + 2  ;

        if(left  < size && answer[largestIndex] < answer[left])
            largestIndex = left ;

        if(right < size && answer[largestIndex] < answer[right])
            largestIndex = right ;

        if(largestIndex != index){
            int temp = answer[index] ;
            answer[index] = answer[largestIndex] ;
            answer[largestIndex] = temp ;
            index = largestIndex ;
            Heapify(size , index);
        }
    }
}