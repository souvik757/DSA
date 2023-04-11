import java.util.* ;

public class Number_of_Provinces {
	public static void main(String[] args){
		solutionG15 object = new solutionG15() ;
		System.out.println("Number of components : "+object.findCircleNum(new int[][]{
				{1,1,0,0,0,0} ,
				{1,1,1,0,0,0} ,
				{0,1,1,0,0,0} ,
				{0,0,0,1,1,0} ,
				{0,0,0,1,1,1} ,
				{0,0,0,0,1,1} ,
		})) ;
	}
}
class solutionG15{
    private LinkedList<Integer>[] adjList ;
	private void _make_ADJLIST_(int[][] Edges){
		adjList = new LinkedList[Edges.length] ;
		for(int i = 0 ; i < Edges.length ; i++){
			adjList[i] = new LinkedList<>() ;
			for(int j = 0 ; j < Edges.length ; j++){
				if(j != i && Edges[i][j] != 0){
					adjList[i].add(j) ;
				}
			}
			if(adjList[i].isEmpty())
				adjList[i].add(-1);
		}
	}
	public int findCircleNum(int[][] isConnected) {
		_make_ADJLIST_(isConnected) ;
		int counter = 0 ;
		for(int i = 0 ; i < isConnected.length ; i++){
			System.out.println(i+" -> "+adjList[i]) ;
		}
		Map<Integer,Boolean> visited = new HashMap<>() ;
		for(int i = 0 ; i < isConnected.length ; i++){
			visited.put(i,false) ;
		}
		for(int i = 0 ; i < isConnected.length ; i++){
			if(!visited.get(i)){
				counter++ ;
				_traverse_dfs_(i,visited) ;
			}
		}


		return counter ;
    }

	private void _traverse_dfs_(int i, Map<Integer, Boolean> visited) {
		visited.put(i,true) ;
		for(int neighbour : adjList[i]){
			if(neighbour == -1) continue ;
			if(!visited.get(neighbour))
				_traverse_dfs_(neighbour,visited);
		}
	}
}
