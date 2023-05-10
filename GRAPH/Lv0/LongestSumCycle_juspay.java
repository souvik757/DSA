import java.util.Map ;
import java.util.HashMap ;
import java.util.Scanner;

public class LongestSumCycle_juspay {
    public static void main(String[] args) {
        SOLVEJUSPAYOA1 object = new SOLVEJUSPAYOA1() ;
        Scanner sc = new Scanner(System.in) ;
        int N = sc.nextInt() ;
        int[] edges = new int[N] ;
        for (int i = 0 ; i < N ; i++)
            edges[i] = sc.nextInt() ;

        System.out.println(object.GetLongestSumCycle(N , edges));
    }
}
class SOLVEJUSPAYOA1 {
    private int MaxSum ;

    public int GetLongestSumCycle(int N , int[] edges) {
        MaxSum = Integer.MIN_VALUE ;
        boolean[] visited = new boolean[N] ;
        Map<Integer,Integer> sum   = new HashMap<>() ;
        Map<Integer,Integer> count = new HashMap<>() ;
        int cycle = 1 ;
        for (int i = 0 ; i < N ; i ++) {
            if(!visited[i]){
                int _SUM_ = 0 ;
                dfs(i,visited, edges , sum,count,_SUM_,cycle) ;
                cycle++ ;
            }
        }
        return MaxSum ;
    }

    private void dfs(int src, boolean[] visited, int[] edges, Map<Integer, Integer> sum, Map<Integer, Integer> count  , int SUM , int cycle) {
        visited[src] = true ;
        SUM += src ;
        sum.put(src , SUM) ;
        count.put(src , cycle) ;
        int neighbor = edges[src] ;
        if(neighbor == -1)
            return ;
        if(!visited[neighbor])
            dfs(neighbor , visited , edges , sum , count , SUM, cycle);
        else if(sum.containsKey(neighbor) && (count.get(src) == count.get(neighbor))){
            int _SUM_ = sum.get(src) - sum.get(neighbor) + neighbor ;
            MaxSum = Math.max(MaxSum , _SUM_) ;
        }
    }
}
/*
23
4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21
5
3 3 4 2 3
 */
