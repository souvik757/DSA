/*
Reverse a Stack using recursion :
 */
import java.util.Stack ;
import java.util.Scanner ;
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>() ;
        Scanner sc = new Scanner(System.in) ;
        int choice , var ;
        do {
            choice = sc.nextInt() ;
            switch (choice)
            {
                case 1 -> {
                    var = sc.nextInt() ;
                    myStack.push(var) ;
                }
                case 2 -> Reverse_Stack(myStack) ;
                case 3 -> System.out.println(myStack) ;
                case -1 -> System.exit(0) ;
            }
        }while (true) ;
    }
    public static void Reverse_Stack(Stack<Integer> myStack)
    {
        // base case :
        if(myStack.empty())
            return ;
        // store the top element :
        int numAtTop = myStack.peek() ;
        // pop the stack :
        myStack.pop() ;
        // recursive call :
        Reverse_Stack(myStack) ;
        // Insert previously popped element at bottom of stack :
        insertAtLast.InsertAt_Last(myStack , numAtTop) ;
    }
}

