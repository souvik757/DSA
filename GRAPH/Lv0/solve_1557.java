import java.util.*;

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
    private LinkedList<Integer>[] adjList ;
    private void MakeAdj(int Vertex , List<List<Integer>> edges){
        adjList = new LinkedList[Vertex] ;
        for (int i = 0 ; i < Vertex ; i++)
            adjList[i] = new LinkedList<>() ;
        for (List<Integer> val : edges){
            adjList[val.get(0)].add(val.get(1));
        }
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        MakeAdj(n , edges) ;
        int[] Indegre = new int[n] ;
        for (int i = 0 ; i < n ; i ++)
            Indegre[i] = 0 ;
        for(List<Integer> val : edges)
            Indegre[val.get(1)]++ ;
        List<Integer> list = new ArrayList<>() ;
        for (int i = 0 ; i < n ; i ++){
            if(Indegre[i] == 0)
                list.add(i) ;
        }
        return list ;
    }
}

