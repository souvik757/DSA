import java.util.Stack;

public class basic {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>() ;
        // push operation :
        myStack.push(12) ;
        myStack.push(13) ;
        myStack.push(14) ;
        myStack.push(15) ;

        // pop operation :
        myStack.pop() ;

        System.out.println(myStack);
        // peek operation :
        System.out.println(myStack.peek()) ;

        System.out.println(myStack);
    }
}
