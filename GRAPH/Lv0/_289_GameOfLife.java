import java.util.Arrays;

public class _289_GameOfLife {
    public static void main(String[] args) {
        solve_289.gameOfLife(new int[][]{
                {0 , 1 , 0} ,
                {0 , 0 , 1} ,
                {1 , 1 , 1} ,
                {0 , 0 , 0}
        });
        solve_289.gameOfLife(new int[][]{
                {1 , 1 } ,
                {1 , 0 }
        });
    }
}
class solve_289 {
    private static int[] delRow = new int[]{1, 0, -1, 0, 1, -1, 1, -1} ;
    private static int[] delCol = new int[]{0, -1, 0, 1, 1, -1, -1, 1} ;
    public static void gameOfLife(int[][] board) {
        int index = 0 ;
        int row = board.length;
        int col = board[0].length ;
        int[][] copy = new int[row][col] ;
        for (int[] arr : board)
            copy[index++] = arr.clone() ;
        for (int i = 0 ; i < row ; i ++){
            for (int j = 0 ; j < col ; j ++){
                board[i][j] = nextGen(i,j,copy) ;
            }
        }




        for (int[] arr : board)
            System.out.println(Arrays.toString(arr));

    }
    private static int nextGen(int i , int j , int[][] copy){
        int initial = copy[i][j] ;
        int count = 0 ;
        int[] updated = new int[8] ;
        Arrays.fill(updated , -1);
        for (int index = 0 ; index < 8 ; index ++){
            int nrow = i + delRow[index] ;
            int ncol = j + delCol[index] ;
            if(nrow >= 0 && nrow < copy.length && ncol >= 0 && ncol < copy[0].length){
                updated[index] = copy[nrow][ncol] ;
            }
        }
        for (int val : updated){
            if(val == 1)
                count++ ;
        }
        if (copy[i][j] == 1){
            //
            if(count == 2 || count == 3)
                return 1 ;
            else if(count < 2 || count > 3)
                return 0 ;
        }
        else{
            //
            if(count == 3)
                return  1 ;
        }
        return initial ;
    }
}