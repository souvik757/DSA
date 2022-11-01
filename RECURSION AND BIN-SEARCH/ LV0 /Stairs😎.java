import java.util.Scanner;

// Question Statement :
/*
   Initially you are at 0th step, you have to reach to Nth step .
   you can jump to next step or after next step .
   Allowed jump is 1 stair, 2 stairs , at once .
   Determine how many jump you must have made to reach Nth step at minimum cost .
*/
class Stairs
{
    static int helper(int N)
    {
        //bounding case:
        if(N<0)
            return 0;
        //base case:
        if(N == 0)
            return 1;
        //relation:
        return helper(N-1)+helper(N-2);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = helper(N);
        System.out.println("In "+res+" steps .");
        sc.close();
    }
}