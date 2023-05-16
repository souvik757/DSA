import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestDistDAG {
    public static void main(String[] args) {
        SHORTEST_DAG obj = new SHORTEST_DAG() ;
        System.out.println(obj.shortestDistance(6 ,0 ,4 ,new int[][]{
                { 0 , 1 ,  2} ,
                { 0 , 2 ,  1} ,
                { 1 , 3 ,  4} ,
                { 2 , 3 ,  5} ,
                { 1 , 5 ,  3} ,
                { 3 , 4 , -1} ,
                { 5 , 4 ,  1}
        }));
    }
}
class SHORTEST_DAG {
    private ArrayList<List<int[]>> AdjList ;
    private void MakeAdjList(int N , int[][] edges){
        AdjList = new ArrayList<>() ;
        for (int i = 0 ; i < N ; i ++)
            AdjList.add(new ArrayList<>()) ;
        for (int[] val : edges)
            AdjList.get(val[0]).add(new int[]{val[1] , val[2]}) ;
    }
    public String shortestDistance(int N ,int src , int destination, int[][] edges){
        MakeAdjList(N , edges) ;

        List<Integer> TopList = topological(N) ;
        System.out.println("Topology order : "+TopList);
        int[] cost = new int[N] ;
        Arrays.fill(cost , Integer.MAX_VALUE) ;
        cost[src] = 0 ;
        for (int val : TopList){
            if(cost[val] != Integer.MAX_VALUE){
                for(int[] neighbour : AdjList.get(val)){
                    if(cost[val]+neighbour[1] < cost[neighbour[0]])
                        cost[neighbour[0]] = cost[val]+neighbour[1] ;
                }
            }
        }
        System.out.println("Shortest distance from "+src+" to each vertex :::");
        for (int i = 0 ; i < N ; i ++)
            System.out.println(src+" -> "+i+" : "+cost[i]);

        return src+" to "+destination+" : "+cost[destination] ;
    }
    private List<Integer> topological(int N){
        List<Integer> list = new ArrayList<>() ;
        Stack<Integer> stack = new Stack<>() ;
        boolean[] visited = new boolean[N] ;
        for (int i = 0 ; i < N ; i ++){
            if(!visited[i])
                dfs(i,visited,stack) ;
        }
        while (!stack.isEmpty())
            list.add(stack.pop()) ;
        return list ;
    }
    private void dfs(int src , boolean[] visited , Stack<Integer> stack){
        visited[src] = true ;
        for (int[] neighbour : AdjList.get(src)){
            if(!visited[neighbour[0]])
                dfs(neighbour[0] , visited , stack);
        }
        stack.add(src) ;
    }
}