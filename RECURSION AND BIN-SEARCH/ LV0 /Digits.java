import java.util.Scanner;

public class Digits
{
    static void helper(int N)
    {
        //base case:
        if(N == 0)
            return;
        //relation.
        helper(N/10);
        //process
        System.out.print(N%10+" ");
    }//head recursion.
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        helper(N);
        sc.close();
    }
}