public class _1004_MaxConsecutive_Ones {
    public static void main(String[] args) {
        System.out.println(SOLVE_1004.findMaxConsecutiveOnes(new int[]{1,1,1,1,0,1,1,1})) ;
        System.out.println(SOLVE_1004.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1})) ;
        System.out.println(SOLVE_1004.findMaxConsecutiveOnes(new int[]{1,1})) ;
        System.out.println(SOLVE_1004.findMaxConsecutiveOnes(new int[]{0,1})) ;
        System.out.println(SOLVE_1004.findMaxConsecutiveOnes(new int[]{1,0})) ;
        System.out.println(SOLVE_1004.findMaxConsecutiveOnes(new int[]{0,0})) ;
        System.out.println(SOLVE_1004.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0},2)) ;
        System.out.println(SOLVE_1004.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3)) ;
    }
}
class SOLVE_1004{
    public static int findMaxConsecutiveOnes(int[] nums) { // Max Consecutive Ones I
        int MaxLength = Integer.MIN_VALUE;
        int i = 0;
        int cons_ones = 0 ;
        while (i < nums.length) {
            if(nums[i] == 1)
                cons_ones++ ;
            else{
                cons_ones = 0 ;
            }
            i ++ ;
            MaxLength = Math.max(MaxLength , cons_ones) ;
        }
        return MaxLength;
    }

    public static int longestOnes(int[] nums, int k) { // Max Consecutive Ones III

        return -1 ;
    }
}