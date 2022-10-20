import java.util.Scanner;

public class occurrence_of_digit
{
    static int first_occ(int[] num,int N, int k)
    {
        int s = 0;
        int l = N-1;
        int mid = s + (l-s)/2;
        int ans = -1;
        while (s<=l) //bounding condition :
        {
            if(num[mid] == k)
            {
                ans = mid;
                l = mid - 1;//go to left part
            }
            else if (num[mid]>k)
            {
                l = mid - 1;
            }
            else
                s = mid + 1;

            mid = s+(l-s)/2;
        }
        return ans;
    }
    static int last_occ(int[] num,int N, int k)
    {
        int s = 0;
        int l = N-1;
        int mid = s + (l-s)/2;
        int ans = -1;
        while(s<=l)
        {
            if(num[mid] == k)
            {
                ans = mid;
                s = mid + 1;//go to right part
            }
            else if (num[mid]>k)
            {
                l = mid - 1;
            }
            else
                s = mid + 1;

            mid = s+(l-s)/2;
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] even = new int[N];
        for(int i = 0 ; i < N  ; i++) {
            even[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int ANS = first_occ(even,N,k);
        int ANS_0 = last_occ(even,N,k);
        System.out.println("Fist Occ."+"    "+"last Occ.");
        System.out.println(ANS+"            "+ANS_0);
        int r = (ANS_0-ANS)+1;
        System.out.println("Frequency :"+r);

    }
}
