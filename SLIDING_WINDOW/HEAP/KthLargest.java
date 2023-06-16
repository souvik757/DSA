package HEAP;

public class KthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4} , 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6} , 4));
    }
    public static int findKthLargest(int[] nums, int k) {
        MinHeap priorityQueue = new MinHeap(nums.length) ;
        for (int i = 0 ; i < k ; i ++)
            priorityQueue.add(nums[i]);
        for (int i = k ; i < nums.length ; i ++){
            if(nums[i] > priorityQueue.top()){
                priorityQueue.pop() ;
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.top() ;
    }
}
