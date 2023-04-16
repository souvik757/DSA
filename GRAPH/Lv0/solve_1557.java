import java.util.*;

// Yet to be solved !!
// VVI Khan's Algorithm .


public class solve_1557 {
    public static void main(String[] args) {
        solutionG29 object = new solutionG29() ;
        List<List<Integer>> Edges = new ArrayList<>() ;
        System.out.println("How many edges are there ? ") ;
        int Number_Of_Edges = new Scanner(System.in).nextInt() ;
        while (Number_Of_Edges-->0){
            List<Integer> _list_ = new ArrayList<>() ;
            int V1 = new Scanner(System.in).nextInt() ;
            _list_.add(V1) ;
            int V2 = new Scanner(System.in).nextInt() ;
            _list_.add(V2) ;
            Edges.add(new ArrayList<>(_list_)) ;
        }
        System.out.println(object.findSmallestSetOfVertices(6 , Edges)) ;
    }
}
class solutionG29{
    private List<List<Integer>> ANSWER ;
    private List<Integer> LIST ;
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ANSWER = new ArrayList<>() ;
        LIST = new ArrayList<>() ;

        return LIST ;
    }
}

