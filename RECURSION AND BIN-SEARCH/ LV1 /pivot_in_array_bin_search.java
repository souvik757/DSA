import java.util.Scanner;

public class pivot_in_array_bin_search
{
    /*
    0 1 2 3 4 ->N=5
    7 9 1 2 3 -> 1
    mid = 0+4/2 = 2

     */
    static int find_pivot(int[] numbs, int N)
    {
        int s = 0 ;
        int l = N-1;
        int mid = s+(l-s)/2;
        //base case:
        while (s<l)
        {
            if(numbs[mid] >= numbs[0])
                s = mid + 1;
            else
                l = mid;

            mid = s+(l-s)/2;
        }
        return l;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbs = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            numbs[i] = sc.nextInt();
        }
        int re = find_pivot(numbs,N);
        System.out.println("pivot :"+numbs[re]);
    }
}
