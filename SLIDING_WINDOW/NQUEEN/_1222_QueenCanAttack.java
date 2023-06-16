package NQUEEN;
import java.util.* ;
public class _1222_QueenCanAttack {
    public static void main(String[] args) {
        SOLVE_1222 object = new SOLVE_1222() ;
        System.out.println(object.queensAttacktheKing(new int[][]{
                {0,1} ,
                {1,0} ,
                {4,0} ,
                {0,4} ,
                {3,3} ,
                {2,4}
        } , new int[]{0,0})) ;
    }
}
class SOLVE_1222{
    private final int row = 8 ;
    private final int col = 8 ;
    private int[][] Board  ;
    private List<List<Integer>> answer ;
    public SOLVE_1222() {
        answer = new ArrayList<>() ;
        Board = new int[row][col] ;
        for (int i = 0 ; i < row ; i ++){
            for(int j = 0 ; j < col ; j ++)
                Board[i][j] = -1 ;
        }
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        for (int[] coordinates : queens)
            Board[coordinates[0]][coordinates[1]] = 2 ;

        int row_src = king[0] ;
        int col_src = king[1] ;
        List<Integer> coordinates ;
        coordinates = new ArrayList<>() ;
        top(row_src , col_src , coordinates);
        coordinates = new ArrayList<>() ;
        topleft(row_src , col_src , coordinates);
        coordinates = new ArrayList<>() ;
        topright(row_src , col_src , coordinates);
        coordinates = new ArrayList<>() ;
        bottom(row_src , col_src , coordinates);
        coordinates = new ArrayList<>() ;
        bottomleft(row_src , col_src , coordinates);
        coordinates = new ArrayList<>() ;
        bottomright(row_src , col_src , coordinates);
        coordinates = new ArrayList<>() ;
        left(row_src , col_src , coordinates);
        coordinates = new ArrayList<>() ;
        right(row_src , col_src , coordinates);
        return answer ;
    }
    private void top(int i , int j , List<Integer> coordinates){
        if(Board[i][j] == 2) {
            coordinates.add(i) ;
            coordinates.add(j) ;
            answer.add(new ArrayList<>(coordinates)) ;
            return ;
        }
        int nrow = i - 1 ;
        int ncol = j ;
        if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col)
            top(nrow , ncol , coordinates);
    }
    private void bottom(int i , int j , List<Integer> coordinates){
        if(Board[i][j] == 2) {
            coordinates.add(i) ;
            coordinates.add(j) ;
            answer.add(new ArrayList<>(coordinates)) ;
            return ;
        }
        int nrow = i + 1 ;
        int ncol = j ;
        if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col)
            bottom(nrow , ncol , coordinates);
    }
    private void right(int i , int j , List<Integer> coordinates){
        if(Board[i][j] == 2) {
            coordinates.add(i) ;
            coordinates.add(j) ;
            answer.add(new ArrayList<>(coordinates)) ;
            return ;
        }
        int nrow = i ;
        int ncol = j + 1 ;
        if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col)
            right(nrow , ncol , coordinates);
    }
    private void left(int i , int j , List<Integer> coordinates){
        if(Board[i][j] == 2) {
            coordinates.add(i) ;
            coordinates.add(j) ;
            answer.add(new ArrayList<>(coordinates)) ;
            return ;
        }
        int nrow = i ;
        int ncol = j - 1 ;
        if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col)
            left(nrow , ncol , coordinates);
    }
    private void topright(int i , int j , List<Integer> coordinates){
        if(Board[i][j] == 2) {
            coordinates.add(i) ;
            coordinates.add(j) ;
            answer.add(new ArrayList<>(coordinates)) ;
            return ;
        }
        int nrow = i - 1 ;
        int ncol = j + 1 ;
        if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col)
            topright(nrow , ncol , coordinates);
    }
    private void topleft(int i , int j , List<Integer> coordinates){
        if(Board[i][j] == 2) {
            coordinates.add(i) ;
            coordinates.add(j) ;
            answer.add(new ArrayList<>(coordinates)) ;
            return ;
        }
        int nrow = i - 1 ;
        int ncol = j - 1 ;
        if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col)
            topleft(nrow , ncol , coordinates);
    }
    private void bottomright(int i , int j , List<Integer> coordinates){
        if(Board[i][j] == 2) {
            coordinates.add(i) ;
            coordinates.add(j) ;
            answer.add(new ArrayList<>(coordinates)) ;
            return ;
        }
        int nrow = i + 1 ;
        int ncol = j + 1 ;
        if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col)
            bottomright(nrow , ncol , coordinates);
    }
    private void bottomleft(int i , int j , List<Integer> coordinates){
        if(Board[i][j] == 2) {
            coordinates.add(i) ;
            coordinates.add(j) ;
            answer.add(new ArrayList<>(coordinates)) ;
            return ;
        }
        int nrow = i + 1 ;
        int ncol = j - 1 ;
        if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col)
            bottomleft(nrow , ncol , coordinates);
    }
}