import java.util.Scanner;

public class Fibonacci
{
    static int Fib(int N)
    {
        //base case:
        if(N == 0)
            return 0;
        if(N == 1)
            return 1;
        //Relation:
        return Fib(N-1)+Fib(N-2);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int RES = Fib(N);
        System.out.println(N+"th term : "+RES);
        sc.close();
    }
}