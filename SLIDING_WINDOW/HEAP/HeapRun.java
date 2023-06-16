package HEAP;

import java.util.Objects;

public class HeapRun {
    public static void main(String[] args) {
        heap heap = new heap() ;
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
    }
}
