import java.util.Scanner;

public class peak_of_mountain
{
    static int get_element(int[] numbs, int N)
    {
        int s = 0;
        int l = N-1;
        int mid = s+(l-s)/2;
        while (s<l)
        {
            if(numbs[mid] < numbs[mid+1])
            {
                s = mid + 1;
            }
            else
            {
                l = mid;
            }
            mid = s+(l-s)/2;
        }
        return s;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] even = new int[N];
        for(int i = 0 ; i < N  ; i++) {
            even[i] = sc.nextInt();
        }
        int r = get_element(even,N);
        System.out.println(even[r]);

    }
}
