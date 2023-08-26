import java.util.* ;
public class _39_CombinationSum {
    public static void main(String[] args) {
        solve_39 object = new solve_39() ;
        List<List<Integer>> answer = object.combinationSum(new int[]{
                2,3,5,6
        } , 7) ;
        System.out.print(answer);
    }
}
class solve_39 {
    private List<List<Integer>> answer = new ArrayList<>() ;
    private void solve(int[] candidates,int target,int index , int currSum,List<Integer> output){
        // base case
        if(currSum > target)
            return ;
        if(index == candidates.length){
            if(currSum == target)
                answer.add(new ArrayList<>(output)) ;
            return ;
        }
        // inclusion
        currSum += candidates[index] ;
        output.add(candidates[index]) ;
        solve(candidates,target,index,currSum,output);
        currSum -= candidates[index] ;
        output.remove(output.size()-1) ;

        // exclusion
        solve(candidates,target,index+1,currSum,output);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> output = new ArrayList<>() ;
        solve(candidates , target , 0 , 0 , output) ;
        return answer ;
    }
}