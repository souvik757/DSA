import java.util.LinkedList;

public class IsPathExists {
    public static void main(String[] args) {
        SOLVEJUSPAYOA0 object = new SOLVEJUSPAYOA0() ;
        int Vertex = 11 ;
        int[][] edges = new int[][]{
                {1,2} ,
                {2,3} ,
                {3,4} ,
                {3,5} ,
                {3,7} ,
                {5,6} ,
                {6,7} ,
                {8,9} ,
                {9,10} ,
        } ;
        System.out.println(object.IsValidPath(1,5,Vertex ,edges));
        System.out.println(object.IsValidPath(1,9,Vertex ,edges));
    }
}
class SOLVEJUSPAYOA0{
    private boolean ValidPathFound ;
    private LinkedList<Integer>[] adjList ;
    private void MakeAdjList(int Vertex , int[][] edges){
        adjList = new LinkedList[Vertex] ;
        for (int i = 0 ; i < Vertex ; i ++)
            adjList[i] = new LinkedList<>() ;
        for (int[] val : edges){
            adjList[val[0]].add(val[1]) ;
            adjList[val[1]].add(val[0]) ;
        }
    }
    public boolean IsValidPath(int src , int destination , int Vertex , int[][] edges){
        MakeAdjList(Vertex , edges) ;
        boolean[] visited = new boolean[Vertex] ;
        int parent = -1 ;
        ValidPathFound = false ;
        InformByDFS(src , destination , parent , visited) ;
        return ValidPathFound ;
    }

    private void InformByDFS(int src, int destination, int parent, boolean[] visited) {
        visited[src] = true ;

        for (int neighbour : adjList[src]){
            if(neighbour == destination)
                ValidPathFound = true ;
            if(visited[neighbour] || neighbour == parent)
                continue ;
            if(!visited[neighbour])
                InformByDFS(neighbour , destination , src , visited) ;
        }
    }
}
