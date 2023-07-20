public class _55_jumpGame {
    public static void main(String[] args) {

    }
}
class solve_55 {
    public boolean canJump(int[] nums) {
        int maxJump = 0 ;
        for (int i = 0 ; i < nums.length ; i ++){
            if(i > maxJump)
                return false ;
            maxJump = Math.max(maxJump , i+nums[i]) ;
        }
        return true ;
    }
}