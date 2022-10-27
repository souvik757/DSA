import java.util.Arrays;
import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        System.out.print(" n : ") ;
        int n = scan.nextInt() ;
        System.out.print(" k : ") ;
        int k = scan.nextInt() ;
        int[] num_arr = new int[n] ;
        for (int i = 0 ; i < n ; i++)
            num_arr[i] = i+1 ;
        System.out.print(Arrays.toString(num_arr));

    }
}