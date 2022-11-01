import java.util.Stack ;
import java.util.Scanner ;

public class MinimumCostToMakeValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String str = sc.nextLine() ;
        System.out.println(MinCost(str)) ;
        if(MinCost(str) == -1)
            System.out.println("nothing can be done");
    }
    public static int MinCost(String str)
    {
        // if length of string is odd then return -1 :
        if(str.length()%2 != 0)
            return -1 ;
        Stack<Character> MyStack = new Stack<>() ;
        for(int i = 0 ; i < str.length() ; i++)
        {
            char ch = str.charAt(i) ;
            if(ch == '{')
                MyStack.push(ch) ;
            else
            {
                if(!MyStack.empty() && MyStack.peek() == '{')
                    MyStack.pop() ;
                else
                    MyStack.push(ch) ;
            }
        }
        int OpenBracketCount = 0 ;
        int ClosingBracketCount = 0 ;
        while (!MyStack.empty())
        {
            if(MyStack.peek() == '{')
                OpenBracketCount++ ;
            else
                ClosingBracketCount++ ;
            MyStack.pop() ;
        }
        return (OpenBracketCount+1)/2 + (ClosingBracketCount+1)/2;
    }
}
