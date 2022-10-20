import java.util.ArrayList;
import java.util.List;


public class string_sequences {
    static void power_set(String[] numbs , List<List<String>> ans, List<String> output , int index)
    {
        //base case :
        if(index >= numbs.length)
        {
            ans.add(new ArrayList<>(output));
            return ;
        }
        //exclude :
        power_set(numbs,ans,output,index+1);
        //include :
        output.add(numbs[index]);
        power_set(numbs,ans,output,index+1);
        output.remove(output.size()-1);
    }

    public static void main(String[] args) {
        String[] a = new String[]{"s","o","u"};
        List<List<String >> ans = new ArrayList<>();
        List<String> output = new ArrayList<>();
        int index = 0 ;
        power_set(a,ans,output,index);
        System.out.println(ans);
    }
}
