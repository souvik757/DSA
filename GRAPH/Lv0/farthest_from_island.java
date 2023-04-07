import java.util.LinkedList;
import java.util.Queue;

public class farthest_from_island {
    public static void main(String[] args) {
        solutionG7 object = new solutionG7() ;
        System.out.println(object.maxDistance(new int[][]{{1,0,1} ,{0,0,0} ,{1,0,1}}));
    }
}
class solutionG7{
    public int maxDistance(int[][] grid) {
        Queue<solve.Pair> queue = new LinkedList<>() ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1)
                    queue.add(new solve.Pair(i,j)) ;
            }
        }
        if(queue.isEmpty() || queue.size() == grid.length*grid[0].length)
            return -1 ;
        int answer = -1 ;
        while (!queue.isEmpty()){
            int length = queue.size() ;
            answer++ ;
            while (length-->0) {
                assert queue.peek() != null;
                int r = queue.peek().first;
                int c = queue.peek().second;
                queue.remove();
                int[] delRow = new int[]{-1, 0, 1, 0};
                int[] delCol = new int[]{0, 1, 0, -1};
                for (int i = 0; i < 4; i++) {
                    int R = r + delRow[i];
                    int C = c + delCol[i];
                    if (R >= 0 && R < grid.length && C >= 0 && C < grid[0].length && grid[R][C] == 0) {
                        grid[R][C] = 1;
                        queue.add(new solve.Pair(R, C));
                    }
                }
            }
        }
        return answer ;
    }
}
