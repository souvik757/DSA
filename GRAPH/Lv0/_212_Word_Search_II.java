import java.util.* ;
public class _212_Word_Search_II {
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
        int t = sc.nextInt() ;
        String[] words = new String[t] ;
        for (int i = 0 ; i < t ; i ++){
            words[i] = sc.next() ;
        }
        for (char[] ch : grid){
            System.out.println(Arrays.toString(ch));
        }
        bruteForce_solve_212 obj = new bruteForce_solve_212() ;
        System.out.println(obj.findWords(grid,words));
    }
}
//class solve_212 {
//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> answers = new ArrayList<>() ;
//
//        return answers ;
//    }
//}
class bruteForce_solve_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> answers = new ArrayList<>() ;
        boolean[][] visited = new boolean[board.length][board[0].length] ;
        for (String str : words){
            for (int i = 0 ; i < board.length ; i ++){
                for (int j = 0 ; j < board[0].length ; j ++){
                    if(board[i][j] == str.charAt(0) && hasFound(i,j,0,board,visited,str)){
                        answers.add(str) ;
                    }
                }
            }
        }
        return answers ;
    }//O(No. of Strings*(m*n))
    private boolean hasFound(int i,int j ,int index ,char[][] board ,boolean[][] visited ,String word){
        if(index == word.length())
            return true ;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length
                 || board[i][j] != word.charAt(index) || visited[i][j])
            return false ;
        visited[i][j] = true ;
        boolean found = hasFound(i+1,j,index+1,board,visited,word) ||
                        hasFound(i,j-1,index+1,board,visited,word) ||
                        hasFound(i-1,j,index+1,board,visited,word) ||
                        hasFound(i,j+1,index+1,board,visited,word)  ;
        visited[i][j] = false ;
        return found ;
    }
}