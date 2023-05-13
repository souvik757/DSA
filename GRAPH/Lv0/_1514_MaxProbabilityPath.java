import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1514_MaxProbabilityPath {
    public static void main(String[] args) {
        SOLVE1514 object = new SOLVE1514() ;
        System.out.println(object.maxProbability(3 , new int[][]{
                {0,1} ,
                {1,2} ,
                {0,2}
        } ,
                new double[]{0.5 , 0.5 , 0.2} , 0 , 2));
    }
}
class SOLVE1514{
    private ArrayList<List<double[]>> adjList ;
    private void MakeAdjList(int n, int[][] edges , double[] cost){
        adjList = new ArrayList<>() ;
        for (int i = 0 ; i < n ; i++)
            adjList.add(new ArrayList<>()) ;
        for (int i = 0 ; i < edges.length ; i ++){
            adjList.get(edges[i][0]).add(new double[]{edges[i][1] , cost[i]}) ;
            adjList.get(edges[i][1]).add(new double[]{edges[i][0] , cost[i]}) ;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if(end >= n)
            return (double)0 ;
        MakeAdjList(n,edges , succProb);
        double[] cost = new double[n] ;
        for (int i = 0 ; i < n ; i ++)
            cost[i] = 0.0 ;
        Queue<double[]> priorityqueue = new PriorityQueue<>((x,y)->{
            if(y[1] > x[1])
                return 1 ;
            return -1 ;
        }) ;
        // Accepted :::
        priorityqueue.add(new double[]{start , 1}) ;
        while (!priorityqueue.isEmpty()){
            double CurrentNode = priorityqueue.peek()[0] ;
            double CurrentDist = priorityqueue.poll()[1] ;

            for (double[] neighbour : adjList.get((int)CurrentNode)){
                if(neighbour[0] == CurrentNode)
                    continue ;
                double newDist = CurrentDist*neighbour[1] ;
                if(newDist > cost[(int)neighbour[0]]){
                    cost[(int)neighbour[0]] = newDist ;
                    if(neighbour[0] != end)
                        priorityqueue.add(new double[]{neighbour[0] , newDist}) ;
                }
            }
        }
        // Not Accepted :::
//  *      while (!priorityqueue.isEmpty()){
//  *          double currentnode = priorityqueue.peek()[0] ;
//  *          double currentnodedist = priorityqueue.remove()[1] ;
//  *
//  *          for (double[] neighbour : adjList.get((int)currentnode)){
//  *              if(neighbour[0] == currentnode)
//  *                  continue ;
//  *              double newDistance = currentnodedist*neighbour[1] ;
//  *              if(neighbour[0] == end)
//  *                  MaxProb = Math.max(MaxProb , newDistance) ;
//  *              if(newDistance < cost[(int)neighbour[0]]){
//  *                  cost[(int)neighbour[0]] = newDistance ;
//  *                  priorityqueue.add(new double[]{neighbour[0] , newDistance}) ;
//  *              }
//  *           }
//  *      }

        return cost[end] ;
    }
}

