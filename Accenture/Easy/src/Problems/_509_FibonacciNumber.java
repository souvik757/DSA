package Problems;

public class _509_FibonacciNumber {
    public int fib(int n) {
        if(n <= 0) return 0 ;
        int[] dp = new int[n+1] ;
        dp[0] = 0 ;
        dp[1] = 1 ;
        solve(dp , n) ;

        return dp[n] ;
    }
    private void solve(int[] dp , int n){
        for (int i = 2 ; i <= n ; i ++)
            dp[i] = dp[i-1] + dp[i-2] ;
    }
}
