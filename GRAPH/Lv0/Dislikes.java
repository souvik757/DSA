import java.util.LinkedList ;
import java.util.Queue ;
public class Dislikes { // Bipartite Graph :::
    public static void main(String[] args) {
        solutionG31 object = new solutionG31() ;
        System.out.println(object.possibleBipartition(4 ,
                new int[][]{
                        {1, 2} ,
                        {1, 3} ,
                        {2, 4} ,
                })
        );
        System.out.println(object.possibleBipartition(3 ,
                new int[][]{
                        {1, 2} ,
                        {1, 3} ,
                        {2, 3} ,
                })
        );
    }
}
class solutionG31{
    private LinkedList<Integer>[] AdjList ;
    private void MakeAdjList(int n , int[][] Edges) {
        AdjList = new LinkedList[n+1] ;
        for (int i = 0 ; i <= n ; i ++)
            AdjList[i] = new LinkedList<>();

        for (int i = 0 ; i < Edges.length ; i ++) {
            AdjList[Edges[i][0]].add(Edges[i][1]) ;
            AdjList[Edges[i][1]].add(Edges[i][0]) ;
        }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        MakeAdjList(n,dislikes) ;
        // '-1' => not colored yet .
        // '0'  => blue colored .
        // '1'  => red  colored .
        // if any two adjacency vertexes are colored with same color means it is invalid .
        int[] color = new int[n+1] ;
        for (int i = 0 ; i <= n ; i ++)
            color[i] = -1 ;
        for (int i = 1 ; i <= n ; i ++) {
            if (color[i] == -1)
            {
                if (!CanBeColored(i,color))
                    return false ;
            }
        }
        return true ;
    }

    private boolean CanBeColored(int src, int[] color) {
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(src) ;
        color[src] = 1 ; // start coloring with red / '1' :::

        while (!queue.isEmpty()) {
            int front = queue.remove() ;
            for (int neighbours : AdjList[front]) {
                if (color[neighbours] == -1) {
                    color[neighbours] = 1 - color[front] ; // color of a neighbor should be opposite of its parent :::
                    queue.add(neighbours) ;
                }
                else if (color[neighbours] == color[front]) // adjacent neighbor's color should not be the same :::
                    return false ;
            }
        }
        return true;
    }
}
