import java.util.* ;

public class possible_in_one_swap_or_not
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in) ;
        System.out.println("** Leetcode : 1790 **") ;
        System.out.print("Enter first string : ") ;
        String s1 = scan.nextLine() ;
        System.out.print("Enter second string : ") ;
        String s2 = scan.nextLine() ;
        if(s1.length() != s2.length())
            System.out.println("** Invalid **") ;
        else
        {
            List<Integer> myList = new ArrayList<>() ;
            for(int i = 0 ; i < s1.length() ; i++)
            {
                if(s1.charAt(i) != s2.charAt(i))
                    myList.add(i) ;
            }
            if(myList.size() == 2)
            {
                if((s1.charAt(myList.get(0)) == s2.charAt(myList.get(1))) || (s1.charAt(myList.get(1)) == s2.charAt(myList.get(0))))
                {
                    System.out.println("** Valid **") ;
                }
            }
            else
                System.out.println("** Invalid **") ;
        }
    }
}