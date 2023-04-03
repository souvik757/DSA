import java.util.*;
// Algorithm ->
/*
pre-requisites :
- adjacency list
- queue
BREADTH FIRST SEARCH :
1 . add first vertex to queue
2 . make top-most vertex(_poll_) of queue mark as visited
3 . print the top-most vertex(_poll_) of queue
4 . remove it from queue
5 . add each neighbor of _poll_ to queue .
6 . repeat step 2 to 5 until queue becomes empty .
DEPTH FIRST SEARCH :
1 . add first vertex to list
2 . make first vertex to true
3 . repeat 4 to 5 .
4 . check for adjacent vertex's of added node
5 . if it is not yet marked true OR not visited then repeat step 1 to 5 .
 */
public class BFS {
    public static void main(String[] args) {
        int vertex = 0 ;
        int NumberOfEdges = 0 ;
        solve result = new solve() ;
        List<solve.Pair> edges = new ArrayList<>() ;

        System.out.println("Enter number of vertex ->  "+"\nfollowed by number of edges -> ");
        vertex = new Scanner(System.in).nextInt() ;
        NumberOfEdges = new Scanner(System.in).nextInt() ;
        System.out.println("Starting vertex - >");
        int start = new Scanner(System.in).nextInt() ;

        create_edges(NumberOfEdges , edges);

        System.out.println("BFS traversal : "+result._get_traversal_BFS_(start , vertex , edges)) ;
    }
    public static void create_edges(int NumberOfEdges , List<solve.Pair> edges){
        for(int i = 0 ; i < NumberOfEdges ; i++){
            System.out.print("left vertex : ");
            int first = new Scanner(System.in).nextInt() ;
            System.out.print("right vertex : ");
            int end = new Scanner(System.in).nextInt() ;
            System.out.println("edge created - "+first+"------"+end);
            solve.Pair pair = new solve.Pair(first , end) ;
            edges.add(pair) ;
        }
    }
}
class solve{
    // an array of list that will store adjacency list corresponding to each vertex -->
    public LinkedList<Integer>[] adjList ;



    // traverse by bfs -->
    public List<Integer> _get_traversal_BFS_(int start , int vertex , List<Pair> edges){
        List<Integer> ListOfEdges = new ArrayList<>() ;
        ListOfEdges.add(start) ;
        for(int i = 0 ; i < vertex ; i++){
            if(!ListOfEdges.contains(i))
                ListOfEdges.add(i) ;
        }
        List<Integer> ans = new ArrayList<>();
        Map<Integer , Boolean> visited = new HashMap<>() ;
        for(int i = 0 ; i < vertex ; i++)
            visited.put(i,false) ;
        makeAdjList(edges , vertex) ;
        // traverse all components of G ->
        for(int i : ListOfEdges){
            if(!visited.get(i))
                _apply_bfs_(visited , ans , i) ;
        }
        return ans ;
    }
    // actual bfs function --> Iterative approach
    private void _apply_bfs_(Map<Integer, Boolean> visited, List<Integer> ans, int i) {
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(i) ;
        visited.put(i , true) ;
        while (!queue.isEmpty()){
            int frontNode = queue.poll() ;
            ans.add(frontNode) ;
            for(int value : adjList[frontNode])
            {
                if(!visited.get(value)){
                    queue.add(value) ;
                    visited.put(value , true) ;
                }
            }
        }

    }



    // traverse by dfs -->
    public List<Integer> _get_traversal_DFS_(int start , int vertex , List<Pair> edges){
        List<Integer> ListOfEdges = new ArrayList<>() ;
        ListOfEdges.add(start) ;
        for(int i = 0 ; i < vertex ; i++){
            if(!ListOfEdges.contains(i))
                ListOfEdges.add(i) ;
        }
        List<Integer> ans = new ArrayList<>() ;
        Map<Integer , Boolean> visited = new HashMap<>() ;
        for(int i = 0 ; i < vertex ; i++)
            visited.put(i,false) ;
        makeAdjList(edges , vertex) ;
        // traverse all components of G ->
        for(int i : ListOfEdges){
            if(!visited.get(i))
                _apply_dfs_(visited , ans , i) ;
        }
        return ans ;
    }

    // actual dfs function --> Recursive approach
    private void _apply_dfs_(Map<Integer , Boolean> visited , List<Integer> ans , int i){
        ans.add(i) ;
        visited.put(i , true) ;
        for(int value : adjList[i]){
            if(!visited.get(value))
                _apply_dfs_(visited , ans , value);
        }
    }



    // Making adjacency list -->
    public void makeAdjList(List<Pair> edges , int vertex) {
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



    // custom class pair to maintain two nodes of an edge -->
    static class Pair{
        int first ;
        int second ;

        public Pair() {
        }

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }
}
