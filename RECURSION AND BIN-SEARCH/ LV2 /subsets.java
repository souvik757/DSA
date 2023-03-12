import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class subsets {
    public static void main(String[] args) {
        int[] numbs = new int[]{1,2,4,5,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        result.get_power_set(numbs,ans,output,index);
        System.out.println(ans);
        System.out.println(solve.sumOddLengthSubSets(numbs)) ;
    }
    class result{
        static void get_power_set(int[] numbs , List<List<Integer>> ans, List<Integer> output , int index)
        {
            //base case :
            if(index >= numbs.length)
            {
                ans.add(new ArrayList<>(output));
                return ;
            }
            //exclude :
            get_power_set(numbs,ans,output,index+1);
            //include :
            output.add(numbs[index]);
            get_power_set(numbs,ans,output,index+1);
            output.remove(output.size()-1);
        }
    }
    class solve{
        public static int sumOddLengthSubSets(int[] arr) {
            int sum = 0 ;
            int index = 0 ;
            List<Integer> _list = new ArrayList<>() ;
            List<List<Integer>> output = new ArrayList<>() ;
            result.get_power_set(arr , output , _list , index) ;
            for(int i = 0 ; i < output.size() ; i++){
                if(output.get(i).size()%2 != 0) {
                    System.out.println(output.get(i));
                    sum += GetSum(output.get(i));
                }
            }
            return sum ;
        }
        public static int GetSum(List<Integer> _list_){
            int sum = 0 ;
            for(int i = 0 ; i < _list_.size() ; i++){
                sum += _list_.get(i) ;
            }
            return sum ;
        }
    }
}
