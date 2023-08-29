package Problems;

import java.util.Set ;
import java.util.HashSet ;
public class _3_LongestSubStrWithOutRepeatingChars {
    public int lengthOfLongestSubstring(String s){
        int maxLength = 0 ;
        int index = 0 ;
        int fwdIndex = 0 ;
        int length = s.length() ;
        Set<Character> set = new HashSet<>() ;
        while (fwdIndex < length){
            if(!set.contains(s.charAt(fwdIndex))){
                set.add(s.charAt(fwdIndex)) ;
                fwdIndex ++ ;
                maxLength = Math.max(maxLength , set.size()) ;
            }
            else {
                set.remove(s.charAt(index)) ;
                index ++ ;
            }
        }
        return maxLength ;
    }
}
