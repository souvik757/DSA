import java.util.*;

/*
   ::: Dijkstra's Algorithm :::
 */

public class _743_NetworkDelayTime {
    public static void main(String[] args) {
        SOLVE743 object = new SOLVE743() ;
        System.out.println(object.networkDelayTime(
                new int[][]{
                        {2 , 1 , 1} ,
                        {2 , 3 , 1} ,
                        {3 , 4 , 1}
                }   ,
                4 ,
                2
        ));
        System.out.println(object.networkDelayTime(
                new int[][]{
                        {1 , 2 , 1} ,
                        {2 , 3 , 1} ,
                        {2 , 5 , 1} ,
                        {3 , 4 , 1} ,
                        {3 , 7 , 1} ,
                        {5 , 6 , 1}
                }   ,
                7 ,
                2
        ));
    }
}
class SOLVE743{
    private int MaxTime ;
    private List<List<int[]>> adjList ;
    private void MakeAdj(int n ,int[][] times){
        MaxTime = Integer.MIN_VALUE ;
        adjList = new ArrayList<>() ;
        for (int i = 0 ; i < n+1 ; i ++)
            adjList.add(new ArrayList<>()) ;
        for (int[] val : times){
            adjList.get(val[0]).add(new int[]{val[1],val[2]}) ;
        }
// *       System.out.println("node -> [neighbour,distance][][]..");
// *       for (int i = 1 ; i <= n ; i ++){
// *           System.out.print(i+"->");
// *           for (int[] list : adjList.get(i))
// *               System.out.print(Arrays.toString(list));
// *           System.out.println();
// *       }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        MakeAdj(n ,times) ;
        int[] distances = new int[n+1] ;
        for (int i = 0 ; i < n+1 ; i ++)
            distances[i] = Integer.MAX_VALUE ;
        /*
        * The comparator is specified as a lambda expression (x,y)->x[1]-y[1],
        * which takes two int arrays (x and y) and compares their second elements (x[1] and y[1]).
        * The comparator returns a negative value if x[1] is less than y[1],
        * zero if they are equal, and a positive value if x[1] is greater than y[1].
        * So, the PriorityQueue will order the int arrays in ascending order
        * based on their second element.
        * This means that when you remove elements from the queue using the poll() method,
        * the element with the smallest second element value will be returned first.
         */
        Queue<int[]> priorityqueue = new PriorityQueue<>((x,y)->x[1]-y[1]) ;
        priorityqueue.add(new int[]{k,0}) ;
        distances[0] = 0 ;
        distances[k] = 0 ;

        while (!priorityqueue.isEmpty()){
            int CurrentNode = priorityqueue.peek()[0] ;
            int CurrentNodeDist = priorityqueue.poll()[1] ;

            for (int[] neighbor : adjList.get(CurrentNode)){
                int NewNode = neighbor[0] ;
                int NewNodeDist = neighbor[1] ;

                if(CurrentNodeDist + NewNodeDist < distances[NewNode]){
                    distances[NewNode] = CurrentNodeDist + NewNodeDist ;
                    priorityqueue.add(new int[]{NewNode , distances[NewNode]}) ;
                }
            }
        }

        for (int val : distances){
            MaxTime = Math.max(MaxTime , val) ;
        }

        return (MaxTime == Integer.MAX_VALUE) ? -1 : MaxTime ;
    }
}
