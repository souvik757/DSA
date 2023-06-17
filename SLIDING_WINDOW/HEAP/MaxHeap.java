package HEAP ;

public class MaxHeap { // MaxHeap
    private int   size    ;
    private int[] numbers ;
    public MaxHeap(){
        numbers = new int[100000000] ;
        size = 0 ;
        numbers[0] = - 1 ;
    }
    public MaxHeap(int N){
        numbers = new int[N+1] ;
        size = 0 ;
        numbers[0] = - 1 ;
    }
    public void add(int X){
        size = size + 1 ;
        int index = size ;
        numbers[index] = X ;
//        System.out.print(X+" inserted");

        while (index > 1){
            int parent = index/2 ;
            if(numbers[parent] < numbers[index]){ // in case of MinHeap '>'
                swap(parent, index);
                index = parent ;
            }
            else
                return ;
        }
    }
    public void pop() {
        if (size == 0)
            return;

//        System.out.print(numbers[1] + " deleted");
        numbers[1] = numbers[size];
        numbers[size] = 0;
        size--;

        int index = 1;
        while (index <= size) {
            int leftIndex  = 2 * index;
            int rightIndex = 2 * index + 1;

            int largestIndex = index;
            if (leftIndex <= size && numbers[leftIndex] > numbers[largestIndex])
                largestIndex = leftIndex;
            if (rightIndex <= size && numbers[rightIndex] > numbers[largestIndex])
                largestIndex = rightIndex;

            if (largestIndex != index) {
                swap(largestIndex, index);
                index = largestIndex;
            }
            else
                return;
        }
    }
    public int top(){
        return numbers[1] ;
    }
    protected final void swap(int x ,int y){
        int temp = numbers[x];
        numbers[x] = numbers[y] ;
        numbers[y]=temp ;
    }
    public void getHeap(){
        int i = 1 ;
        System.out.println();
        System.out.println("-> index"+"  val");
        for (int val : numbers){
            if(val > -1 && val != 0) {
                System.out.print("->   "+i+"    "+val+"\n");
                i ++ ;
            }
        }
    }
    public void _heap_(int[] arr){
        int n = arr.length - 1 ;
        arr[0] = -1 ;
        for (int i = n/2 ; i > 0 ; i --){
            heapify(arr , n , i);
        }
        int i = 1 ;
        System.out.println();
        System.out.println("-> index"+"  val");
        for (int val : arr){
            if(val > -1 && val != 0) {
                System.out.print("->   "+i+"    "+val+"\n");
                i ++ ;
            }
        }
    }
    private void heapify(int[] arr , int n , int i){
        int largestIndex = i ;
        int leftIndex = 2*i ;
        int rightIndex = 2*i + 1 ;
        if(leftIndex <= n && arr[largestIndex] < arr[leftIndex])
            largestIndex = leftIndex ;
        if(rightIndex <= n && arr[largestIndex] < arr[rightIndex])
            largestIndex = rightIndex ;
        if(largestIndex != i){
            int temp = arr[largestIndex] ;
            arr[largestIndex] = arr[i] ;
            arr[i] = temp ;
            heapify(arr , n , largestIndex);
        }
    }
}
