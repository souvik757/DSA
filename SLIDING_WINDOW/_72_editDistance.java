import java.util.Arrays;

public class _72_editDistance {
    public static void main(String[] args) {
        System.out.println(solve_72.minDistance("horse" , "ros"));
    }
}
class solve_72 {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()] ;
        for (int[] arr : dp)
            Arrays.fill(arr , -1);
        return solve(word1, word2, dp, 0, 0) ;
    }
    private static int solve(String s1, String s2, int[][] dp, int i, int j){
        if(i == s1.length())
            return s2.length() - j ;
        if(j == s2.length())
            return s1.length() - i ;
        if(dp[i][j] != -1)
            return dp[i][j] ;
        int answer = 0 ;
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = solve(s1, s2,dp, i + 1, j + 1);
            return dp[i][j] ;
        }
        else{
            int insertAns = 1 + solve(s1,s2,dp,i,j+1);
            int deleteAns = 1 + solve(s1,s2,dp,i+1,j);
            int replaceAns= 1 + solve(s1,s2,dp,i+1,j+1) ;
            answer = Math.min(insertAns , Math.min(deleteAns , replaceAns)) ;
        }

        dp[i][j] = answer ;

        return dp[i][j] ;
    }
    private static int solveTab(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1] ;
        for (int j = 0 ; j < s2.length() ; j ++)
            dp[s1.length()][j] = s2.length() - j ;
        for (int i = 0 ; i < s1.length() ; i ++)
            dp[i][s2.length()] = s1.length() - i ;
        for (int i = s1.length()-1 ; i >= 0 ; i --){
            for (int j = s2.length()-1 ; j >= 0 ; j --){
                int answer = 0 ;
                if (s1.charAt(i) == s2.charAt(j)) {
                    return dp[i+1][j+1] ;
                }
                else{
                    int insertAns = 1 + dp[i][j+1];
                    int deleteAns = 1 + dp[i+1][j];
                    int replaceAns= 1 + dp[i+1][j+1] ;
                    answer = Math.min(insertAns , Math.min(deleteAns , replaceAns)) ;
                }

                dp[i][j] = answer ;
            }
        }
        return dp[0][0] ;
    }
}