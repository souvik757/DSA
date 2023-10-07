package StringsIMP.Questions;
// Find and return the character that occurs most frequently in a given string.

import java.util.Map ;
import java.util.HashMap ;
public class Qus1 {
//    public static int getChar(String s){
//        int[] freq = new int[26] ;
//        for (char c : s.toCharArray())
//            freq[c - 'a']++ ;
//        int max =  -1 ;
//        for (int val : freq){
//            if(val > max) {
//                max = val;
//            }
//        }
//
//        return max ;
//    }
    public static char getChar(String s){
        Map<Character,Integer> freqMap = new HashMap<>() ;

        for (char c : s.toCharArray())
            freqMap.put(c , freqMap.getOrDefault(c,0)+1) ;
        int max = 0 ;
        char ans = '\0' ;

        for (Map.Entry<Character,Integer> entry : freqMap.entrySet()){
            char key = entry.getKey() ;
            int val = entry.getValue() ;
            if(val > max) {
                max = val ;
                ans = key ;
            }
        }

        return ans ;
    }
}
