import java.util.Stack;

public class _227_BasicCalculator_II {
    public static void main(String[] args) {
        solve_227 object = new solve_227() ;
        System.out.println(object.calculate(" 3+5 / 2 "));
        System.out.println(object.calculate("3+2*2"));
        System.out.println(object.calculate(" 3/2 "));
    }
}
class solve_227{
    public int calculate(String s){
        s = s.replaceAll("\\s" , "") ;
        s = s.trim() ;

        int answer = 0 ;
        int currRes = 0 ;
        int index = 0 ;
        char operator = '+' ;

        Stack<Integer> stack = new Stack<>() ;
        for (char ch : s.toCharArray()){
            if(Character.isDigit(ch))
                currRes  = currRes*10 + (ch - '0') ; // '1' - '0' => 1
            if(index == s.length()-1 || !Character.isDigit(ch)){
                if(operator == '+')
                    stack.push(currRes) ;
                else if(operator == '-')
                    stack.push(-currRes) ;
                else if(operator == '*')
                    stack.push(currRes * stack.pop()) ;
                else if(operator == '/')
                    stack.push(stack.pop() / currRes) ;
                operator = ch ;
                currRes = 0 ;
            }
            index ++ ;
        }
        while (!stack.isEmpty())
            answer += stack.pop() ;

        return answer ;
    }
}