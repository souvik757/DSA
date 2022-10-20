import java.util.Scanner;

public class sqrt_root_decimal
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
    static float precession(int ans, int decimal , int N)
    {
        float count = 1;
        float round = ans;
        for(int i = 0 ; i<decimal ; i++)
        {
            count = count/10;
            for(float j = round ; j*j < N ; j+=count)
            {
                round = j;
            }
        }
        return round;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0)
        {
            int N = sc.nextInt();
            int Y = get_root(N);
            int d = sc.nextInt();
            float decimal_root = precession(Y,d,N);
            System.out.println(decimal_root);
            System.out.println("Up to "+d+" decimal is exact !");
        }
    }
}
