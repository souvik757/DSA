public class _918_MaxSumCircularSubArray {
    public static void main(String[] args) {
        solve_918 object = new solve_918() ;
        System.out.println(object.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(object.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(object.maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }
}
class solve_918 {
    public int maxSubarraySumCircular(int[] nums) {
        // 1 . find kadane sum1
        // 2 . find total sumT & revert sign of array elements
        // 3 . find kadane sum2 = 0 - sum2
        // 4 . (sum2 == sumT) -> sum1
        // 5 . max(sum1 , sumT-sum2)
        int maxSubSum = maxSubArray(nums) ;
        int totalSum = sum(nums) ;
        int minSubSum = -maxSubArray(nums) ;
        if(totalSum == minSubSum)
            return maxSubSum ;
        int maxCircularSum = totalSum - minSubSum ;

        return Math.max(maxSubSum , maxCircularSum) ;
    }
    private int sum(int[] nums){
        int sum = 0 ;
        for (int i = 0 ; i < nums.length ; i ++){
            sum += nums[i] ;
            nums[i] = -nums[i] ;
        }
        return sum ;
    }
    private int maxSubArray(int[] nums) {
        int sum = 0 ;
        int maxSum = nums[0] ;
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum += nums[i] ;
            maxSum = Math.max(maxSum , sum) ;
            if(sum < 0)
                sum = 0 ;
        }
        return maxSum ;
    }
}