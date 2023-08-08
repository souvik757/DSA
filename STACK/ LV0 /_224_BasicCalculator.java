import java.util.Stack ;
public class _224_BasicCalculator {
    public static void main(String[] args) {
        String s = "123" ;
        System.out.println(Integer.parseInt(s));
        System.out.println();
        System.out.println(solve_224.calculate(" 2-1 + 2 "));
        System.out.println(solve_224.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(solve_224.calculate("1-(     -2)"));
    }
}
class solve_224 {
    public static int calculate(String s) {
        s = s.replaceAll("\\s","");
        s = s.trim() ;
        String infix = "" ;
        if(isNumeric(s))
            return Integer.parseInt(s) ;
        if(s.length() <= 1)
            return Character.getNumericValue(s.charAt(0)) ;
        if (s.charAt(0) == '(' && s.charAt(s.length()-1) == ')'){
            if(s.length() == 3)
                return Character.getNumericValue(s.charAt(1)) ;
            else
                infix = s ;
        }
        else
            infix = "("+s+")" ;
        System.out.println("infix "+infix);
        StringBuilder postfix = new StringBuilder() ;
        Stack<Character> stack = new Stack<>() ;
        for (char ch : infix.toCharArray()){
            if(!_isOperator_(ch))
                postfix.append(ch) ;
            else {
                if(ch == '+' || ch == '-'){
                    if(!stack.isEmpty()){
                        if(stack.peek() == '+' || stack.peek() == '-'){
                            postfix.append(stack.pop()) ;
                            stack.push(ch) ;
                        }
                        else
                            stack.push(ch) ;
                    }
                    else
                        stack.push(ch) ;
                }
                else {
                    if(ch == '(')
                        stack.push(ch) ;
                    else {
                        if (postfix.charAt(postfix.length()-1) == '-' && stack.peek() == '-') {
                            postfix.deleteCharAt(postfix.length()-1) ;
                            postfix.append('+') ;
                            stack.pop() ;
                            stack.pop() ;
                        }
                        else {
                            postfix.append(stack.pop());
                            stack.pop();
                        }
                    }
                }
            }
        }
        if(!stack.isEmpty() && (stack.peek() != '(' || stack.peek() != ')')) {
            postfix.append(stack.pop()) ;
        }
        System.out.println(postfix);



        return evalRPN(new String(postfix)) ;
    }
    private static boolean _isOperator_(char c){
        return c == '+' || c == '-' || c == '(' || c == ')';
    }
    public static int evalRPN(String tokens) {
        Stack<Integer> stack = new Stack<>() ;
        for(char token : tokens.toCharArray()){
            if(!isOperator(token)){
                stack.add(Character.getNumericValue(token)) ;
            }
            else {
                int a = stack.pop() ;
                int b = stack.pop() ;
                int result = 0 ;
                if(token == '+') result = b + a ;
                if(token == '-') result = b - a ;
                stack.push(result) ;
            }
        }

        return stack.peek() ;
    }
    private static boolean isOperator(char token){
        return token == '+' || token == '-' ;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}