import java.util.ArrayList;
import java.util.List;

public class permutation_of_string {
    static void swap(int x , int y)
    {
        int temp = x ;
        x = y ;
        y = temp;
    }
    static void solve(List<List<Integer>> ans , List<Integer> output , int[] numbs)
    {
        //Base case :
        if(output.size() == numbs.length)
        {
            ans.add(new ArrayList<>(output));
            return ;
        }
        for(int i = 0 ; i<numbs.length ; i++)
        {
            if(output.contains(numbs[i]))
                continue;
            output.add(numbs[i]);
            solve(ans , output , numbs);
            output.remove(output.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] numbs = new  int[]{1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(ans , output ,numbs);
        System.out.println(ans);
    }
}
