import java.util.Scanner;
//Here , pivot element is referring to MIN_ELEMENT.
public class SEARCH_in_rotated_array_bin_search
{
    static int find_pivot(int[] numbs, int N)
    {
        int s = 0;
        int l = N-1;
        //base case:
        while (s<l)
        {
            int mid = s+(l-s)/2;
            if(numbs[mid] >= numbs[0])
                s = mid + 1;
            else
                l = mid;
        }
        return s;
    }

    static int binarySearch(int[] number, int S, int N, int key)
    {

        if (S <= N)
        {
            int mid = S +(N - S)/2;
            if (number[mid] == key)
                return mid;

            if (number[mid] > key)
                return binarySearch(number, S,mid-1,key);
            else
                return binarySearch(number,mid+1, N,key);
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = 5;
        int[] numbs = new int[]{7,9,1,2,3};
        int X = sc.nextInt();
        int pivot = find_pivot(numbs,N);
        System.out.println("pivot index : "+pivot);
        if(X>= numbs[pivot] && X<=numbs[N-1])
            System.out.println("key index : "+binarySearch(numbs,pivot,N-1,X));
        else
            System.out.println("key index : "+binarySearch(numbs,0,pivot-1,X));
    }
}