import java.util.Scanner;
import java.util.Stack;

public class valid_parenthesis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        int choice = scan.nextInt() ;
        while (choice-->0) {
            String braces = scan.nextLine();
            System.out.println(solve(braces));
        }
    }
    public static boolean solve(String braces)
    {
        char[] brackets = braces.toCharArray() ;
        Stack<Character> myStack = new Stack<>() ;
        for (char ch : brackets) {
            if (ch == '(' || ch == '{' || ch == '[') {
                myStack.push(ch);
            } else {
                if (!myStack.empty()) {
                    if (match(ch, myStack.peek())) {
                        myStack.pop();
                    } else
                        return false;
                } else
                    return false;
            }
        }
        return myStack.empty();
    }
    public static boolean match(char X , char Y)
    {
        return X == ')' && Y == '(' || X == '}' && Y == '{' || X == ']' && Y == '[';
    }
}
