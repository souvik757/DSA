// Yet to be solved !
import java.util.Queue ;
import java.util.LinkedList ;
public class BipartiteGraph {
    public static void main(String[] args) {
        solutionG33 object = new solutionG33() ;
        System.out.println(object.isBipartite(new int[][]{
                {1,2,3} , // 0
                {0,2}   , // 1
                {0,1,3} , // 2
                {0,2}     // 3
        }));
        System.out.println(object.isBipartite(new int[][]{
                {1,3} , // 0
                {0,2} , // 1
                {1,3} , // 2
                {0,2}   // 3
        }));
    }
}
class solutionG33{
    public boolean isBipartite(int[][] graph) {
        int V = graph.length ;
        int[] color = new int[V] ;
        for (int i = 0 ; i < V ; i++)
            color[i] = -1 ;
        for (int i = 0 ; i < V ; i ++) {
            if (color[i] == -1) {
                if (!COLORIT(graph,i,color)) return false ;
            }
        }
        return true ;
    }
    private boolean COLORIT(int[][] AdjGraph , int src , int[] color) {
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(src) ;
        color[src] = 1 ;
        while (!queue.isEmpty()) {
            int front = queue.remove() ;

            for (int neighbour : AdjGraph[front]) {
                if (color[neighbour] == -1) {
                    color[neighbour] = 1 - color[front] ;
                    queue.add(neighbour) ;
                }
                else if (color[neighbour] == color[front])
                    return false ;
            }
        }
        return true ;
    }
}
