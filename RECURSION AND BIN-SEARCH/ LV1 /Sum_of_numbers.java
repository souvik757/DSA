import java.util.Scanner;

public class Sum_of_numbers
{
    static void print(int[] number, int S, int N)
    {
        System.out.println("Size : "+N);
        System.out.println(number[S]);
    }
    static int getSUM(int[] number, int S, int N)
    {
        print(number,S,N);
        //base case:
        if(N == 0)
            return 0;
        if(N == 1)
            return number[S];

        return number[S]+getSUM(number,S+1,N-1);
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
        int answer = getSUM(number,0,N);
        System.out.println("SUM : "+answer);
        sc.close();
    }
}
