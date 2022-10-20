import java.util.Scanner;

public class Binary_search
{
    static boolean binarySearch(int[] number, int S, int N, int key)
    {
        if(S>N)
            return false;

        int mid = S + (N - S)/2;


        if (number[mid] == key)
            return true;

        if (number[mid] > key)
            return binarySearch(number, S, mid-1, key);

        return binarySearch(number, mid+1, N, key);
    }



    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] number = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            number[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        boolean answer = binarySearch(number,0,N-1,key);
        System.out.println(key+" : "+answer);
        sc.close();
    }
}
