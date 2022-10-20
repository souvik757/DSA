import java.util.Scanner;

public class Sorted_or_not
{
    static void print(int[] number, int S, int N)
    {
        System.out.println("Size : "+N);
        for(int i = S ; i < number.length ; i++)
        {
            System.out.print(number[i]+" ");
        }
        System.out.println();
    }
    static boolean is_sorted(int[] number, int S, int N)
    {
        print(number,S,N);
        //base case:
        if(N == 0 || N == 1) {
            return true;
        }
        //relation:
        if(number[S] > number[S+1]) {
            return false;
        }
        return is_sorted(number,S+1,N-1);//In C/C++ , we can do something like this ->
        //return is_sorted(number+1,N-1); , in java we can't because java does not support pointer.

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] number = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            number[i] = sc.nextInt();
        }

        if(is_sorted(number,0,N))
            System.out.println("sorted");
        else
            System.out.println("not sorted");

        sc.close();
    }
}
