import java.util.* ;
public class _216_CombinationSum_III {
    public static void main(String[] args) {
        SOLVE_216 object = new SOLVE_216() ;
        System.out.println(object.combinationSum3(3 , 9));
    }
}
class SOLVE_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int index = 0 ;
        List<Integer> output = new ArrayList<>() ;
        List<List<Integer>> answer = new ArrayList<>() ;
        int[] num = new int[9] ;
        for (int i = 0 ; i < 9 ; i ++)
            num[i] = i + 1 ;
        solve(answer , output , num ,k , n , index);

        return answer ;
    }
    private void solve(List<List<Integer>> ans, List<Integer> output ,  int[] nums, int k, int target, int index) {
        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if(k < 0 || target < 0)
            return ;

        for (int i = index; i < nums.length; i++) {
            output.add(nums[i]) ;
            solve(ans,output , nums, k - 1, target - nums[i], i + 1);
            output.remove(output.size() - 1) ;
        }
    }
}