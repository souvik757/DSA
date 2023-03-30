import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramInString {
    public static void main(String[] args) {
        solve result = new solve() ;
        System.out.println(result.findAnagrams("cbaebabacd" , "abc"));
    }
}
class solve{
    public List<Integer> _findAnagrams_(String s , String p){
        List<Integer> ans = new ArrayList<>() ;
        int sLen = s.length() ;
        int pLen = p.length() ;
        if(sLen < pLen) return ans ;
        int[] sArr = new int[26] ;
        int[] pArr = new int[26] ;
        for(int i = 0 ; i < pLen ; i++){
            sArr[s.charAt(i) - 'a']++ ;
            pArr[p.charAt(i) - 'a']++ ;
        }
        if(_isAnagram_(sArr , pArr))
            ans.add(0) ;
        for(int i = pLen ; i < sLen ; i++){
            sArr[s.charAt(i) - 'a']++ ;
            sArr[s.charAt(i - pLen) - 'a']-- ;
            if(_isAnagram_(sArr , pArr))
                ans.add(i - pLen + 1) ;
        }
        return ans ;
    }
    private boolean _isAnagram_(int[] sArr , int[] pArr){
        return Arrays.equals(sArr , pArr) ;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>() ;
        for(int i = 0 ; i <= s.length()-p.length() ; i++){
            int startIndex = i ;
            String s1 = s.substring(startIndex , startIndex+p.length()) ;
            if(check_anagram(s1 , p))
                ans.add(startIndex) ;
        }
        return ans ;
    }

    private boolean check_anagram(String s1, String p) {
        s1 = s1.toLowerCase() ;
        p = p.toLowerCase() ;
        char[] s1ch = s1.toCharArray() ;
        char[] pch = p.toCharArray() ;
        Arrays.sort(s1ch);
        Arrays.sort(pch);
        for(int i = 0 ; i < s1ch.length ; i++){
            if(s1ch[i] != pch[i])
                return false ;
        }
        return true ;
    }
}
