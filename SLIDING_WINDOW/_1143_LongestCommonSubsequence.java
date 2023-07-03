import java.util.Arrays;

public class _1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(SOLVE_1143.longestCommonSubsequence("abcde" , "ace"));
    }
}
class SOLVE_1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length()][text2.length()] ;
//        for (int[] arr : dp)
//            Arrays.fill(arr , -1);
//        return solve(text1,text2,0,0,dp) ;
        int[][] dpTab = new int[text1.length()+1][text2.length()+1] ;
        return solveTab(text1,text2,dpTab) ;
    }
    private static int solve(String s1 , String s2 , int i , int j , int[][] dp) { // top down
        if (i == s1.length())
            return 0 ;
        if (j == s2.length())
            return 0 ;
        if (dp[i][j] != -1)
            return dp[i][j] ;
        int ans = 0 ;
        if(s1.charAt(i) == s2.charAt(j))
            ans = 1 + solve(s1,s2,i+1,j+1,dp) ;
        else{
            ans = Math.max(solve(s1,s2,i+1,j,dp) , solve(s1,s2,i,j+1,dp)) ;
        }
        dp[i][j] = ans ;

        return dp[i][j] ;
    }
    private static int solveTab(String s1 , String s2 , int[][] dp){// bottom up / tabular

        for (int[] arr : dp)
            Arrays.fill(arr , 0);
        for (int i = s1.length()-1 ; i >= 0 ; i --){
            for (int j = s2.length()-1 ; j >= 0 ; j --){
                int ans = 0 ;
                if (s1.charAt(i) == s2.charAt(j))
                    ans = 1 + dp[i+1][j+1] ;
                else
                    ans = Math.max(dp[i+1][j] , dp[i][j+1]) ;
                dp[i][j] = ans ;
            }
        }

        return dp[0][0] ;
    }
}