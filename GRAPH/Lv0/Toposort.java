import java.util.*;
// Using DFS :::
// using Kahn's algorithm :::
public class Toposort { // can onlt be performed in DAG (Directed Acyclic Graph)
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1} ,
                {2,1} ,
                {3,1} ,
                {1,4} ,
                {2,4}
        } ;
        int Vertex = 5 ;
        ToposortKahns object1 = new ToposortKahns() ;
        System.out.println(object1.GetToposort(Vertex , edges));





        //SOLVEToposortDFS object = new SOLVEToposortDFS() ;
        //System.out.println(object.GetToposort(Vertex , edges));
    }
}
class SOLVEToposortDFS {
    private LinkedList<Integer>[] adjList ;
    private void MakeAdj(int Vertex , int[][] edges){
        adjList = new LinkedList[Vertex] ;
        for (int i = 0 ; i < Vertex ; i++)
            adjList[i] = new LinkedList<>() ;
        for (int[] val : edges){
            adjList[val[0]].add(val[1]);
        }
    }
    public List<Integer> GetToposort(int vertex, int[][] edges) {
        MakeAdj(vertex , edges);
        Stack<Integer> stack = new Stack<>() ;
        boolean[] visited = new boolean[vertex] ;
        for (int i = 1 ; i < vertex ; i ++){
            if(!visited[i])
                toposort(i , visited , stack) ;
        }
        List<Integer> answer = new ArrayList<>() ;
        while (!stack.isEmpty()){
            answer.add(stack.pop()) ;
        }
        return answer ;
    }

    private void toposort(int src, boolean[] visited ,Stack<Integer> stack) {
        visited[src] = true ;
        for (int neighbour : adjList[src]){
            if(!visited[neighbour])
                toposort(neighbour , visited , stack);
        }
        stack.add(src) ;
    }
}
class ToposortKahns{
    private LinkedList<Integer>[] adjList ;
    private void MakeAdj(int Vertex , int[][] edges){
        adjList = new LinkedList[Vertex] ;
        for (int i = 0 ; i < Vertex ; i++)
            adjList[i] = new LinkedList<>() ;
        for (int[] val : edges){
            adjList[val[0]].add(val[1]);
        }
    }
    public List<Integer> GetToposort(int Vertex , int[][] edges){
        MakeAdj(Vertex , edges) ;
        int[] Indegre = new int[Vertex] ;
        for (int i = 0 ; i < Vertex ; i ++)
            Indegre[i] = 0 ;
        for(int[] val : edges)
            Indegre[val[1]]++ ;
        Queue<Integer> queue = new LinkedList<>() ;
        for (int i = 0 ; i < Vertex ; i ++){
            if(Indegre[i] == 0)
                queue.add(i) ;
        }

        List<Integer> list = new ArrayList<>() ;
        while (!queue.isEmpty()){
            int front  = queue.poll() ;

            list.add(front) ;
            for (int neighbour : adjList[front]){
                Indegre[neighbour]-- ;
                if(Indegre[neighbour] == 0)
                    queue.add(neighbour) ;
            }
        }
        return list ;
    }
}

