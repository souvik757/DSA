import java.util.*;

public class permutation_of_string
{
    public static void main(String[] args)
    {
        // string :
        _46_String obj2 = new _46_String() ;
        List<String> output_str = new ArrayList<>() ;
        String[] str  = new String[]{"s" , "o" , "u"} ;
        List<List<String>> answer_str = new ArrayList<>() ;
        // using extra space
        obj2.solve(answer_str , output_str , str ) ;
        System.out.println("Permutation "+Arrays.toString(str)+"\n : "+answer_str);
        answer_str.clear() ;
        // without using extra space
        obj2._solve_(answer_str , str , 0) ;
        System.out.println("Permutation of "+Arrays.toString(str)+"\n -> "+answer_str);
    }
}
class _46_String{
    // Using extra space
    public void solve(List<List<String>> answer , List<String > output , String[] str) {
        if(output.size() == str.length)
            answer.add(new ArrayList<>(output)) ;
        else {
            for (String val : str) {
                if (output.contains(val)) continue ;
                output.add(val);
                solve(answer,output,str);
                output.remove(output.size()-1);
            }
        }
    }
    // Without using space
    public void _solve_(List<List<String>> ans , String[] str , int index) {
        if (index == str.length) {
            copy(ans,str);
            return ;
        }
        for (int i = index ; i < str.length ; i ++) {
            String temp1 = str[index] ;
            str[index] = str[i] ;
            str[i] = temp1 ;
            _solve_(ans,str,index+1);
            String temp2 = str[index] ;
            str[index] = str[i] ;
            str[i] = temp2 ;
        }
    }
    private void copy(List<List<String>> ans,String[] str) {
        List<String> list = new ArrayList<>() ;
        for (String val : str)
            list.add(val) ;
        ans.add(new ArrayList<>(list)) ;
    }
}