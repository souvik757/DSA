// Warning : Crazy tricky !!
import java.util.*;

public class Shortlest_path_with_altering_color {
    public static void main(String[] args) {
        solutionG19 object = new solutionG19() ;
        System.out.println(Arrays.toString(object.shortestAlternatingPaths(
                3, new int[][]{{0, 1}}, new int[][]{{2, 1}}
        ))) ;
        System.out.println(Arrays.toString(object.shortestAlternatingPaths(
                3, new int[][]{{0, 1}}, new int[][]{{1, 2}}
        ))) ;
        System.out.println(Arrays.toString(object.shortestAlternatingPaths(
                7,
                new int[][]{{0,1}, {0,4}, {1,2}, {2,3}, {5,6}},
                new int[][]{{0,6}, {1,3}, {1,5}, {4,3}}
        ))) ;
    }
}
class solutionG19{
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {


        LinkedList<Integer>[] adjListRed = new LinkedList[n] ;
        LinkedList<Integer>[] adjListBlue = new LinkedList[n] ;
        for(int i = 0 ; i < n ; i++) {
            adjListRed[i]  = new LinkedList<>();
            adjListBlue[i] = new LinkedList<>();
        }
        for(int[] edges : redEdges){
            adjListRed[edges[0]].add(edges[1]) ;
        }
        for(int[] edges : blueEdges){
            adjListBlue[edges[0]].add(edges[1]) ;
        }

        int[][] distance = new int[n][2] ;
        for(int i = 0 ; i < n ; i++)
            Arrays.fill(distance[i] , -1) ;

        Queue<int[]> queue = new LinkedList<>() ;
        // 0 for Red  &  1 for Blue .
        queue.offer(new int[]{0 , 0}) ;
        queue.offer(new int[]{0 , 1}) ;
        distance[0][0] = 0 ;
        distance[0][1] = 0 ;
        while (!queue.isEmpty()){
            int[] front = queue.poll() ;
            int node    = front[0] ;
            int color   = front[1] ;
            List<Integer> adjList = color == 0 ? adjListBlue[node] : adjListRed[node] ;
            for(int neighbors : adjList){
                int nextColor = color == 0 ? 1 : 0 ;
                if(distance[neighbors][nextColor] == -1){
                    distance[neighbors][nextColor] = distance[node][color] + 1 ;
                    queue.offer(new int[]{neighbors , nextColor}) ;
                }
            }
        }

        int[] answer = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            if(distance[i][0] == -1 && distance[i][1] == -1)
                answer[i] = -1 ;
            else if(distance[i][0] == -1)
                answer[i] = distance[i][1] ;
            else if(distance[i][1] == -1)
                answer[i] = distance[i][0] ;
            else
                answer[i] = Math.min(distance[i][0] , distance[i][1]) ;
        }

        return answer ;
    }
}
