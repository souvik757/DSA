/*
Insert an element at the bottom of the stack :
 */
// Recursive Approach :
import java.util.Scanner ;
import java.util.Stack ;
public class insertAtLast {
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
                case 2 -> {
                    var = sc.nextInt() ;
                    InsertAt_Last(myStack , var) ;
                }
                case 3 -> System.out.println(myStack) ;
                case -1 -> System.exit(0) ;
            }
        }while (true) ;
    }
    public static void InsertAt_Last(Stack<Integer> myStack , int var)
    {
        // base case :
        if(myStack.empty()){
            myStack.push(var) ;
            return ;
        }
        // store the top element :
        int numAtTop = myStack.peek() ;
        // pop the stack :
        myStack.pop() ;
        // recursive call :
        InsertAt_Last(myStack , var) ;
        // add up popped elements :
        myStack.push(numAtTop) ;
    }
}
