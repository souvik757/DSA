import java.util.Scanner;

public class sqrt_root
{
    static int get_root(int N)
    {
        int s = 1;
        int l = N;
        if(N == 1)
            return 1;
        int ans = -1;
        while (s<=l)
        {
            int mid = s+(l-s)/2;
            if(Math.pow(mid,2) == N)
                return mid;

            if(Math.pow(mid,2)>N)
            {
                l = mid - 1;
            }
            else
            {
                ans = mid;
                s = mid + 1;

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0)
        {
            int N = sc.nextInt();
            System.out.println(get_root(N));
        }
    }
}
