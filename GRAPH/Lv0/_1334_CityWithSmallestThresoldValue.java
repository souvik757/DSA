import java.util.List ;
import java.util.ArrayList ;
import java.util.Queue ;
import java.util.PriorityQueue ;
public class _1334_CityWithSmallestThresoldValue {
    public static void main(String[] args) {
        SOLVE1334 object = new SOLVE1334() ;
        System.out.println(object.findTheCity(4 ,
                new int[][]{
                        {0 , 1 , 3} ,
                        {1 , 2 , 1} ,
                        {1 , 3 , 4} ,
                        {2 , 3 , 1}
                } ,
                4)
        );
        System.out.println(object.findTheCity(5 ,
                new int[][]{
                        {0 , 1 , 2} ,
                        {0 , 4 , 8} ,
                        {1 , 2 , 3} ,
                        {1 , 4 , 2} ,
                        {2 , 3 , 1} ,
                        {3 , 4 , 1}
                } ,
                2)
        );
    }
}
class SOLVE1334{
    private List<List<int[]>> adjList ;
    private void MakeAdjList(int n , int[][] edges){
        adjList = new ArrayList<>() ;
        for (int i = 0 ; i < n ; i ++)
            adjList.add(new ArrayList<>()) ;
        for (int[] val : edges) {
            adjList.get(val[0]).add(new int[]{val[1], val[2]});
            adjList.get(val[1]).add(new int[]{val[0], val[2]});
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        MakeAdjList(n , edges) ;
        int MinNode = 0 ;
        int K = distanceThreshold ;
        int Min = Integer.MAX_VALUE ;

        for (int i = 0 ; i < n ; i ++){
            int count = PerformDijktra(i ,K);
            if(count <= Min){
                MinNode = i ;
                Min = count ;
            }
        }
        return MinNode ;
    }
    private int PerformDijktra(int src ,int K){
        Queue<int[]> priorityQueue = new PriorityQueue<>((x,y)->x[1]-y[1]) ;
        priorityQueue.add(new int[]{src , 0}) ;
        boolean[] visited = new boolean[adjList.size()] ;
        int nodecount = -1 ;

        while (!priorityQueue.isEmpty()){
            int currentNode = priorityQueue.peek()[0] ;
            int currentNodeDist = priorityQueue.remove()[1] ;

            if(visited[currentNode])
                continue ;
            visited[currentNode] = true ;
            nodecount++ ;
            for (int[] neighbor : adjList.get(currentNode)){
                if(!visited[neighbor[0]] && neighbor[1]+currentNodeDist <= K)
                    priorityQueue.add(new int[]{neighbor[0] , neighbor[1]+currentNodeDist}) ;
            }
        }
        return nodecount ;
    }
}
