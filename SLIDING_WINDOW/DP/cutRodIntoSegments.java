package DP;

import java.util.Arrays;

public class cutRodIntoSegments {
    public static void main(String[] args) {
        solve_rodIntoSegment object = new solve_rodIntoSegment() ;
        System.out.println(object.cutSegments(7,5,2,2));
        System.out.println(object.cutSegments(8,5,2,2));
    }
}
class solve_rodIntoSegment {
    public int cutSegments(int  n ,int x , int y , int z) {
//        int answer = solve(n,x,y,z) ;
        int[] dp = new int[n+1] ;
        Arrays.fill(dp,-1) ;

        return Math.max(0,solveMem(n,x,y,z,dp)) ;
    }
    private int solve(int n , int x ,int y , int z) {
        if(n == 0)
            return 0 ;
        if(n < 0)
            return Integer.MIN_VALUE ;
        int a = solve(n-x , x, y , z) + 1 ;
        int b = solve(n-y , x, y , z) + 1 ;
        int c = solve(n-z , x, y , z) + 1 ;

        return Math.max(a , Math.max(b,c)) ;
    }
    private int solveMem(int n , int x ,int y , int z , int[] dp) {
        if(n == 0)
            return 0 ;
        if(n < 0)
            return Integer.MIN_VALUE ;
        if(dp[n] != -1)
            return dp[n] ;
        int a = solveMem(n-x , x, y , z, dp) + 1 ;
        int b = solveMem(n-y , x, y , z, dp) + 1 ;
        int c = solveMem(n-z , x, y , z, dp) + 1 ;

        dp[n] = Math.max(a , Math.max(b,c)) ;

        return dp[n] ;
    }
}