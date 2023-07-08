public class _209_MinimumSizeSubArray {
    public static void main(String[] args) {
        SOLVE_209 object = new SOLVE_209() ;
        System.out.println(object.minSubArrayLen(7  , new int[]{2,3,1,2,4,3}));
        System.out.println(object.minSubArrayLen(4  , new int[]{1,4,4}));
        System.out.println(object.minSubArrayLen(213  , new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
        System.out.println(object.minSubArrayLen(15  , new int[]{1,2,3,4,5}));
        System.out.println(object.minSubArrayLen(11 , new int[]{1,1,1,1,7,4}));
    }
}
// target = 7, nums = [2,3,1,2,4,3]      -> 2
// target = 4, nums = [1,4,4]            -> 1
// target = 11, nums = [1,1,1,1,1,1,1,1] -> 0
// 1 2 2 3 3 4
class SOLVE_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE ;
        int sum = 0 ;
        int s = 0 ;
        int e = 0 ;
        for (int i = e ; i < nums.length ; i ++){
            sum += nums[i] ;
            while(sum >= target){
                minLength = Math.min(minLength , i - s + 1) ;
                sum -= nums[s] ;
                s ++ ;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength ;
    }
}
// 0  1  2   3   4   5   6   7   8   9   10  11
// 2, 4, 12, 12, 25, 25, 25, 25, 25, 26, 28, 83