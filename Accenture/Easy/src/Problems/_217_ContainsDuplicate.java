package Problems;

import java.util.Set ;
import java.util.HashSet ;

public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] num) {
        Set<Integer> number = new HashSet<>() ;
        for (int val : num){
            if(!number.add(val))
                return true ;
        }
        return false ;
    }
}
