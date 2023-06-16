package HEAP;

public class Kth_smallest {
    public static void main(String[] args) {
        System.out.println(SOLVE_KthSmallest.kthSmallest(new int[]{7,10,4,3,20,15} , 3));
        System.out.println(SOLVE_KthSmallest.kthSmallest(new int[]{7,10,4,20,15} , 4));
    }
}
class SOLVE_KthSmallest{
    public static int kthSmallest(int[] arr , int k){
        heap priorityQueue = new heap() ;
        for (int i = 0 ; i < k ; i++)
            priorityQueue.add(arr[i]) ;
        for (int i = k ; i < arr.length ; i ++){
            if(arr[i] < priorityQueue.top()){
                priorityQueue.pop() ;
                priorityQueue.add(arr[i]);
            }
        }
        return priorityQueue.top();
    }
}