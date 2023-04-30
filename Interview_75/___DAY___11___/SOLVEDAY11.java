import java.util.*;

public class SOLVEDAY11 {
    // QUES 210 . Course Schedule II
    private boolean IsCycle ;
    private LinkedList<Integer>[] adjList ;
    private void MakeAdjList(int[][] edges , int Vertex) {
        adjList = new LinkedList[Vertex] ;
        for (int i = 0 ; i < Vertex ; i ++)
            adjList[i] = new LinkedList<>() ;
        for (int i = 0 ; i < edges.length ; i ++) {
            adjList[edges[i][1]].add(edges[i][0]) ;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0)
            return edgecase(numCourses) ;
        MakeAdjList(prerequisites,numCourses) ;
        int N = numCourses ;
        Map<Integer , Boolean> visited = new HashMap<>() ;
        Map<Integer , Boolean> adjvisited = new HashMap<>() ;
        for(int i = 0 ; i < N ; i++){
            visited.put(i,false) ;
            adjvisited.put(i,false) ;
        }
        boolean[] VISITED = new boolean[numCourses] ;
        List<Integer> list = new ArrayList<>() ;
        for(int i = 0 ; i < N ; i++){
            if(!visited.get(i)){
                boolean cycle = _is_cyclic_(i,visited,adjvisited) ;
                if(cycle){
                    return new int[]{} ;
                }
            }
        }
        // Not cyclic :::
        for (int i = 0 ; i < N ; i ++) {
            if (!VISITED[i])
                MakeArray(i,list,VISITED);
        }
        int[] ANSWER = new int[N] ;
        int n = N-1 ;
        for (int i : list)
            ANSWER[n--] = i ;
        return ANSWER ;
    }
    private void MakeArray(int src , List<Integer> list, boolean[] visited) {
        visited[src] = true ;
        for (int neighbour : adjList[src]) {
            if (!visited[neighbour])
                MakeArray(neighbour,list,visited) ;
        }
        list.add(src) ;
    }

    private boolean _is_cyclic_(int i, Map<Integer, Boolean> visited, Map<Integer, Boolean> adjvisited) {
        visited.put(i,true) ;
        adjvisited.put(i,true) ;
        for(int neighbour : adjList[i]){
            if(neighbour == -1) continue ;
            if(!visited.get(neighbour)){
                boolean cycle = _is_cyclic_(neighbour,visited,adjvisited) ;
                if(cycle)
                    return true ;
            }
            else if(adjvisited.get(neighbour)){ // && visited.get(neighbour) == true
                return true ;
            }
        }
        adjvisited.put(i,false) ;
        return false ;
    }

    private int[] edgecase(int Vertex) {
        int[] ans = new int[Vertex] ;
        for (int i = 0 ; i < Vertex ; i ++)
            ans[i] = i ;
        return ans;
    }

    // QUES 815 . Bus Routes
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for (int i = 0 ; i < routes.length ; i ++) {
            for (int j = 0 ; j < routes[i].length ; j ++) {
                map.putIfAbsent(routes[i][j] , new ArrayList<>()) ;
                map.get(routes[i][j]).add(i) ;
            }
        }
        HashSet<Integer> visitedBuses = new HashSet<>() ;
        Queue<Integer> BusStops = new LinkedList<>() ;
        BusStops.add(source) ;

        int NumberOfBuses = 0 ;

        while (!BusStops.isEmpty()) {
            int size = BusStops.size() ;
            for (int i = 0 ; i < size ; i ++) {
                int frontbusstop = BusStops.remove() ;
                if(frontbusstop == target)
                    return NumberOfBuses ;
                List<Integer> stops = map.get(frontbusstop) ;
                for (int currentStop : stops) {
                    if(visitedBuses.contains(currentStop))
                        continue ;
                    visitedBuses.add(currentStop) ;
                    for (int j = 0 ; j < routes[currentStop].length ; j ++) {
                        BusStops.add(routes[currentStop][j]) ;
                    }
                }
            }
            NumberOfBuses++ ;
        }

        return -1 ;
    }
}
