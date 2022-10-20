import java.util.Scanner;

public class is_POWER_of_3 {
    static boolean isPowerOfThree(int n) {
        //base case:
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        //if n is power of 3 , n can be break down to full number of multiplier of 3.

        //relation:
        if(n%3 == 0)
            return isPowerOfThree(n/3);
        return false;//if n isn't divisible by 3 , then it isn't power of 3 anyway.

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean answer  = isPowerOfThree(N);
        System.out.println(answer);
        sc.close();

    }
}
