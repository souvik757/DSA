import java.util.* ;
public class _15_3sum {
    public static void main(String[] args) {

    }
}
class solve_15{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>() ;

        for (int i = 0 ; i < nums.length-2 ; i ++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int low = i +1 ;
                int high= nums.length-1;
                int sum = 0-nums[i] ;
                while (low < high){
                    List<Integer> output = new ArrayList<>() ;
                    if(nums[low] + nums[high] == sum){
                        output.add(nums[i]);
                        output.add(nums[low]);
                        output.add(nums[high]);
                        answer.add(new ArrayList<>(output));
                        while (low<high && nums[low] == nums[low+1])
                            low++ ;
                        while (low<high && nums[high] == nums[high-1])
                            high-- ;
                        low++ ;
                        high-- ;
                    }
                    else if(nums[low]+nums[high] < sum)
                        low++ ;
                    else
                        high-- ;
                }
            }
        }

        return answer ;
    }
}