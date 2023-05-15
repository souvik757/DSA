import java.util.*;

public class _1584_MinCostConnectPoint {
    public static void main(String[] args) {
        SOLVE1584 object = new SOLVE1584() ;
        System.out.println(object.minCostConnectPoints(new int[][]{
                {0 , 0 } ,
                {2 , 2 } ,
                {3 , 10} ,
                {5 , 2 } ,
                {7 , 0 }
        }));
    }
}
class SOLVE1584{
    public int minCostConnectPoints(int[][] points) {
        int cost = 0 ;
        int N = points.length ;
        if(N<=1)
            return cost ;
        Queue<int[]> queue = new PriorityQueue<>((x, y)->x[1]-y[1]) ;
        Set<Integer> visited = new HashSet<>() ;
        Map<Integer , List<int[]>> adjList = new HashMap<>() ;

        for (int i = 0 ; i < N ; i ++){
            int[] pointA = points[i] ;
            for (int j = i + 1 ; j < N ; j ++){
                int[] pointB = points[j] ;
                int distance = Math.abs(pointA[0]-pointB[0])+Math.abs(pointA[1]-pointB[1]) ;
                List<int[]> t1 = adjList.getOrDefault(i , new ArrayList<>()) ;
                t1.add(new int[]{j,distance}) ;
                adjList.put(i,t1) ;

                List<int[]> t2 = adjList.getOrDefault(j , new ArrayList<>()) ;
                t2.add(new int[]{i,distance}) ;
                adjList.put(j,t2) ;

            }
        }

        queue.add(new int[]{0,0}) ;

        while (visited.size() < N){
            int[] front = queue.remove() ;
            if(visited.contains(front[0]))
                continue ;
            cost += front[1] ;
            visited.add(front[0]) ;
            for (int[] neighbour : adjList.get(front[0])){
                if(!visited.contains(neighbour[0]))
                    queue.add(neighbour) ;
            }

        }

        return cost ;
    }
}
