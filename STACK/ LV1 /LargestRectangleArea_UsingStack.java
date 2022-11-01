import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleArea_UsingStack {
    static Scanner scan = new Scanner(System.in) ;
    public static void main(String[] args) {
        int size = scan.nextInt() ;
        int[] LengthOfBars = new int[size] ;
        for(int i = 0 ; i < size ; i++)
            LengthOfBars[i] = scan.nextInt() ;
        System.out.println("2. Optimized-Stack --> Largest Area : " + OptimizedStack(LengthOfBars)) ;
    }
    public static int OptimizedStack(int[] LengthOfBars){
        int[] left;
        int[] right;
        left = LeftIndex(LengthOfBars) ;
        right = RightIndex(LengthOfBars) ;
        System.out.println(Arrays.toString(left)+" "+Arrays.toString(right));
        int LargestArea = Integer.MIN_VALUE ;
        for(int i = 0 ; i < LengthOfBars.length ; i++){ // O(N)
            if(right[i] == -1)
                right[i] = LengthOfBars.length;
            int width = right[i] - left[i] - 1 ;
            LargestArea = Math.max((LengthOfBars[i]*width) ,LargestArea) ;
        }//o(N)
        return LargestArea ;
    }
    public static int[] RightIndex(int[] numbers){
        Stack<Integer> MyStack = new Stack<>() ;
        MyStack.push(-1) ;
        int[] MyAnswer = new int[numbers.length] ;
        for (int i = numbers.length-1 ; i>=0 ; i--){ // O(N)
            int current = numbers[i] ;
            while (MyStack.peek() != -1 &&numbers[MyStack.peek()] >= current){
                MyStack.pop() ;
            }
            MyAnswer[i] = MyStack.peek() ;
            MyStack.push(i) ;
        }
        return MyAnswer ;
    }

    public static int[] LeftIndex(int[] numbers){
        Stack<Integer> MyStack = new Stack<>() ;
        MyStack.push(-1) ;
        int[] MyAnswer = new int[numbers.length] ;
        for (int i = 0 ; i < numbers.length ; i++){ // O(N)
            int current = numbers[i] ;
            while (MyStack.peek() != -1 &&numbers[MyStack.peek()] >= current){
                MyStack.pop() ;
            }
            MyAnswer[i] = MyStack.peek() ;
            MyStack.push(i) ;
        }
        return MyAnswer ;
    }
}
