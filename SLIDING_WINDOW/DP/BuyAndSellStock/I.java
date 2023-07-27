package DP.BuyAndSellStock;

public class I {
    public static void main(String[] args) {
        System.out.println(SOLVE_121.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(SOLVE_121.maxProfit(new int[]{7,6,4,3,1}));
    }
}
class SOLVE_121 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0 ;           // profit or price at which I want to sell , I have to sell at max price
        int minimumPrice = prices[0] ;// price at which I want to buy , I have to buy at minimum price
        for (int i = 1 ; i < prices.length ; i ++){
            int difference = prices[i] - minimumPrice ;
            maxProfit = Math.max(maxProfit , difference) ;
            minimumPrice = Math.min(minimumPrice , prices[i]) ;
        } // I have to find the maximum difference between bought price and sell price , that will be my max profit
        return maxProfit ;
    }
}