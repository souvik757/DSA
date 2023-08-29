package Problems;

import java.util.List ;
import java.util.ArrayList ;
public class _73_SetMatrixZero {
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
