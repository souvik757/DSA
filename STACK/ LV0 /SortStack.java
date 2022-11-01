/*
Sort a Stack -> Recursive approach.
 */
import java.util.Scanner ;
import java.util.Stack ;
public class SortStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Stack<Integer> myStack = new Stack<>() ;
        int choice , var ;
        do {
            choice = sc.nextInt() ;
            switch (choice)
            {
                case 1->{
                    var = sc.nextInt() ;
                    myStack.push(var) ;
                }
                case 2->sort_stack(myStack) ;
                case 3->System.out.println(myStack) ;
                case -1->System.exit(0) ;
            }
        }while (true) ;
    }
    public static void sort_stack(Stack<Integer> myStack)
    {
        // base case :
        if(myStack.empty())
            return ;
        // store the top element :
        int numAtTop = myStack.peek() ;
        // pop the stack :
        myStack.pop() ;
        // recursive call :
        sort_stack(myStack) ;
        // insert previously popped element in sorted order :
        SortInsert(myStack , numAtTop) ;
    }
    public static void SortInsert(Stack<Integer> myStack , int numAtTop)
    {
        // base case :
        if(myStack.empty() || myStack.peek()<numAtTop) {
            myStack.push(numAtTop) ;
            return ;
        }
        // store the top element :
        int numTop = myStack.peek() ;
        // pop the stack :
        myStack.pop() ;
        // recursive call :
        SortInsert(myStack ,numAtTop) ;
        // insert previously popped element :
        myStack.push(numTop) ;
    }
}
