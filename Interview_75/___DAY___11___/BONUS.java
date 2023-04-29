import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Leetcode QUES 207. Course Scheduler :::
public class BONUS {
    public static void main(String[] args) {
        solution object = new solution() ;
        System.out.println("Is possible : "+object.canFinish(2 , new int[][]{
                {1,0}
        }));
        System.out.println("Is possible : "+object.canFinish(2 , new int[][]{
                {1,0} ,
                {0,1}
        }));
    }
}
class solution{
    private LinkedList<Integer>[] adjList ;
    private void MakeAdjList(int[][] edges , int Vertex) {
        adjList = new LinkedList[Vertex] ;
        for (int i = 0 ; i < Vertex ; i ++)
            adjList[i] = new LinkedList<>() ;
        for (int i = 0 ; i < edges.length ; i ++) {
            adjList[edges[i][1]].add(edges[i][0]) ;
        }
        for (int i = 0 ; i < Vertex ; i ++) {
            if (adjList[i].isEmpty())
                adjList[i].add(-1) ;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        MakeAdjList(prerequisites,numCourses) ;
        int N = numCourses ;
        Map<Integer , Boolean> visited = new HashMap<>() ;
        Map<Integer , Boolean> adjvisited = new HashMap<>() ;
        for(int i = 0 ; i < N ; i++){
            visited.put(i,false) ;
            adjvisited.put(i,false) ;
        }
        for(int i = 0 ; i < N ; i++){
            if(!visited.get(i)){
                boolean cycle = _is_cyclic_(i,visited,adjvisited) ;
                if(cycle){
                    return false ;
                }
            }
        }
        return true ;
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
}
