import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class cycle_detection_directed {
    public static void main(String[] args) {
        solution00 object = new solution00() ;
        System.out.println(object._is_cycle_(23 , new int[]{4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21})) ;
        System.out.println(object._is_cycle_( 4 , new int[]{1,2,0,-1})) ;
        System.out.println(object._is_cycle_( 5 , new int[]{1,2,3,4,-1,3})) ;
        System.out.println(object._is_cycle_( 3 , new int[]{-1,0,1})) ;
        System.out.println(object._is_cycle_( 4 , new int[]{-1,2,3,1})) ;
    }
}
class solution00{
    private LinkedList<Integer>[] adjList ;
    public String _is_cycle_(int N , int[] Edges){
        _make_adj_list_(Edges);
        Map<Integer , Boolean> visited = new HashMap<>() ;
        Map<Integer , Boolean> adjvisited = new HashMap<>() ;
        for(int i = 0 ; i < N ; i++){
            visited.put(i,false) ;
            adjvisited.put(i,false) ;
        }
        for(int i = 0 ; i < N ; i++){
            if(!visited.get(i)){
                boolean cycle = _is_cyclic_(i,visited,adjvisited) ;
                if(cycle){
                    return "Cycle is there" ;
                }
            }
        }
        return "No Cycle is encountered !" ;
    }

    private boolean _is_cyclic_(int i, Map<Integer, Boolean> visited, Map<Integer, Boolean> adjvisited) {
        visited.put(i,true) ;
        adjvisited.put(i,true) ;
        for(int neighbour : adjList[i]){
            if(neighbour == -1) continue ;
            if(!visited.get(neighbour)){
                boolean cycle = _is_cyclic_(neighbour,visited,adjvisited) ;
                if(cycle)
                    return true ;
            }
            else if(adjvisited.get(neighbour)){ // && visited.get(neighbour) == true
                return true ;
            }
        }
        adjvisited.put(i,false) ;
        return false ;
    }

    private void _make_adj_list_(int[] Edges){
        adjList = new LinkedList[Edges.length] ;
        for(int i = 0 ; i < Edges.length ; i++){
            adjList[i] = new LinkedList<>() ;
            adjList[i].add(Edges[i]) ;
        }
    }
}