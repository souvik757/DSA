import java.util.Scanner;

public class counting_OR_printing
{
    static void back_print(int N)
    {
        //base case:
        if(N == 0)
            return ;//System.out.print("");

        //Processing:
        System.out.print(N+" ");

        //recurrence relation:
        back_print(N-1);
    }//tail recursion.

    static void front_print(int N)
    {
        //base case:
        if(N == 0)
            return ;//System.out.print("");

        //recurrence relation:
        front_print(N-1);

        //Processing:
        System.out.print(N+" ");
    }//head recursion.
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println("Tail Recursion :");
        back_print(N);

        System.out.println();

        System.out.println("Head Recursion :");
        front_print(N);

        sc.close();
    }
}