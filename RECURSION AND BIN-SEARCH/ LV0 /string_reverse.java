import java.util.Scanner;

public class string_reverse {
    static void helper(char[] S, int L, int N)
    {
        //base case:
        if(N< 1)
            return;

        //relation:
        helper(S, L+1, N-1);

        //process:
        System.out.print(S[L]);
    }//head recursion.
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String STR = sc.next();
        int N = STR.length();
        char[] S = STR.toCharArray();
        helper(S,0,N);
        sc.close();


    }
}