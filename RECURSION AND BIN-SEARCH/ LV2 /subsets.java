import java.util.ArrayList;
import java.util.List;
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
public class subsets {
    public static void main(String[] args) {
        int[] numbs = new int[]{1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;
        result.get_power_set(numbs,ans,output,index);
        System.out.print(ans);
    }
}