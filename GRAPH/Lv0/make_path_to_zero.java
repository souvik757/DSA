import java.util.* ;

public class make_path_to_zero {
    public static void main(String[] args) {
        solutionG20 object = new solutionG20() ;
        System.out.println("Paths to be altered => "+object.minReorder(6 , new int[][]{
                {0, 1} ,
                {1, 3} ,
                {2, 3} ,
                {4, 0} ,
                {4, 5}
        }));
    }
}
class solutionG20{
    private LinkedList<int[]>[] adjList ;
    private void MakeAdjList(int n , int[][] paths){
        adjList = new LinkedList[n] ;
        for(int i = 0 ; i < n ; i ++)
            adjList[i] = new LinkedList<>() ;
        for(int[] val : paths){
            adjList[val[0]].add(new int[]{val[1] , 1}) ; // positive direction
            adjList[val[1]].add(new int[]{val[0] , 0}) ; // opposite direction
        }
    }
    public int minReorder(int n, int[][] connections) {
        int CountPath = 0 ;
        MakeAdjList(n , connections) ;

        boolean[] visited = new boolean[n] ;
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(0) ;
        while (!queue.isEmpty()){
            int city = queue.remove() ;
            if(visited[city])
                continue ;
            visited[city] = true ;
            for(int[] neighbours : adjList[city]){
                if(!visited[neighbours[0]]){
                    queue.add(neighbours[0]) ;
                    if(neighbours[1] == 1) CountPath++ ;
                }
            }
        }
        return CountPath ;
    }
}