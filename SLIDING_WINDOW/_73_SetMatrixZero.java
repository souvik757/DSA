import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _73_SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2,0} ,
                {3,4,5,2} ,
                {1,3,1,5}
        } ;
        solve_73 obj = new solve_73() ;
        obj.setZeroes(matrix) ;
    }
}
class solve_73 {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>() ;
        for (int i = 0 ; i < matrix.length ; i ++){
            for (int j = 0 ; j < matrix[0].length ; j ++){
                if(matrix[i][j] == 0)
                    list.add(new int[]{i,j});
            }
        }
        for (int[] val : list){
            alter(val[0] , val[1] , matrix);
        }
    }
    private void alter(int i , int j , int[][] grid){
        int N = grid.length;
        int M = grid[0].length;
        for (int col = 0 ; col < M ; col ++)
            grid[i][col] = 0 ;
        for (int row  = 0 ; row < N ; row ++)
            grid[row][j] = 0 ;
    }
}