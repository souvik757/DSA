package DP;
import java.util.Arrays;

public class _44_WildcardPattern {
    public static void main(String[] args) {
        solve_44 object = new solve_44() ;
        System.out.println(object.isMatch("abcde" , "a*c?e"));
        System.out.println(object.isMatch("aa" , "a"));
        System.out.println(object.isMatch("abc" , "*?"));
    }
}
class solve_44 {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()] ;
        for (int[] arr : dp) Arrays.fill(arr,-1) ;
        return solve(s , p , s.length()-1 , p.length()-1 , dp) ;
    }
    private boolean solve(String str , String ptr , int i , int j , int[][] dp){
        // edge cases
        if(i<0 && j<0)
            return true ;// already traversed
        if(i>=0 && j<0)
            return false;// pattern ran out
        if(i<0 && j>=0){ // string traversed but remaining pattern
            for (int index = 0 ; index <= j ; index++){
                if(ptr.charAt(index) != '*')
                    return false ;
            }// hence , * can be replaced with null char
            return true ;
        }
        if(dp[i][j] != -1)
            return dp[i][j]==1 ;

        // match cases
        boolean flag = false ;
        if (str.charAt(i) == ptr.charAt(j)|| (ptr.charAt(j) == '?'))
            flag = solve(str, ptr, i - 1, j - 1, dp) ;
        else if(ptr.charAt(j) == '*')
            flag = solve(str, ptr, i - 1, j, dp) || solve(str, ptr, i, j - 1, dp) ;

        dp[i][j] = (flag) ? 1 : 0 ;

        return flag ;
    }
    private boolean solveTab(String str ,String ptr){
        int m = str.length() ;
        int n = ptr.length() ;
        boolean[][] dp = new boolean[m+1][n+1] ;
        dp[0][0] = true ;
        for (int i = 0 ; i < n ; i ++){
            if(ptr.charAt(i) == '*')
                dp[0][i+1] = dp[0][i] ;
        }

        for (int i = 1 ; i <= m ; i ++){
            for (int j = 1 ; j <= n ; j ++){
                if(str.charAt(i-1) == ptr.charAt(j-1) || ptr.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1] ;
                else if(ptr.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] ;
            }
        }

        return dp[m][n] ;
    }
    private boolean solveTabOpt(String str ,String ptr){
        int m = str.length() ;
        int n = ptr.length() ;
        boolean[] prev = new boolean[n+1] ;
        boolean[] curr = new boolean[n+1] ;
        prev[0] = true ;
        for (int i = 0 ; i < n ; i ++){
            if(ptr.charAt(i) == '*')
                prev[i+1] = prev[i] ;
        }

        for (int i = 1 ; i <= m ; i ++){
            for (int j = 1 ; j <= n ; j ++){
                if(str.charAt(i-1) == ptr.charAt(j-1) || ptr.charAt(j-1) == '?')
                    curr[j] = prev[j-1] ;
                else if(ptr.charAt(j-1) == '*')
                    curr[j] = prev[j] || curr[j-1] ;
            }
            prev = curr.clone() ;
            curr = new boolean[n+1] ;
        }

        return prev[n] ;
    }
    private boolean solveTabOpt_(String str, String ptr) {
        int m = str.length();
        int n = ptr.length();
        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];
        prev[0] = true;

        for (int j = 1; j <= n; j++) {
            boolean flag = true;
            for (int k = 1; k <= j; k++) {
                if (ptr.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            prev[j] = flag;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == ptr.charAt(j - 1) || ptr.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (ptr.charAt(j - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            prev = curr.clone(); // Copy the values of curr to prev
            curr = new boolean[n + 1]; // Create a new array for curr
        }

        return prev[n];
    }
}