import java.util.* ;

public class make_network_connected {
    public static void main(String[] args){
        solutionG16 object = new solutionG16() ;
        System.out.println(object.makeConnected(8,new int[][]{
                {0,1} ,
                {0,2} ,
                {1,2} ,
                {3,4} ,
                {5,6} ,
                {5,7} ,
                {6,7}
        }));
        System.out.println(object.makeConnected(8,new int[][]{
                {0,1} ,
                {1,2} ,
                {3,4} ,
                {5,6} ,
                {5,7} ,
                {6,7}
        }));
        System.out.println(object.makeConnected(5,new int[][]{
                {0,1} ,
                {1,2} ,
                {1,3} ,
                {2,3}
        }));
    }
}
class solutionG16{
    private int moves ;      // Number of moves to connect each component
    private int component  ; // Number of components
    private LinkedList<Integer>[] adjList ;
    public solutionG16(){
    }
    private void _make_adj_(int[][] Edges , int N){
        adjList = new LinkedList[N] ;
        for(int i = 0 ; i < N ; i++)
            adjList[i] = new LinkedList<>() ;
        for(int i = 0 ; i < Edges.length ; i++){
            int u = Edges[i][0] ;
            int v = Edges[i][1] ;
            adjList[u].add(v) ;
            adjList[v].add(u) ;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        moves     = -1 ;
        component =  0 ;
        _make_adj_(connections,n) ;
        boolean[] visited = new boolean[n] ;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                component++ ;
                _go_by_dfs_(i,visited) ;
            }
        }
        // Minimum number of edges between components should be (component-1) to be a connected net .
        moves = component - 1 ;

        return (n-1 > connections.length) ? -1 : moves ;
    }

    private void _go_by_dfs_(int i, boolean[] visited) {
        visited[i] = true ;
        for(int neighbor : adjList[i]){
            if(!visited[neighbor])
                _go_by_dfs_(neighbor,visited);
        }
    }
}