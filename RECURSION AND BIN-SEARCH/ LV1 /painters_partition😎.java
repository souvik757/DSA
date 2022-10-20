import java.util.Scanner;

class painters_partition
{
    static boolean ifpossible(int[] nums, int k, int mid)
    {
        int paintercounter = 1;
        int boardsum = 0;
        for(int i = 0 ; i< nums.length ; i++)
        {
            if(boardsum + nums[i] <= mid)
                boardsum += nums[i];
            else
            {
                paintercounter++;
                if(paintercounter>k || nums[i]>mid)
                    return false;
                boardsum = nums[i];
            }
        }
        return true;
    }
    static int get_min_time_to_paint(int[] nums ,int k)
    {
        int s = 0 ;
        int sum = 0;
        for(int i =0 ; i<nums.length ; i++)
            sum += nums[i];
        int l = sum;
        int ans = -1;
        while (s<=l)
        {
            int mid = s+(l-s)/2;
            if(ifpossible(nums,k,mid))
            {
                l = mid - 1;
                ans = mid;
            }
            else
                s = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {10,20,30,40,50};
        int k = sc.nextInt();
        int ANSWER = get_min_time_to_paint(nums,k);
        System.out.println(ANSWER);
    }
}
