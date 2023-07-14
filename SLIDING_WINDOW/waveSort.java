import java.util.Arrays;

public class waveSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(waveFormArray(new int[]{4,3,2,5,4,1} , 6)));
    }
    public static int[] waveFormArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (i%2 == 0){ // even
                if (i > 0 && arr[i] < arr[i-1])
                    swap(arr, i, i-1);
                else if(i < n-1 && arr[i] < arr[i+1])
                    swap(arr , i , i+1);
            }
            else{          // odd
                if(i > 0 && arr[i] > arr[i-1])
                    swap(arr , i , i-1);
                else if(i < n-1 && arr[i] > arr[i+1])
                    swap(arr , i , i +1);
            }
        }
        return arr;
    }

    // Helper function to swap elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
