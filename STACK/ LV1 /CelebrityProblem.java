import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    static Scanner sc =new Scanner(System.in) ;
    public static void main(String[] args) {
        int row = sc.nextInt() ;
        int col = sc.nextInt() ;
        int[][] M = new int[row][col] ;
        for(int i = 0 ; i < row ; i++)
        {
            System.out.print((i+1)+" row : ");
            for(int j = 0 ; j < col ; j++)
                M[i][j] = sc.nextInt() ;
        }
        System.out.println("\nCelebrity --> "+(SolveOptimizedStack(M)+1)+" no. person") ;
    }
    public static int SolveOptimizedStack(int[][] M){
        Stack<Integer> MyStack = new Stack<>() ;
        // 1. push persons(no. of rows/columns) in stack :
        for(int i = 0 ; i < M[0].length ; i++)
            MyStack.push(i) ;
        // 2. Compare between two top elements of stack :
        while (MyStack.size() != 1){
            int a = MyStack.peek() ;
            MyStack.pop() ;
            int b = MyStack.peek() ;
            MyStack.pop() ;
            if(knows(M, a, b))
                MyStack.push(b) ;
            else
                MyStack.push(a) ;
        }
        // whoever have come this far , he is a potential candidate :
        // 3. Verify if he is a celebrity or not :
        // CONDITIONS :
        //            1. Celebrity doesn't know any one .
        //            2. Every one knows celebrity .
        int candidate = MyStack.peek() ;
        int RowCount = 0 ;
        int ColCount = 0 ;
        for(int i = 0 ; i < M.length ; i++)
        {
            if(M[candidate][i] == 0)
                RowCount++ ;
            if(M[i][candidate] == 1)
                ColCount++ ;
        }
        if(RowCount == M[0].length && ColCount == M.length-1)
            return candidate ;
        return -1;
    }
    public static boolean knows(int[][] M ,int a , int b){
        return M[a][b] == 1;
    }
}
