import java.util.LinkedList;
import java.util.PriorityQueue;

public class _2497_MaxStarSum {
    public static void main(String[] args) {
        SOLVE2497 object = new SOLVE2497() ;
        System.out.println("Max Star Sum : " + object.maxStarSum(new int[]{1,2,3,4,10,-10,-20} ,
                new int[][]{
                        {0 , 1} ,
                        {1 , 2} ,
                        {1 , 3} ,
                        {3 , 4} ,
                        {3 , 5} ,
                        {3 , 6}
                } ,
                2));
    }
}
class SOLVE2497{
    private int Max ;
    private LinkedList<Integer>[] adjList ;
    private void MakeAdj(int N , int[][] edges){
        adjList = new LinkedList[N] ;
        for (int i = 0 ; i < N ; i ++)
            adjList[i] = new LinkedList<>() ;
        for (int[] val : edges){
            adjList[val[0]].add(val[1]) ;
            adjList[val[1]].add(val[0]) ;
        }
    }
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Max = Integer.MIN_VALUE ;
        int Vertex = vals.length ;
        MakeAdj(Vertex , edges) ;
        for (int i = 0 ; i < Vertex ; i ++){
            PriorityQueue<Integer> queue = new PriorityQueue<>() ; // insertion happens in sorted ASCENDING order
            for (int neighbour : adjList[i]){
//                System.out.println("After deletion : "+queue);
                if(vals[neighbour] <= 0)
                    continue ;
                queue.add(vals[neighbour]) ;
                if(queue.size() > k)
                    queue.remove() ;
//                System.out.println("Before deletion : "+queue);
            }
            int sum = vals[i] ;
            while (!queue.isEmpty()){
                sum += queue.remove() ;
            }
//            System.out.println("Sum : "+sum);
            Max = Math.max(Max , sum) ;
//            System.out.println("Max Sum : "+Max);
        }
        return Max ;
    }
}
