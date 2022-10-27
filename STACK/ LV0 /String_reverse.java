import java.util.Scanner;
import java.util.Stack;

public class String_reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        String s1 = scan.nextLine() ;
        Stack<Character> my_stack = new Stack<>() ;
        for (int i = 0 ; i < s1.length() ; i++)
        {
            char c1 = s1.charAt(i) ;
            my_stack.push(c1) ;
        }
        char[] ch = new char[s1.length()] ;
        int index = 0 ;
        while (!my_stack.empty())
        {
            int size = my_stack.size() - 1;
            ch[index] = my_stack.get(size) ;
            index++ ;
            my_stack.pop() ;
        }
        String s2 = new String(ch);
        System.out.println(s2);
    }
}
/*
T.C. : O(2*size of string)
S.C. : O(2*size of string)
 */
