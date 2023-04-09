import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class longest_cycle_directed {
    public static void main(String[] args) {
        solutionG00E object = new solutionG00E() ;
        System.out.println(object.longestCycle(new int[]{3,3,4,2,3}));
        System.out.println(object.longestCycle(new int[]{3,3,4,2,3,6,7,8,5}));
    }
}
class solutionG00E{
    private int ans = 0 ;
    private LinkedList<Integer>[] adjList ;
    private void _makeAdj_(int[] edges){
        adjList = new LinkedList[edges.length] ;
        for(int i = 0 ; i < edges.length ; i++){
            adjList[i] = new LinkedList<>();
            adjList[i].add(edges[i]) ;

        }
    }
    public int longestCycle(int[] edges) {
        _makeAdj_(edges);
        Stack<Pair<Integer,Boolean>> visited = new Stack<>() ;
        Stack<Pair<Integer,Boolean>> adjvisited = new Stack<>() ;
        for(int i = 0 ; i < edges.length ; i++){
            visited.add(new Pair<>(i,false)) ;
            adjvisited.add(new Pair<>(i,false)) ;
        }
        int answer = Integer.MAX_VALUE ;
        for(int i = 0 ; i < edges.length ; i++){
            System.out.println(i);
            if(!visited.get(i).getColumn()){
                boolean cycle = _get_cycle_length_(i,visited,adjvisited) ;
                if(cycle){
                    answer = Math.min(answer , ans) ;
                }
            }
        }
        System.out.print("Length : ");
        return answer ;
    }

    private boolean _get_cycle_length_(int i, Stack<Pair<Integer,Boolean>> visited, Stack<Pair<Integer,Boolean>> adjvisited) {
        visited.add(new Pair<>(i,true)) ;
        adjvisited.add(new Pair<>(i,true)) ;
        for(int neighbour : adjList[i]){
            if(neighbour == -1) continue ;
            if(!visited.get(neighbour).getColumn()){
                boolean cycle = _get_cycle_length_(neighbour,visited,adjvisited) ;
                if(cycle)
                    return true ;
            }
            else if(adjvisited.get(neighbour).getColumn()){ // && visited.get(neighbour) == true
                int length = 0 ;
                while (visited.get(length).getRow() == neighbour){
                    length++ ;
                }
                ans = visited.size() - length ;
                System.out.println("ans -->"+ans);
                return true ;
            }
        }
        adjvisited.add(new Pair<>(i,false)) ;
        return false ;
    }
}
