import java.util.Scanner;

//2^N = 2^N * 2^(N-1)
// f(N) = 2^N*f(N-1) ; where f(N) = 2^N

public class Exp_N
{
    static int helper_1(int N)
    {
        //Base Case:
        if(N == 0)//since , 2^0 = 1
            return 1;

        //recurrence relation:
        return 2*helper_1(N-1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = helper_1(N);

        System.out.println("2^"+N+" : "+answer);
        sc.close();
    }
}