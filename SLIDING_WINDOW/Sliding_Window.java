import java.util.*;

// Longest unique substring of a string :
public class Sliding_Window {
    static int solve(String str)
    {
        Set<Character> my_str = new HashSet<>() ;
        int lower_end = 0 ;
        int higher_end = 0 ;
        int max_length = 0 ;
        while (higher_end < str.length())
        {
            if(!my_str.contains(str.charAt(higher_end)))
            {
                my_str.add(str.charAt(higher_end)) ;
                higher_end++ ;
                max_length = Math.max(my_str.size(), max_length) ;
            }
            else
            {
                my_str.remove(str.charAt(lower_end)) ;
                lower_end++ ;
            }
        }
        return max_length ;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        String str = scan.nextLine() ;
        System.out.println("Length of longest unique substring of "+str+" : "+solve(str));
    }
}