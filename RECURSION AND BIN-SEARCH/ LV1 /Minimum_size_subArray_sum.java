import java.util.Scanner;
/*
Example 1:

Input: target = 7, numbs = [2,3,1,2,4,3]
Output: 2
Explanation: The subArray [4,3] has the minimal length under the problem constraint.

Example 2:

Input: target = 4, numbs = [1,4,4]
Output: 1

Example 3:

Input: target = 11, numbs = [1,1,1,1,1,1,1,1]
Output: 0

 */
public class Minimum_size_subArray_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.print(" Enter size of the array : ") ;
        int size = sc.nextInt() ;
        int[] numbs = new int[size] ;
        System.out.print(" target : ") ;
        int target = sc.nextInt() ;
        System.out.print(" elements : ") ;
        for(int index = 0 ; index < size ; index++)
            numbs[index] = sc.nextInt() ;
        int t ;
        do {
            System.out.println("1 . Brute Force approach : ") ;
            System.out.println("2 . Binary Search : ") ;
            System.out.println("3 . EXIT : ") ;
            t = sc.nextInt() ;
            switch (t)
            {
                case 1 -> Brute_force_1(numbs , target) ;
                case 2 -> logarithmic_search(numbs , target) ;
                case 3 -> System.exit(0);
            }
        }while (t != -1) ;
    }
    public static void Brute_force_1(int[] numbs , int target)
    {
        int ans = Integer.MAX_VALUE ;
        for(int i = 0 ; i < numbs.length ; i++)
        {
            for(int j = i ; j < numbs.length ; j++)
            {
                int sum = 0 ;
                for(int k = i ; k <= j ; k++)
                {
                    sum += numbs[k];
                }
                if(sum >= target)
                {
                    ans = Math.min(ans , j-i+1) ;
                    break ;
                }
            }
        }
        if(ans != Integer.MAX_VALUE)
            System.out.println(ans);
        else
            System.out.println(0);
    }
    public static void logarithmic_search(int[] numbs , int target)
    {

    }
}
