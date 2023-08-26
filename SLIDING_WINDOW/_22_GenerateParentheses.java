import java.util.* ;
public class _22_GenerateParentheses {
    public static void main(String[] args) {
        solve_22 object = new solve_22() ;
        System.out.println(object.generateParenthesis(3));
    }
}
class solve_22{
    public List<String> generateParenthesis(int n) {
        List<String> combination = new ArrayList<>() ;
        solve(combination,"" , 0 , 0 , n) ;
        return combination ;
    }
    private void solve(List<String> outputs , String currStr , int open , int close , int max){
        if(currStr.length() == (max * 2)){
            outputs.add(currStr) ;
            return ;
        }
        if(open < max){
            solve(outputs,currStr+"(",open+1,close,max) ;
        }

        if(close < open) {
            solve(outputs,currStr+")",open,close+1,max) ;
        }
    }
}