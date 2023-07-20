import java.util.Arrays;

public class _45_jumpGame_II {
    public static void main(String[] args) {

    }
}
class solve_45{
    public int jump(int[] nums) {
        int N = nums.length ;
        int[] dp = new int[N] ;
        Arrays.fill(dp , Integer.MAX_VALUE) ;
        dp[N-1] = 0 ;
        for (int i = N-2 ; i >= 0 ; i --){
            int min = Integer.MAX_VALUE ;
            for (int j = i + 1 ; j <= Math.min(N-1 , i+nums[i]) ; j ++)
                min = Math.min(min , dp[j]) ;
            if(min != Integer.MAX_VALUE)
                dp[i] = min + 1 ;
        }
        return dp[0] ;
    }
}