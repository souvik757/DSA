package DP.BuyAndSellStock;

import java.util.Arrays;

public class III {
    public static void main(String[] args) {
        SOLVE_123 object = new SOLVE_123() ;
        System.out.println(object.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(object.maxProfit(new int[]{1,2,3,4,5}));
    }
}
class SOLVE_123 {
    private int solve(int index , int buy , int limit , int[] prices , int[][][] dp) {
        if (index == prices.length) return 0 ;
        if (limit == 0) return 0 ;
        if (dp[index][buy][limit] != -1)
            return dp[index][buy][limit] ;
        int profit = 0;
        if (buy == 1){
            int _buy_ = -prices[index] + solve(index+1 , 0 , limit , prices , dp) ;
            int _skip_= solve(index+1 , 1 , limit , prices , dp) ;
            profit = Math.max(_buy_ , _skip_) ;
        }
        else{
            int _sell_ = prices[index] + solve(index+1 , 1 , limit-1 , prices , dp) ;
            int _skip_= solve(index+1 , 0 , limit , prices , dp) ;
            profit = Math.max(_sell_ , _skip_) ;
        }
        dp[index][buy][limit] = profit ;
        return dp[index][buy][limit] ;
    }
    private int solveTab(int[] prices){
        int n = prices.length ;
        int[][][] dp = new int[n+1][2][3] ;
        for (int[][] arr1 : dp){
            for (int[] arr2 : arr1)
                Arrays.fill(arr2 , 0);
        }
        for (int index = n-1 ; index >= 0 ; index --){
            for (int buy = 0 ; buy <= 1 ; buy++){
                for (int limit = 1 ; limit <= 2 ; limit++){
                    int profit = 0 ;
                    if (buy == 1){
                        int _buy_  = -prices[index] + dp[index+1][0][limit];
                        int _skip_ = dp[index+1][1][limit];
                        profit = Math.max(_buy_,_skip_) ;
                    }
                    else{
                        int _sell_  = prices[index] + dp[index+1][1][limit-1];
                        int _skip_ = dp[index+1][0][limit];
                        profit = Math.max(_sell_,_skip_) ;
                    }
                    dp[index][buy][limit] = profit ;
                }
            }
        }
        return dp[0][1][2] ;
    }
    private int solveTabOpt(int[] prices){
        int n = prices.length ;
        int[][] curr = new int[2][3] ;
        int[][] next = new int[2][3] ;
        for (int[] arr : curr)
            Arrays.fill(arr , 0) ;
        for (int[] arr : next)
            Arrays.fill(arr , 0) ;
        for (int index = n-1 ; index >= 0 ; index --){
            for (int buy = 0 ; buy <= 1 ; buy++){
                for (int limit = 1 ; limit <= 2 ; limit++){
                    int profit = 0 ;
                    if (buy == 1){
                        int _buy_  = -prices[index] + next[0][limit];
                        int _skip_ = next[1][limit];
                        profit = Math.max(_buy_,_skip_) ;
                    }
                    else{
                        int _sell_  = prices[index] + next[1][limit-1];
                        int _skip_ = next[0][limit];
                        profit = Math.max(_sell_,_skip_) ;
                    }
                    curr[buy][limit] = profit ;
                }
            }
            next = curr ;
        }
        return next[1][2] ;
    }
    public int maxProfit(int[] prices) {
//        int[][][] dp = new int[prices.length][2][3] ;
//        for (int[][] arr1 : dp){
//            for (int[] arr2 : arr1)
//                Arrays.fill(arr2 , -1);
//        }
//        return solve(0,1,2,prices , dp) ;
//        return solveTab(prices) ;
        return solveTabOpt(prices) ;
    }
}