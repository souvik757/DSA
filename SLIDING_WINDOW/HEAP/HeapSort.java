package HEAP;
// Using 0 indexed MaxHeap
public class HeapSort {
    public void heapSort(int[] arr) {
        int size = arr.length;
        for (int i = size / 2 - 1; i >= 0; i--) { // in case of 1 based indexing i = size / 2
            heapify(arr, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        System.out.println("-> index   val");
        for (int i = 0; i < size; i++) {
            System.out.println("->   " + i + "    " + arr[i]);
        }
    }

    private void heapify(int[] arr, int size, int i) {
        int largestIndex = i;
        int leftIndex    = 2 * i + 1;
        int rightIndex   = 2 * i + 2;

        if (leftIndex < size && arr[leftIndex] > arr[largestIndex])
            largestIndex = leftIndex;

        if (rightIndex < size && arr[rightIndex] > arr[largestIndex])
            largestIndex = rightIndex;

        if (largestIndex != i) {
            int temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapify(arr, size, largestIndex);
        }
    }
}
