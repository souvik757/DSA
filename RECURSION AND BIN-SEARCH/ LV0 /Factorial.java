import java.util.Scanner;

public class Factorial
{
    static int helper(int N)   //helper function helps to find out N!
    {
        //base case :
        if(N == 0)//since , 0! = 1
            return 1;

        //Process:
        System.out.print(N-1+" ");

        //Recurrence relation :
        return N*helper(N-1);
    }   //tail recursion .

    public  static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int RESULT = helper(N);

        System.out.println();
        System.out.println(N+"! : "+RESULT);

        sc.close();
    }
}
