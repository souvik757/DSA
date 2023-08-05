import java.util.Map ;
import java.util.HashMap ;
import java.util.List ;
import java.util.ArrayList ;
public class _219_ContainsDuplicate_II {
    public static void main(String[] args) {
        solve_219 object = new solve_219() ;
        System.out.println(object.containsNearbyDuplicate(new int[]
                {1,2,3,1,2,3} , 2));
        System.out.println(object.containsNearbyDuplicate(new int[]
                {1,2,3,1} , 3));
    }
}
class solve_219 {
    public boolean containsNearbyDuplicate(int[] numbs, int k) {
        int length = numbs.length ;
        Map<Integer,Integer> hm = new HashMap<>() ;
        for (int i = 0 ; i < length ; i ++){
            if(hm.containsKey(numbs[i]) && Math.abs(hm.get(numbs[i]) - i) <= k)
                return true ;
            hm.put(numbs[i] , i) ;
        }

        return false ;
    }
}