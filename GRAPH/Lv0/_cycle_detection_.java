import java.util.*;

public class _cycle_detection_ {
    public static LinkedList<Integer>[] adjList ;
    public static void main(String[] args) {
        int vertex ;
        int NumberOfEdges ;
        List<solve.Pair> edges = new ArrayList<>() ;

        System.out.println("Enter number of vertex ->  "+"\nfollowed by number of edges -> ");
        vertex = new Scanner(System.in).nextInt() ;
        NumberOfEdges = new Scanner(System.in).nextInt() ;

        BFS.create_edges(NumberOfEdges , edges);
        System.out.println(_is_cycle_detected(vertex , edges));
    }
    public static String _is_cycle_detected(int vertex , List<solve.Pair> edges){
        Map<Integer , Boolean> visited = new HashMap<>() ;
        for(int i = 0 ; i < vertex ; i++){
            visited.put(i , false) ;
        }
        makeAdjList(edges , vertex);
        System.out.println("Adjacency list : " + Arrays.toString(adjList));
        for(int i = 0 ; i < vertex ; i++){
            if(!visited.get(i)){
                boolean answer = _cycle_detection_BFS_(i,visited) ;
                if(answer)
                    return "Cycle detected " ;
            }
        }
        return "Clean no cycle" ;
    }
    public static boolean _cycle_detection_BFS_(int start ,Map<Integer,Boolean> visited){
        Map<Integer,Integer> parent = new HashMap<>() ;
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(start) ;
        parent.put(start , -1) ;
        visited.put(start , true) ;

        while(!queue.isEmpty()){
            int front = queue.poll() ;
            for(int neighbor : adjList[front]){
                if(visited.get(neighbor) && neighbor != parent.get(front)) {
                    System.out.print("at vertex "+neighbor);
                    return true ;
                }
                else if (!visited.get(neighbor)){
                    queue.add(neighbor) ;
                    visited.put(neighbor , true) ;
                    parent.put(neighbor , front) ;}
            }
        }
        return false ;
    }
    public static void makeAdjList(List<solve.Pair> edges , int vertex) {
        adjList = new LinkedList[vertex] ;
        for(int i = 0 ; i < vertex ; i++){
            adjList[i] = new LinkedList<>() ;
        }
        for(int i = 0 ; i < edges.size() ; i++){
            int u = edges.get(i).first ;
            int v = edges.get(i).second ;
            adjList[u].add(v) ;
            adjList[v].add(u) ;
        }
    }
}
