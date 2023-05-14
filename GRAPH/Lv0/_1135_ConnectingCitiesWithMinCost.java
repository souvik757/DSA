import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1135_ConnectingCitiesWithMinCost {
    public static void main(String[] args) {
        SOLVE1135 object = new SOLVE1135() ;
        System.out.println(object.minimumCost(3 ,
                new int[][]{
                        {1 , 2 , 5} ,
                        {1 , 3 , 6} ,
                        {2 , 3 , 1}
                })
        );
        System.out.println(object.minimumCost(5 ,
                new int[][]{
                        {1 , 2 , 2} ,
                        {1 , 4 , 6} ,
                        {2 , 3 , 3} ,
                        {2 , 5 , 5} ,
                        {2 , 4 , 8} ,
                        {3 , 5 , 7}
                })
        );
    }
}
class SOLVE1135{
    private int TotalCost ;
    private List<List<int[]>> AdjList ;
    private void MakeAdjList(int N , int[][] edges){
        AdjList = new ArrayList<>() ;
        for (int i = 0 ; i < N+1 ; i ++)
            AdjList.add(new ArrayList<>()) ;
        for(int[] val : edges){
            AdjList.get(val[0]).add(new int[]{val[1] , val[2]}) ;
            AdjList.get(val[1]).add(new int[]{val[0] , val[2]}) ;
        }
    }
    public String minimumCost(int N, int[][] connections) {
        TotalCost = 0 ;
        MakeAdjList(N,connections) ;

        int[] cost = new int[N+1];
        boolean[] MST = new boolean[N+1] ;
        int[] parent = new int[N+1] ;

        Arrays.fill(cost , Integer.MAX_VALUE) ;
        Arrays.fill(parent , -1);

        cost[1] = 0 ;
        parent[1] = -1 ;

        for (int i = 1 ; i <= N ; i ++){
            int min = Integer.MAX_VALUE ;
            int u = -1 ;
            for(int j = 1 ; j <= N ; j ++){
                if(!MST[j] && cost[j] < min){
                    u = j ;
                    min = cost[j] ;
                }
            }
            MST[u] = true ;
            for (int[] neighbour : AdjList.get(u)){
                int nextnode = neighbour[0] ;
                int nextcost = neighbour[1] ;
                if(!MST[nextnode] && nextcost < cost[nextnode]){
                    parent[nextnode] = u ;
                    cost[nextnode] = nextcost ;
                }
            }
        }
        System.out.println("Edges for Minimum Spanning tree :::");
        for (int i = 2 ; i <= N ; i++){
            System.out.println(i+" -> "+parent[i]);
        }
        for (int i =2 ; i <= N ; i++) {
            for (int[] val : connections) {
                if (val[0] == i && val[1] == parent[i] ||
                        val[0] == parent[i] && val[1] == i)
                    TotalCost += val[2] ;
            }
        }
        return "Cost "+TotalCost ;
    }
}
