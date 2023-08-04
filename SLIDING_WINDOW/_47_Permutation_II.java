import java.util.* ;
public class _47_Permutation_II {
    public static void main(String[] args) {
        solve_47 object = new solve_47() ;
        List<List<Integer>> answer = object.permuteUnique(new int[]{1,1,2}) ;
        for (List<Integer> val : answer)
            System.out.println(val);
    }
}
class solve_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>() ;
        List<Integer> output = new ArrayList<>() ;
        List<Integer> numsList = new ArrayList<>() ;
        for (int val : nums)
            numsList.add(val);
        getPermutation(permutations,output,numsList) ;

        return permutations ;
    }

    private void getPermutation(List<List<Integer>> permutations, List<Integer> output, List<Integer> numsList) {
        if(numsList.size() == 0){
            if(permutations.contains(output))
                return ;
            permutations.add(new ArrayList<>(output));
            return ;
        }
        for (int i = 0 ; i < numsList.size() ; i ++){
            List<Integer> copyList = new ArrayList<>(numsList) ;
            copyList.remove(i) ;
            output.add(numsList.get(i));
            getPermutation(permutations,output,copyList);
            output.remove(output.size()-1) ;
        }
    }
}