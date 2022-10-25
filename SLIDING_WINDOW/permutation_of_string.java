import java.util.*;

public class permutation_of_string
{

    // FOR INTEGER :
    static void solve(List<List<Integer>> answer , List<Integer> output , int[] number)
    {
        // BASE CASE :
        if(output.size() == number.length)
        {
            answer.add(new ArrayList<>(output)) ;
        }
        else
        {
            for (int i : number) {
                if (output.contains(i))
                    continue;
                output.add(i);
                solve(answer, output, number);
                output.remove(output.size() - 1);
            }
        }
    }

    // FOR STRING :
    static void solve(List<List<String>> answer , List<String > output , String[] number)
    {
        // BASE CASE :
        if(output.size() == number.length)
        {
            answer.add(new ArrayList<>(output)) ;
        }
        else
        {
            for (String i : number) {
                if (output.contains(i))
                    continue;
                output.add(i);
                solve(answer, output, number);
                output.remove(output.size() - 1);
            }
        }
    }
    public static void main(String[] args)
    {
        // INTEGER :
        List<List<Integer>> answer = new ArrayList<>() ;
        List<Integer> output = new ArrayList<>() ;
        int[] numbers  = new int[]{1,2,3} ;
        solve(answer , output , numbers ) ;
        System.out.println("Permutation of "+ Arrays.toString(numbers)+" : "+answer);

        // STRING :
        List<List<String>> answer_str = new ArrayList<>() ;
        List<String> output_str = new ArrayList<>() ;
        String[] str  = new String[]{"s" , "o" , "u"} ;
        solve(answer_str , output_str , str ) ;
        System.out.println("Permutation of "+ Arrays.toString(str)+" : "+answer_str);

    }
}
