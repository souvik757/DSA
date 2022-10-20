import java.util.Arrays;

class operations
{
    //this will check if mid-distance can be a possible solution.
    static boolean ispossible(int[] nums, int k ,int mid)
    {
        //k is maximum cow available.
        int cowCount = 1;
        int nextCowPos = nums[0];
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] - nextCowPos>=mid)
            {
                cowCount++;
                if(cowCount == k)
                    return true;
                nextCowPos = nums[i];
            }
        }
        return false;
    }
    //this function will return maximum distance .
    static int get_answer(int[] nums, int k)
    {
        int s = 0 ;
        int ans = -1;
        int sum = 0 ;
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum += nums[i];
        }
        int l = sum;
        while (s<=l)
        {
            int mid = s + (l-s)/2;
            if(ispossible(nums,k,mid))
            {
                ans = mid;
                s = mid + 1;
            }
            else
                l = mid - 1;
        }
        return ans;
    }
}

class aggressive_cows {
    public static void main(String[] args) {
        //no of stalls , cows to be placed in.
        int[] stalls = new int[]{3,2,1,4,6};
        //no of aggressive cows :
        int k = 2;
        Arrays.sort(stalls);
        System.out.println("Maximum distance , where 2 cows will not fight : "+operations.get_answer(stalls,k));
    }
}
