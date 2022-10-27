import java.util.*;

public class group_anagrams {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        int n = scan.nextInt() ;
        String[] str = new String[n] ;
        for(int i = 0 ; i<n ; i++)
            str[i] = scan.nextLine() ;
        Map<String , List<String>> output = new HashMap<>() ;
        System.out.println(solve(output ,str));
    }
    public static boolean isAnagram(String s1 , String s2)
    {
        if(s1.length() != s2.length())
            return false ;
        char[] ch1 = s1.toCharArray() ;
        char[] ch2 = s2.toCharArray() ;
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i = 0 ; i < ch1.length ; i++)
        {
            if(ch1[i] != ch2[i])
                return false ;
        }
        return true ;
    }

    public static List<List<String>> solve(Map<String , List<String >> output , String[] str)
    {
        for(int i = 0 ; i < str.length ; i++)
        {
            String my_string = str[i] ;
            char[] my_char = str[i].toCharArray() ;
            Arrays.sort(my_char) ;
            String s1 = new String(my_char) ;
            if(!output.containsKey(s1))
            {
                output.put(s1 , new ArrayList<>()) ;
                output.get(s1).add(my_string) ;
            }
            else
                output.get(s1).add(my_string) ;
        }
        return new ArrayList<>(output.values()) ;
    }



}
