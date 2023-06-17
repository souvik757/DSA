package HEAP;

public class MinHeap {
    private int   size    ;
    private int[] numbers ;

    public MinHeap() {
        numbers = new int[1000000000] ;
        size = 0 ;
        numbers[0] = - 1 ;
    }

    public MinHeap(int N){
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
            if(numbers[parent] > numbers[index]){ // in case of MinHeap '>'
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

            int smallestIndex = index;
            if (leftIndex <= size && numbers[leftIndex] < numbers[smallestIndex])
                smallestIndex = leftIndex;
            if (rightIndex <= size && numbers[rightIndex] < numbers[smallestIndex])
                smallestIndex = rightIndex;

            if (smallestIndex != index) {
                swap(smallestIndex, index);
                index = smallestIndex;
            }
            else
                return;
        }
    }
    public int top(){
        return numbers[1] ;
    }
    // swap function
    protected final void swap(int x ,int y){
        int temp = numbers[x];
        numbers[x] = numbers[y] ;
        numbers[y]=temp ;
    }
}
