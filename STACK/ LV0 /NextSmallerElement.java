import java.util.*;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        int NoOfOperation = scan.nextInt() ;
        while (NoOfOperation-->0)
        {
            int size = scan.nextInt() ;
            int[] numbers = new int[size] ;
            for (int index = 0 ; index < size ; index++)
                numbers[index] = scan.nextInt() ;
            int target = scan.nextInt() ;
            System.out.println("1 . (Brute-Force) Smallest element next to "+target+" : "+BruteForce(numbers,target)) ;
            System.out.println("2 . (Optimized-Stack-Approach) Smallest element next to each elements : "+ Arrays.toString(OptimizedStack(numbers))) ;
        }
    }

    public static int BruteForce(int[] numbers , int target) {
        int IndexOfTarget = -1 ;
        for(int i = 0 ; i < numbers.length ; i++) // O(N)
        {
            if(numbers[i] == target) {
                IndexOfTarget = i ;
                break ;
            }
        }
        if(IndexOfTarget == -1 || IndexOfTarget == numbers.length-1)
            return -1 ;
        int NextSmall = -1 ;
        for (int i = IndexOfTarget ; i < numbers.length ; i++) { // nearly O(N) but it depends on the index of target :
            if(numbers[i] < target) {
                NextSmall = numbers[i] ;
                break ;
            }
        }
        return NextSmall ;
    }// T.C : O(2*N) average case :
    public static int[] OptimizedStack(int[] numbers){
        Stack<Integer> MyStack = new Stack<>() ;
        MyStack.push(-1) ;
        int[] MyAnswer = new int[numbers.length] ;
        for (int i = numbers.length-1 ; i>=0 ; i--){ // O(N)
            int current = numbers[i] ;
            while (MyStack.peek() >= current){
                MyStack.pop() ;
            }
            MyAnswer[i] = MyStack.peek() ;
            MyStack.push(current) ;
        }
        return MyAnswer ;
    }
}
