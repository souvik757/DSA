import java.util.* ;

public class find_safe_states {
    public static void main(String[] args) {
        solutionG18 object = new solutionG18() ;
        List<Integer> _list_ = object.eventualSafeNodes(new int[][]{
                {1,2} ,
                {2,3} ,
                {5}   ,
                {0}   ,
                {5}   ,
                {}    ,
                {}
        }) ;

        System.out.println("Terminals nodes & nodes immediately associated with terminals \n=>"+_list_.toString()) ;
    }
}
class solutionG18{
    public List<Integer> eventualSafeNodes(int[][] graph) {
        System.out.println("Adjacency List's =>");
        for(int i = 0 ; i < graph.length ; i++)
            System.out.println(i+" -> "+Arrays.toString(graph[i])) ;
        int size = graph.length ;
        boolean[] Visited      = new boolean[size] ;
        boolean[] PathExplored = new boolean[size] ;
        boolean[] Terminals    = new boolean[size] ;

        for(int i = 0 ; i < size ; i++){
            if(!Visited[i])
                _track_neighbours_by_dfs_(i,Visited,PathExplored,Terminals,graph) ;
        }

        List<Integer> _answer_ = new ArrayList<>() ;
        for(int i = 0 ; i < size ; i++){
            if(Terminals[i])
                _answer_.add(i) ;
        }

        return _answer_ ;
    }

    private boolean _track_neighbours_by_dfs_(int i, boolean[] visited, boolean[] pathExplored, boolean[] terminals, int[][] graph) {
        visited[i] = true ;
        pathExplored[i] = true ;
        terminals[i] = false ;
        for(int neighbours : graph[i]){
            if(!visited[neighbours]){
                boolean check = _track_neighbours_by_dfs_(neighbours,visited,pathExplored,terminals,graph) ;
                if(check) return true ;
            }
            else if(pathExplored[neighbours]) { // it is already visited
                return true ;
            }
        }
        // if a particular node don't have any neighbors, or marked as false .
        pathExplored[i] = false ;
        terminals[i] = true ;

        return false ;
    }
}
