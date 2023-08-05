import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _290_WordPattern {
    public static void main(String[] args) {
        solve_290 object = new solve_290() ;
        System.out.println(object.wordPattern("abba" , "dog cat cat dog")) ;
        System.out.println(object.wordPattern("abba" , "dog cat cat fish")) ;
        System.out.println(object.wordPattern("aaaa" , "dog cat cat dog")) ;
    }
}
class solve_290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> chToStr = new HashMap<>() ;
        Map<String, Character> strToCh = new HashMap<>() ;
        String[] str = s.split(" ") ;
        int length = pattern.length() ;
        if(str.length != length)
            return false ;
        for (int i = 0 ; i < length ; i ++){
            char ch = pattern.charAt(i) ;
            if(chToStr.containsKey(ch)){
                if(!chToStr.get(ch).equals(str[i]))
                    return false ;
            }
            chToStr.put(ch,str[i]) ;
            if(strToCh.containsKey(str[i])){
                if(strToCh.get(str[i]) != ch)
                    return false ;
            }
            strToCh.put(str[i] , ch) ;
        }

        return true ;
    }
}