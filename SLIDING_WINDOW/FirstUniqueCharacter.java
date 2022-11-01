import java.util.Arrays;
import java.util.HashMap;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character , Integer> character_count = new HashMap<>() ;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i) ;
            if(character_count.containsKey(c))
                character_count.put(c , character_count.get(c) + 1) ;
            else
                character_count.put(c , 1) ;
        }
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i) ;
            if(character_count.get(c) == 1)
                return i ;
        }
        return -1 ;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("letuspracticeonleetcode"));
        System.out.println(firstUniqChar("sekiroisbestthirdperson"));
        System.out.println(firstUniqChar("doometernalisbestrpg"));
        System.out.println(firstUniqChar("mynameissouvikmaity"));
        System.out.println(firstUniqChar("zzzzzzzzzzzzzzzzzzzzzzaaaaaaaaaaaaaacccccccccc"));

    }
}
