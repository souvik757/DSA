public class SOLVEDAY13 {
    // QUES 416 . Partition Equal Subset Sum :::
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 != 0)
            return false;
        int T = sum/2 ;
        Boolean[][] dp = new Boolean[nums.length][T + 1];

        return solveMem(0, nums, nums.length, sum / 2, dp) ;
    }
    // resursion + memoization :::
    private boolean solveMem(int index , int[] nums , int N, int target , Boolean[][] dp) {
        // base case :::
        if (index >= N || target < 0 )
            return false ;
        // return case :::
        if (target == 0)
            return true ;

        if(dp[index][target] != null)
            return dp[index][target] ;

        boolean include = solveMem(index+1 , nums , N , target - nums[index] , dp) ;
        boolean exclude = solveMem(index+1 , nums , N , target , dp) ;

        return dp[index][target] = include || exclude ;
    }
    // recursion :::
    private boolean solve(int index , int[] nums , int N, int target) {
        // base case :::
        if (index >= N || target < 0 )
            return false ;
        // return case :::
        if (target == 0)
            return true ;

        boolean include = solve(index+1 , nums , N , target - nums[index]) ;
        boolean exclude = solve(index+1 , nums , N , target) ;

        return include || exclude ;
    }





    // QUES 152 . Maximum Product Sub Array :::
    public int maxProduct(int[] nums) {
        int MaxProduct = nums[0] ;
        int product = 1 ;
        int N = nums.length; ;
        for (int i = 0 ; i < N ; i++){
            product *= nums[i] ;
            MaxProduct = Math.max(MaxProduct , product) ;
            if (product == 0)
                product = 1 ;
        }

        product = 1 ;
        for (int i = N - 1 ; i >= 0 ; i --) {
            product *= nums[i] ;
            MaxProduct = Math.max(MaxProduct , product) ;
            if (product == 0)
                product = 1 ;
        }


        return MaxProduct ;
    }
}
