import java.util.* ;
public class _1192_CriticalConnection {
    public static void main(String[] args) {

    }
}
class SOLVE1192{
    private LinkedList<Integer>[] adjList ;
    private void MakeAdj(int n, List<List<Integer>> connections){
        adjList = new LinkedList[n] ;
        for (int i = 0 ; i < n ; i ++)
            adjList[i] = new LinkedList<>() ;
        for (List<Integer> val : connections){
            adjList[val.get(0)].add(val.get(1)) ;
            adjList[val.get(1)].add(val.get(0)) ;
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        MakeAdj(n , connections) ;
        int time = -1 ;
        int parent = -1 ;
        int[] discovery = new int[n] ;
        int[] low = new int[n] ;
        boolean[] visited = new boolean[n] ;
        for (int i = 0 ; i < n ; i ++){
            discovery[i] = -1 ;
            low[i] = -1 ;
        }
        List<List<Integer>> answer = new ArrayList<>() ;
        for (int i = 0 ; i < n ; i ++){
            if(!visited[i])
                dfs(i , parent , time , discovery , low , visited , answer) ;
        }
        return answer ;
    }

    private void dfs(int src, int parent, int time, int[] discovery, int[] low, boolean[] visited, List<List<Integer>> answer) {
        visited[src] = true ;
        discovery[src] = low[src] = time++ ;
        for (int neighbor : adjList[src]){
            if(neighbor != parent) {
                if (!visited[neighbor]) {
                    dfs(neighbor, src, time, discovery, low, visited, answer);
                    // during backtracking :::
                    low[src] = Math.min(low[src], low[neighbor]);
                    if (low[neighbor] > discovery[src]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(src);
                        list.add(neighbor);
                        answer.add(new ArrayList<>(list));
                    }
                } else {
                    low[src] = Math.min(low[src], discovery[neighbor]);
                }
            }
        }
    }
}