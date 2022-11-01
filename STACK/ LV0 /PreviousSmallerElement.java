import java.util.Arrays;
import java.util.Scanner;

public class PreviousSmallerElement {
    static Scanner scan = new Scanner(System.in) ;
    public static void main(String[] args) {
        int NoOfOperation = scan.nextInt() ;
        while (NoOfOperation-->0)
        {
            int size = scan.nextInt() ;
            int[] numbers = new int[size] ;
            for (int index = 0 ; index < size ; index++)
                numbers[index] = scan.nextInt() ;
            int target = scan.nextInt() ;
            System.out.println("1 . (Brute-Force) Smallest element previous to "+target+" : "+BruteForce(numbers,target)) ;
        }
    }
    public static int BruteForce(int[] numbers , int target){
        int IndexOfTarget = -1 ;
        for(int i = 0 ; i < numbers.length ; i++) // O(N)
        {
            if(numbers[i] == target) {
                IndexOfTarget = i ;
                break ;
            }
        }
        if(IndexOfTarget == -1 || IndexOfTarget == 0)
            return -1 ;
        int PreviousSmall = -1 ;
        for (int i = IndexOfTarget ; i >= 0 ; i--) { // nearly O(N) but it depends on the index of target :
            if(numbers[i] < target) {
                PreviousSmall = numbers[i] ;
                break ;
            }
        }
        return PreviousSmall ;
    }
}
