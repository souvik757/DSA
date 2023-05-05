import java.util.* ;
public class _2608_ {
    public static void main(String[] args) {
        SOLVE2608 object = new SOLVE2608() ;
        System.out.println(object.findShortestCycle(7 ,
                new int[][]{
                        {0,1} ,
                        {1,2} ,
                        {2,0} ,
                        {3,4} ,
                        {4,5} ,
                        {5,6} ,
                        {6,3}
                })
        );
        System.out.println(object.findShortestCycle(4 ,
                new int[][]{
                        {0,1} ,
                        {0,2}
                })
        );
        System.out.println(object.ShorestLengthDFS(3 ,
                new int[][]{
                        {1,0} ,
                        {2,1} ,
                        {0,2}
                })
        );
    }
}
class SOLVE2608{
    private int MinLength ;
    private LinkedList<Integer>[] adjList ;
    private void MakeAdjList(int n , int[][] edges) {
        adjList = new LinkedList[n] ;
        for (int i = 0 ; i < n ; i ++)
            adjList[i] = new LinkedList<>() ;
        for (int i = 0 ; i < edges.length ; i ++){
            adjList[edges[i][0]].add(edges[i][1]) ;
            adjList[edges[i][1]].add(edges[i][0]) ;
        }
        //for (int i = 0 ; i < n ; i ++)
        //    System.out.println(adjList[i]);
    }
// BFS :::
    public int findShortestCycle(int n, int[][] edges) {
        MinLength = Integer.MAX_VALUE ;
        MakeAdjList(n, edges);
        for (int i = 0 ; i < n ; i ++){
            Queue<Integer> queue = new LinkedList<>() ;
            int[] distance = new int[n] ;
            int[] parent = new int[n] ;
            Arrays.fill(distance , Integer.MAX_VALUE) ;
            Arrays.fill(parent , -1) ;
            queue.add(i) ;
            distance[i] = 0 ;
            while (!queue.isEmpty()) {
                int front = queue.remove() ; // parent node :::
                for (int neighbour : adjList[front]){
                    if(distance[neighbour] == Integer.MAX_VALUE){
                        distance[neighbour] = distance[front] + 1 ;
                        parent[neighbour] = front ;
                        queue.add(neighbour) ;
                    }
                    else if(parent[front] != neighbour && parent[neighbour] != front) // distance has been already allocated :::
                    {
                        int length = distance[front] + distance[neighbour] + 1 ;
                        MinLength = Math.min(MinLength , length) ;
                    }
                }
            }
        }
        return (MinLength == Integer.MAX_VALUE) ? -1 : MinLength ;
    }
    // Has some issues :::
    public int ShorestLengthDFS(int n, int[][] edges){
        MinLength = Integer.MAX_VALUE ;
        MakeAdjList(n,edges) ;
        int[] distance = new int[n] ;
        for(int i = 0 ; i < n ; i ++){
            if(distance[i] > 0) continue ;
            dfs(i,-1,distance,0) ;
        }
        return (MinLength==Integer.MAX_VALUE) ? -1 : MinLength ;
    }

    private void dfs(int src, int parent, int[] distance, int dist) {
        if(distance[src] > 0)
        {
            if(dist - distance[src] > 0)
                MinLength = Math.min(MinLength , dist-distance[src]) ;
            return ;
        }
        distance[src] = dist ;
        for (int neighbor : adjList[src]){
            if(neighbor == parent)
                continue ;
            dfs(neighbor , src , distance , dist+1);
        }
    }
}
