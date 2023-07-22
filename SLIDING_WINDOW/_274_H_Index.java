import java.util.Arrays;

public class _274_H_Index {
    private static final solve_274 object = new solve_274() ;
    public static void main(String[] args) {
        int[] demo ;
        demo = new int[]{3,0,6,1,5} ;
        System.out.println(object.hIndex(demo)) ;
        demo = new int[]{1,3,1} ;
        System.out.println(object.hIndex(demo)) ;
    }
}
class solve_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations) ;
        int index = 0 ;
        int N = citations.length ;
        while (index < N && citations[index] < N-index)
            index ++ ;

        return N-index ;
    }
}