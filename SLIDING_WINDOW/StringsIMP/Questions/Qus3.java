package StringsIMP.Questions;

import java.util.Map ;
import java.util.HashMap ;


// Print all characters in a string that appear more than once.
public class Qus3 {
    public static void duplicateChars(String s){
        Map<Character,Integer> freqMap = new HashMap<>() ;
        for (char c : s.toCharArray()){
            freqMap.put(c , freqMap.getOrDefault(c,0)+1) ;
        }
        for (Map.Entry<Character,Integer> entry : freqMap.entrySet()){
            int val = entry.getValue() ;
            if(val > 1)
                System.out.print(entry.getKey()) ;
        }
    }
}