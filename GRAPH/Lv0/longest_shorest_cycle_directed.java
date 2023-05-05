import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class longest_shorest_cycle_directed {
    public static void main(String[] args) {
        solutionG00E object = new solutionG00E() ;
        System.out.println(Arrays.toString(object.longestCycle(new int[]{3,3,4,2,3})));// [ maxcycle , mincycle]
        System.out.println(Arrays.toString(object.longestCycle(new int[]{3,3,4,2,3,6,7,8,5})));
    }
}
class solutionG00E{
    private int MaxLength ;
    private int MinLength ;
    public int[] longestCycle(int[] edges) {
        MaxLength = Integer.MIN_VALUE ;
        MinLength = Integer.MAX_VALUE ;
        int N = edges.length ;
        boolean[] visited = new boolean[N] ;
        Map<Integer,Integer> length = new HashMap<>() ;
        Map<Integer,Integer> count  = new HashMap<>() ;
        int len   = 1 ;
        int cycle = 1 ;
        for (int i = 0 ; i < N ; i ++) {
            if(!visited[i]) {
                DFS(i ,visited , edges , length , count , len , cycle) ;
                cycle = cycle + 1 ;
            }
        }
        if(MaxLength == Integer.MIN_VALUE && MinLength == Integer.MAX_VALUE)
            return new int[]{-1 , -1} ;
        return new int[]{MaxLength , MinLength} ;
    }
    private void DFS(int src ,boolean[] visited , int[] edges , Map<Integer,Integer> length , Map<Integer,Integer> count , int len , int cycle) {
        visited[src] = true ;
        length.put(src , len) ;
        count.put(src , cycle);
        int neighbour = edges[src] ;
        if(neighbour == -1)
            return ;
        if(!visited[neighbour])
            DFS(neighbour , visited , edges , length , count , len+1 , cycle);
        else if(length.containsKey(neighbour) && (count.get(neighbour)==count.get(src))){
            int _length_ = length.get(src) - length.get(neighbour) + 1 ;
            MaxLength = Math.max(MaxLength , _length_) ;
            MinLength = Math.min(MinLength , _length_) ;
        }
    }
}
