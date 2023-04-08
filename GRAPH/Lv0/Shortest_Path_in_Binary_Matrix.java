import java.util.*;

public class Shortest_Path_in_Binary_Matrix {
    public static void main(String[] args) {
        solutionG9 object = new solutionG9() ;
        System.out.println(object.shortestPathBinaryMatrix(new int[][]{
                {0,0,0} ,
                {1,1,0} ,
                {1,1,0}
        }));
    }
}
class solutionG9{
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] distance = new int[grid.length][grid.length] ;
        Queue<pairs<Integer,Integer,Integer>> queue = new LinkedList<>() ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                distance[i][j] = (int) 1e9 ;
            }
        }
        distance[0][0] = 0 ;
        if(grid[0][0] != 0 || grid[grid.length-1][grid.length-1] != 0) return -1 ;
        queue.add(new pairs<>(0,0,0)) ;
        while(!queue.isEmpty()){
            int row = queue.peek().row ;
            int col = queue.peek().column ;
            int dist = queue.peek().distance ;
            queue.remove() ;
            int[] delRow = new int[]{-1,0,1,0,-1,1,1,-1} ;
            int[] delCol = new int[]{0,1,0,-1,1,1,0,-1} ;
            for(int i = 0 ; i< 8 ; i ++){
                int R = row + delRow[i] ;
                int C = col + delCol[i] ;
                if(R >= 0 && R < grid.length && C >= 0 && C < grid.length && grid[R][C] == 0 && dist+1 < distance[R][C]){
                    distance[R][C] = dist + 1 ;
                    if(R == grid.length-1 && C == grid.length-1) return dist+1 ;
                    queue.add(new pairs<>(R,C,dist+1)) ;
                }
            }
        }
        return -1 ;
    }
}
