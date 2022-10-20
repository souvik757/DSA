import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class keypad {
    static void solve(String digits, List<String> ans , String output , String[] map , int index)
    {
        //base case :
        if(index >= digits.length())
        {
            ans.add(output);
            return;
        }
        int i = digits.charAt(index) - '0';
        String value = map[i];
        for(int j = 0 ; j < value.length() ; j++)
        {
            output = String.valueOf(value.charAt(j));
            solve(digits,ans,output,map,index+1);
            output = String.valueOf("");
        }
    }
    public static List<String> keypad_input(String digits){
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
            return ans;
        int index = 0 ;
        String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String output = "";
        solve(digits,ans,output,mapping,index);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.next();
        System.out.println(keypad_input(digits));
    }
}
