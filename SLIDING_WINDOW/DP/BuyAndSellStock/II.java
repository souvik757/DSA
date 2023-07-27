package DP.BuyAndSellStock;

import java.util.Arrays;

public class II {
    public static void main(String[] args) {
        SOLVE_122 object = new SOLVE_122() ;
        System.out.println(object.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
class SOLVE_122 {
    private int solve(int index , int buy , int[] prices , int[][] dp) {
        if (index == prices.length)
            return 0 ;
        if (dp[index][buy] != -1) return dp[index][buy] ;
        int profit = 0 ;
        if (buy == 1){
            int _buy_  = -prices[index] + solve(index+1 , 0 , prices, dp);
            int _skip_ = solve(index+1 , 1 , prices , dp);
            profit = Math.max(_buy_,_skip_) ;
        }
        else{
            int _sell_  = prices[index] + solve(index+1 , 1 , prices , dp);
            int _skip_ = solve(index+1 , 0 , prices , dp);
            profit = Math.max(_sell_,_skip_) ;
        }
        dp[index][buy] = profit ;
        return dp[index][buy] ;
    }
    private int solveTab(int[] prices){
        int n = prices.length ;
        int[][] dp = new int[n+1][2] ;
        for (int[] arr : dp) Arrays.fill(arr , 0) ;
        for (int index = n-1 ; index >= 0 ; index --){
            for (int buy = 0 ; buy <= 1 ; buy++){
                int profit = 0 ;
                if (buy == 1){
                    int _buy_  = -prices[index] + dp[index+1][0];
                    int _skip_ = dp[index+1][1];
                    profit = Math.max(_buy_,_skip_) ;
                }
                else{
                    int _sell_  = prices[index] + dp[index+1][1];
                    int _skip_ = dp[index+1][0];
                    profit = Math.max(_sell_,_skip_) ;
                }
                dp[index][buy] = profit ;
            }
        }
        return dp[0][1] ;
    }
    private int iterativeOpt(int[] prices){
        int profit = 0 ;
        for (int i = 1 ; i < prices.length ; i ++){
            if (prices[i] > prices[i-1])
                profit += (prices[i] - prices[i-1]) ;
        }
        return profit ;
    }
    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length][2] ;
//        for (int[] arr : dp)
//            Arrays.fill(arr , -1);
//        return solve(0 , 1 , prices , dp) ;
//        return solveTab(prices) ;
        return iterativeOpt(prices) ;
    }
}