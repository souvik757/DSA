import java.util.Stack ;
public class _150_EvaluateRevNotation {
    public static void main(String[] args) {
        System.out.println(solve_150.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(solve_150.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(solve_150.evalRPN(new String[]
                {"10","6","9","3","+","-11","*","/","*","17","+","5","+"})
        );
    }
}
class solve_150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>() ;
        for(String str : tokens){
            if(!isOperator(str)){
                stack.add(Integer.parseInt(str)) ;
            }
            else {
                int a = stack.pop() ;
                int b = stack.pop() ;
                int result = 0 ;
                if(str.equals("+")) result = b + a ;
                if(str.equals("*")) result = b * a ;
                if(str.equals("-")) result = b - a ;
                if(str.equals("/")) result = b / a ;
                stack.push(result) ;
            }
        }

        return stack.peek() ;
    }
    private static boolean isOperator(String token){
        return
                token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")  ;
    }
}