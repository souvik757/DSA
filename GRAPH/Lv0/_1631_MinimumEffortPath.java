import java.util.PriorityQueue;
import java.util.Queue;

public class _1631_MinimumEffortPath {
    public static void main(String[] args) {
        SOLVE1631 object = new SOLVE1631() ;
        System.out.println(object.minimumEffortPath(new int[][]{
                {1 , 2 , 2} ,
                {3 , 8 , 2} ,
                {5 , 3 , 5}
        }));
    }
}
class SOLVE1631{

    private int[] DelRow = new int[]{-1, 0, 1,  0} ;
    private int[] DelCol = new int[]{ 0, 1, 0, -1} ;
    public int minimumEffortPath(int[][] heights) {
        int Row = heights.length ;
        int Col = heights[0].length ;
        int[][] cost = new int[Row][Col] ;
        for (int i = 0 ; i < Row ; i ++)
            for (int j = 0 ; j < Col ; j ++)
                cost[i][j] = Integer.MAX_VALUE ;

        Queue<int[]> pqueue = new PriorityQueue<>((x,y)->x[2]-y[2]) ;
        pqueue.add(new int[]{0,0,0}) ;
        while (!pqueue.isEmpty()){
            int row = pqueue.peek()[0] ;
            int col = pqueue.peek()[1] ;
            int dist= pqueue.poll()[2] ;

            if(row == Row-1 && col == Col-1)
                return dist ;
            for (int i = 0 ; i < 4 ; i ++){
                int nextRow = row + DelRow[i] ;
                int nextCol = col + DelCol[i] ;
                if(nextRow < 0 || nextCol < 0 || nextRow >= Row || nextCol >= Col)
                    continue;
                int newDist = Math.max(Math.abs(heights[nextRow][nextCol]-heights[row][col]) , dist) ;
                if(newDist < cost[nextRow][nextCol])
                {
                    cost[nextRow][nextCol] = newDist ;
                    pqueue.add(new int[]{nextRow,nextCol,newDist}) ;
                }
            }
        }
        return -1 ;
    }
}
