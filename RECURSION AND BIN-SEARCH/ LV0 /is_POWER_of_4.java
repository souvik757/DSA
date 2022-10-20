import java.util.Scanner;

public class is_POWER_of_4 {
    static boolean isPowerOfFour(int n) {
        //base case:
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        //if n is power of 4 , n can be break down to full number of multiplier of 4.

        //relation:
        if(n%4 == 0)
            return isPowerOfFour(n/4);
        return false;//if n isn't divisible by 4 , then it isn't power of 4 anyway.

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean answer  = isPowerOfFour(N);
        System.out.println(answer);
        sc.close();

    }
}
