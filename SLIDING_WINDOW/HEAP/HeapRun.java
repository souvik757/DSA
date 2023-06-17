package HEAP;

public class HeapRun {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap() ;
        heap.add(60);
        heap.getHeap() ;
        System.out.println();
        heap.add(50);
        heap.getHeap() ;
        System.out.println();
        heap.add(40);
        heap.getHeap() ;
        System.out.println();
        heap.add(10);
        heap.getHeap() ;
        System.out.println();
        heap.add(90);
        heap.getHeap() ;
        System.out.println();
        heap.add(61);
        heap.getHeap() ;
        System.out.println();
        heap.add(6) ;
        heap.getHeap() ;
        System.out.println();
        heap.pop() ;
        heap.getHeap() ;
        System.out.println();
        heap._heap_(new int[]{-99999 , 54,53,55,52,50});

        HeapSort heapSort = new HeapSort() ;
        heapSort.heapSort(new int[]{60,54,53,55,52,50});
    }
}
