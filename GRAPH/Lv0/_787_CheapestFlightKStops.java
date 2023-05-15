import java.util.*;

public class _787_CheapestFlightKStops {
    public static void main(String[] args) {
        SOLVE787 object = new SOLVE787() ;
        System.out.println(object.findCheapestPrice(4 ,new int[][]{
                        { 0 , 1 , 100 } ,
                        { 1 , 2 , 100 } ,
                        { 2 , 0 , 100 } ,
                        { 1 , 3 , 600 } ,
                        { 2 , 3 , 200 }
                } ,
                0,
                3,
                 1)
        );
        System.out.println(object.findCheapestPrice(4 ,new int[][]{
                                { 0 , 1 , 1 } ,
                                { 0 , 2 , 5 } ,
                                { 1 , 2 , 1 } ,
                                { 2 , 3 , 1 }
                        } ,
                        0,
                        3,
                        1)
        );
    }

}
class SOLVE787{
    private ArrayList<List<int[]>> AdjList ;
    private void MakeAdj(int n , int[][] flights){
        AdjList = new ArrayList<>() ;
        for (int i = 0 ; i < n ; i ++)
            AdjList.add(new ArrayList<>()) ;
        for (int[] val : flights)
            AdjList.get(val[0]).add(new int[]{val[1] , val[2]}) ;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        MakeAdj(n , flights) ;
        int[] cost = new int[n] ;
        Arrays.fill(cost , Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>() ;
        queue.add(new int[]{src,0}) ;
        cost[src] = 0 ;
        int currentStop = 0 ;
        while (!queue.isEmpty() && currentStop <= k){
            int size = queue.size() ;
            for (int len = 0 ; len < size ; len ++) {
                int[] front = queue.remove();
                int currentNode = front[0];
                int currentCost = front[1];
                for (int[] neighbour : AdjList.get(currentNode)) {
                    int nextNode = neighbour[0];
                    int nextCost = neighbour[1];
                    int newCost = currentCost + nextCost;
                    if (newCost < cost[nextNode]) {
                        cost[nextNode] = newCost;
                        queue.add(new int[]{nextNode, newCost});
                    }
                }
//                System.out.println("k : " + currentStop);
//                System.out.println(Arrays.toString(cost));
            }
            currentStop++ ;
        }
        return (cost[dst] == Integer.MAX_VALUE) ? -1 : cost[dst] ;
    }
}