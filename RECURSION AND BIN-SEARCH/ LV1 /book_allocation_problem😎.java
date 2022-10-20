import java.util.Scanner;

class book_allocation_problem
{
    static boolean ispossible(int[] nums, int m, int mid)
    {
        int studentCount = 1;
        int pagesum = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(pagesum+nums[i] <= mid)
                pagesum += nums[i];
            else
            {
                studentCount++;
                if(studentCount>m || nums[i]>mid)
                    return false;
                pagesum = nums[i];
            }
        }
        return true;
    }
    static int min_optimistic(int[] nums, int n ,int m)
    {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        int s=0;
        int l = sum;
        int ans = -1;
        while (s<=l)
        {
            int mid = s+(l-s)/2;
            if(ispossible(nums,m,mid))
            {
                ans = mid;
                l = mid - 1;
            }
            else
            {
                s = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbs = new int[N];
        for (int i = 0; i < N; i++)
            numbs[i] = sc.nextInt();
        int m = sc.nextInt();
        int ANS = min_optimistic(numbs,numbs.length,m);
        System.out.println(ANS);
    }
}
