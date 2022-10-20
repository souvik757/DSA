import java.util.Scanner;
//it returns sum of length-th powers  of all digits in a number.
//eventually , if returned answer is same as original number , it is an armstrong number .
public class armstrong {
    static int myPow(int M, int N)//custom pow function👌
    {
        if(N == 0)
            return 1;
        if(N == 1)
            return M;
        int ans = myPow(M,N/2);
        if(N%2 == 0)
            return ans*ans;
        else
            return M*ans*ans;
    }
    static int checker(int num ,int res, int N)
    {
        if(num == 0)
            return res;
        int rem = num%10;
        res += myPow(rem,N);
        num /= 10;
        return checker(num,res,N);
    }
    static int length(int n)
    {
        int l = 0;
        while (n != 0)
        {
            l++;
            n = n/10;
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n = length(N);
        System.out.println(checker(N,0,n));

    }
}