import java.util.* ;
public class max_time_to_inform_find_cost {
    public static void main(String[] args) {
        solutionG17 object = new solutionG17() ;
        System.out.println(object.numOfMinutes(6,2,new int[]{
                2,2,-1,2,2,2
        } , new int[]{
                0,0,1,0,0,0
        }));
        System.out.println(object.numOfMinutes(6,3,new int[]{
                3,3,3,-1,1,1
        } , new int[]{
                0,3,0,1,2,0
        }));
    }
}
class solutionG17{
    private int MaxTime ;
    private Map<Integer,Integer> _cost_ ;
    private LinkedList<Integer>[] adjList ;
    private void MakeAdj(int N,int[] srcAdj){
        adjList = new LinkedList[N] ;
        for(int i = 0 ; i < N ; i++)
            adjList[i] = new LinkedList<>() ;
        for(int i = 0 ; i < srcAdj.length ; i++){
            if(srcAdj[i] == -1)
                continue ;
            adjList[srcAdj[i]].add(i) ;
        }
    }
    private void SetCost(int N ,int[] cost){
        _cost_ = new HashMap<>() ;
        for(int i = 0 ; i < N ; i++)
            _cost_.put(i,cost[i]) ;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        if(n == 1) return 0 ;

        boolean[] visited = new boolean[n] ;
        MakeAdj(n,manager) ; // Adjacency List is prepared !
        for(int i = 0 ; i < n ; i++)
            System.out.println(i+"->"+adjList[i]) ;
        SetCost(n,informTime) ; // Setting Cost for each vertex .
        MaxTime = 0 ;
        _traverse_by_dfs_(headID , MaxTime , visited) ;

        return MaxTime ;
    }
    private void _traverse_by_dfs_(int i , int maxTime , boolean[] visited){
        int updateCost = maxTime + _cost_.get(i) ;
        MaxTime = Math.max(MaxTime , updateCost) ;
        for(int neighbors : adjList[i]){
            _traverse_by_dfs_(neighbors , updateCost , visited);
        }
    }
}