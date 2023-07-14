import java.util.*;

public class commonIn3SortedArr {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>() ;
        ArrayList<Integer> b = new ArrayList<>() ;
        ArrayList<Integer> c = new ArrayList<>() ;
        a.add(1) ;
        a.add(4) ;
        a.add(5) ;
        a.add(6) ;
        b.add(3) ;
        b.add(4) ;
        b.add(5) ;
        c.add(5) ;
        c.add(6) ;
        c.add(7) ;
        System.out.println(_Solution_.findCommonElements(a,b,c));
    }
}
class _Solution_ {
    public static ArrayList<Integer> findCommonElements(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c)
    {
        // Write your code here.
        Set<Integer> set = new HashSet<>() ;
        a.retainAll(b) ; // removes elements from list a that are not contained in list b
        a.retainAll(c) ;
        set.addAll(a) ;
        a.clear();
        a.addAll(set) ;
        return a ;
    }
}