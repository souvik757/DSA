
import java.util.Scanner;

public class _79_WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int m = sc.nextInt() ;
        int n = sc.nextInt() ;
        char[][] grid = new char[m][n] ;
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j ++){
                grid[i][j] = sc.next().charAt(0) ;
            }
        }

        String word = sc.next();
        solve_79 obj = new solve_79() ;
        System.out.println(obj.exist(grid , word));
    }
}
class solve_79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length ;
        int n = board[0].length ;
        boolean[][] visited = new boolean[m][n] ;

        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j ++){
                char ch = board[i][j] ;
                if(ch == word.charAt(0) && dfs(i,j,board,word,0 , visited)){
                    return true ;
                }
            }
        }
        return false ;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int index , boolean[][] visited) {
        if(index == word.length())
            return true ;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                visited[i][j] || board[i][j] != word.charAt(index))
            return false ;
        visited[i][j] = true ;
        boolean found = dfs(i-1,j ,board ,word ,index+1 ,visited) ||
                        dfs(i ,j+1,board ,word ,index+1 ,visited) ||
                        dfs(i+1,j ,board ,word ,index+1 ,visited) ||
                        dfs(i ,j-1,board ,word ,index+1 ,visited) ;
        visited[i][j] = false ;
        return found ;
    }
}