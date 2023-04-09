import java.util.*;

public class _all_paths_directed_ {
    public static void main(String[] args) {
        solutionG13 object = new solutionG13() ;
        System.out.println(object.allPathsSourceTarget(new int[][]{
                {1,3,4} ,
                {2,3,4} ,
                {3} ,
                {4} ,
                {}
        }));
    }
}
class solutionG13{
    private LinkedList<Integer>[] adjList ;
    private List<Integer> _list_ ;
    private void MakeAdj(int[][] graph){
        adjList = new LinkedList[graph.length] ;
        for(int i = 0 ; i < graph.length ; i ++){
            adjList[i] = new LinkedList<>() ;
            int[] neighbours = graph[i] ;
            if(neighbours.length == 0){
                adjList[i].add(-1) ;
            }else {
                for (int val : neighbours)
                    adjList[i].add(val);
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        MakeAdj(graph) ;
        _list_ = new ArrayList<>() ;
        List<List<Integer>> answer = new ArrayList<>() ;
        _list_.add(0) ;
        _get_paths_(0,answer,graph) ;

        return answer ;
    }

    private void _get_paths_(int i, List<List<Integer>> answer, int[][] graph) {
        if(i == graph.length-1){
            answer.add(new ArrayList<>(_list_)) ;
            return ;
        }
        for(int neighbor : adjList[i]){
            if(neighbor == -1)
                continue ;
            _list_.add(neighbor) ;
            _get_paths_(neighbor,answer,graph);
            _list_.remove(_list_.size() - 1) ; // <backtrack> delete when going back or every neighbor of a certain node is visited .
        }
    }
}
