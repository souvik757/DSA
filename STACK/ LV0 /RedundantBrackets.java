import java.util.Stack ;
import java.util.Scanner ;
public class RedundantBrackets {
    static Scanner sc = new Scanner( System.in ) ;
    public static void main(String[] args) {
        String equation = sc.nextLine() ;
        if(isRedundant(equation))
            System.out.println("true");
        else
            System.out.println("false") ;
    }
    public static boolean isRedundant(String equation)
    {
        Stack<Character> myStack = new Stack<>() ;
        for(int i = 0 ; i  < equation.length() ; i++)
        {
            char ch = equation.charAt(i) ;
            System.out.println(ch);
            // if opening bracket or any operator found, push it into stack :
            if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/')
                myStack.push(ch) ;
            else
            {
                if(ch == ')') {
                    boolean is_Redundant = true;
                    while (myStack.peek() != '(') {
                        char top = myStack.peek();
                        if (top == '+' || top == '-' || top == '*' || top == '/')
                            is_Redundant = false;
                        myStack.pop();
                    }
                    if(is_Redundant)
                        return true ;
                }
            }
        }
        return false ;
    }
}
