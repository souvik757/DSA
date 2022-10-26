import java.util.Arrays;
import java.util.Scanner;

public class Is_there_any_Permutation
{
    static String sort(String str)
    {
        char[] ch = str.toCharArray() ;
        Arrays.sort(ch) ;
        return new String(ch) ;
    }
    static void messege(String s1, String s2 , int pos)
    {
        String temp = s2.substring(pos, pos+s1.length()) ;
        System.out.println(temp+" at "+pos+" index"+" of "+s2+" is a permutation of "+s1+" ! ");
    }
    static boolean check(String s1 , String s2)
    {
        String origin = s1 ;
        s1 = sort(s1) ;
        int pos = -1 ;
        for(int i = 0 ; i <= s2.length()-s1.length() ; i++)
        {
            if(s1.equals(sort(s2.substring(i , i+s1.length()))))
            {
                pos = i ;
                messege(origin,s2,pos) ;
                return true ;
            }
        }
        return false ;
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in) ;
        System.out.print("Enter first string : ");
        String s1 = scan.nextLine() ;
        System.out.print("Enter second string : ");
        String s2 = scan.nextLine() ;
        if(check(s1,s2))
            System.out.println("** Valid **") ;
        else
            System.out.println("** Invalid **") ;
    }
}
