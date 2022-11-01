import java.util.Scanner;

// Question Statement :
/*
   145 = 1! + 4! + 5!
   so 145 is a strong number .
*/

public class strong {
    static int fact(int n)
    {
        if(n == 0)
            return 1;
        return n*fact(n-1);
    }
    static int check(int N, int result)
    {
        if(N == 0)
            return result;
        int rem = N%10;
        result = result + fact(rem);
        return check(N/10,result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(check(N,0));
    }
}
