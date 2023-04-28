import java.util.List ;
import java.util.ArrayList ;
public class _417_PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        SOLVEDAY10 object = new SOLVEDAY10() ;
        List<List<Integer>> ANSWER = new ArrayList<>() ;
        ANSWER = object.pacificAtlantic(new int[][]{
                {1,2,2,3,5} ,
                {3,2,3,4,4} ,
                {2,4,5,3,1} ,
                {6,7,1,4,5} ,
                {5,1,1,2,4}
        }) ;
    }
}
