public class _79_WordSearch {
    public static void main(String[] args) {
        solve_79 object = new solve_79() ;
        System.out.println(object.exist(new char[][]{
                {'A' , 'B' , 'C' , 'E'} ,
                {'S' , 'F' , 'C' , 'S'} ,
                {'A' , 'D' , 'E' , 'E'}
        } , "ABCCED"));
        System.out.println(object.exist(new char[][]{
                {'A' , 'B' , 'C' , 'E'} ,
                {'S' , 'F' , 'C' , 'S'} ,
                {'A' , 'D' , 'E' , 'E'}
        } , "SEE"));
    }
}
class solve_79 {
    private boolean[][] visited ;
    public boolean exist(char[][] board , String word){
        int n = board.length ;
        int m = board[0].length ;
        visited = new boolean[n][m] ;
        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < m ; j ++){
                if(board[i][j] == word.charAt(0) && backTrack(board,i,j,word,0))
                    return true ;
            }
        }
        return false ;
    }
    private boolean backTrack(char[][] board, int i, int j, String word, int index){
        if(index == word.length())
            return true ;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
                 || board[i][j] != word.charAt(index) || visited[i][j])
            return false ;
        // visit current character
        // follow the furthest matching character sequence four directionally
        visited[i][j] = true ;
        boolean found = (backTrack(board,i+1,j,word,index+1)) ||
                        (backTrack(board,i,j-1,word,index+1)) ||
                        (backTrack(board,i-1,j,word,index+1)) ||
                        (backTrack(board,i,j+1,word,index+1)) ;
        // backtrack here
        visited[i][j] = false ;
        return found ;
    }
}