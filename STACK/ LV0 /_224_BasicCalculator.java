import java.util.Stack ;
public class _224_BasicCalculator {
    public static void main(String[] args) {
        System.out.println(solve_224.calculate(" 2-1 + 2 "));
        System.out.println(solve_224.calculate("2-(-124545666)"));
        System.out.println(solve_224.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(solve_224.calculate("1-(     -2)"));
    }
}
class solve_224 {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>() ;
        s = s.replaceAll("\\s","");
        s = s.trim() ;
        int result = 0 ;
        int sign = 1 ;
        for (int i = 0 ; i < s.length() ; i ++){
            char ch = s.charAt(i) ;
            if(Character.isDigit(ch)){
                int cumulativeSum = 0 ;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    cumulativeSum  = cumulativeSum*10 + (s.charAt(i) - '0') ;
                    i ++ ;
                }
                i -- ;
                cumulativeSum *= sign ;
                sign = 1 ;
                result += cumulativeSum ;
            }
            else if(ch == '+')
                sign = 1 ;
            else if(ch == '-')
                sign = -1 ;
            else if(ch == '('){
                stack.push(result) ;
                stack.push(sign) ;
                result = 0 ;
                sign = 1 ;
            }
            else {
                result *= stack.pop() ;
                result += stack.pop() ;
            }
        }


        return result ;
    }
}