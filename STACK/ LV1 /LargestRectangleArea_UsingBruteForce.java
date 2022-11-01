import java.util.Scanner;

public class LargestRectangleArea_UsingBruteForce {
    static Scanner scan = new Scanner(System.in) ;
    public static void main(String[] args) {
        int size = scan.nextInt() ;
        int[] LengthOfBars = new int[size] ;
        for(int i = 0 ; i < size ; i++)
            LengthOfBars[i] = scan.nextInt() ;
        System.out.println("1. Brute-Force --> Largest Area : " + BruteForce(LengthOfBars)) ;
    }
    public static int BruteForce(int[] LengthOfBars){
        int MyAnswer = Integer.MIN_VALUE ;
        for(int i = 0 ; i < LengthOfBars.length ; i++)//O(N)
        {
            int right = RightSmallestIndex(LengthOfBars , i) ; // O(N)
            int left = LeftSmallestIndex(LengthOfBars , i) ;   // O(N)
            System.out.println(left+"<--left || right-->"+right);
            int width = right-left-1 ;
            MyAnswer = Integer.max((width*LengthOfBars[i]) , MyAnswer) ;
        }// O(N*N)
        return MyAnswer ;
    }
    public static int LeftSmallestIndex(int[] numbers , int target) {
        int PreviousSmallIndex = -1;
        for (int i = target; i >= 0; i--) { // nearly O(N) but it depends on the index of target :
            if (numbers[i] < numbers[target]) {
                PreviousSmallIndex = i;
                break;
            }
        }
        return PreviousSmallIndex;
    }
    public static int RightSmallestIndex(int[] numbers , int target){
        if(target == numbers.length-1)
            return numbers.length ;
        int NextSmallIndex = numbers.length ;
        for (int i = target ; i < numbers.length ; i++) { // nearly O(N) but it depends on the index of target :
            if(numbers[i] < numbers[target]) {
                NextSmallIndex = i ;
                break ;
            }
        }
        return NextSmallIndex ;
    }
}
