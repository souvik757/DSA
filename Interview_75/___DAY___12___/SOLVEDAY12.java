import java.util.Collections;
import java.util.Vector;

public class SOLVEDAY12 {
    // QUES 198. House Robber :::
    public int rob(int[] nums) {
        int[] RobbedAmount = new int[nums.length+1] ;
        RobbedAmount[0] = 0 ;
        RobbedAmount[1] = nums[0] ;
        for (int i = 1 ; i < nums.length ; i ++)
            RobbedAmount[i+1] = Math.max(RobbedAmount[i], RobbedAmount[i-1]+nums[i]) ;
        return (nums.length == 0) ? 0 : RobbedAmount[nums.length] ;
    }
    // QUES 322. Coin Change :::
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1] ;
        for (int i = 0 ; i < dp.length ; i ++)
            dp[i] = Integer.MAX_VALUE ;
        dp[0] = 0 ;
        for (int i = 1 ; i <= amount ; i ++) {
            for (int j = 0 ; j < coins.length ; j ++) {
                if(i-coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE )
                    dp[i] = Math.min(dp[i] , 1+dp[i-coins[j]]) ;
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount] ;
    }
}
