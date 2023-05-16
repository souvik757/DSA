import java.util.*;

public class ShortestPathInDirectedGraph {
    public static void main(String[] args) {
        ShortestDirected object = new ShortestDirected() ;
        System.out.println(object.shortestPath(8 , 0 , 7 ,
                new int[][]{
                        {0 , 1} ,
                        {0 , 2} ,
                        {0 , 3} ,
                        {1 , 4} ,
                        {2 , 7} ,
                        {3 , 5} ,
                        {5 , 6} ,
                        {4 , 7} ,
                        {6 , 7}
                }));
    }
}
class ShortestDirected{
    private LinkedList<Integer>[] AdjList ;
    private void MakeAdjList(int Vertex , int[][] edges){
        AdjList = new LinkedList[Vertex] ;
        for (int i = 0 ; i < Vertex ; i ++)
            AdjList[i] = new LinkedList<>() ;
        for (int[] val : edges){
            AdjList[val[0]].add(val[1]) ;
            AdjList[val[1]].add(val[0]) ;
        }
    }
    public List<Integer> shortestPath(int Vertex, int src, int destination, int[][] edges) {
        List<Integer> list = new ArrayList<>() ;
        MakeAdjList(Vertex, edges) ;
        boolean[] visited = new boolean[Vertex] ;
        int[] parent = new int[Vertex] ;
        Arrays.fill(parent , -1) ;
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(0) ;
        visited[0] = true ;
        parent[0] = -1 ;
        while( !queue.isEmpty()){
            int front = queue.remove() ;
            for (int neighbour : AdjList[front]){
                if(visited[neighbour]// || neighbour == front -- neighbors are already being visited as progresses .
                )
                    continue ;
                visited[neighbour] = true ;
                parent[neighbour] = front ;
                queue.add(neighbour) ;
            }
        }
        int ancester = destination ;
        list.add(ancester) ;
        while (ancester != src){
            ancester = parent[ancester] ;
            list.add(ancester) ;
        }
        return list ;
    }
}
