import java.util.Scanner;

public class is_POWER_of_2
{
    static boolean isPowerOfTwo(int n) {
        //base case:
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        //if n is power of 2 , n can be break down to full number of multiplier of 2.

        //relation:
        if(n%2 == 0)
            return isPowerOfTwo(n/2);
        return false;//if n isn't divisible by 2 , then it isn't power of 2 anyway.

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean answer  = isPowerOfTwo(N);
        System.out.println(answer);
        sc.close();

    }
}
