package NQUEEN;
import java.util.* ;
public class _51_52_NQueens {
    public static void main(String[] args) {
        SOLVE_51 object1 = new SOLVE_51() ;
        SOLVE_52 object2 = new SOLVE_52() ;
        System.out.println(object1.solveNQueens(4));
        System.out.println("Number Of Valid Layouts : " +object2.NumberOfValidLayout(4));
    }
}
class SOLVE_52{
    public int NumberOfValidLayout(int n){
        SOLVE_51 object = new SOLVE_51() ;
        return object.solveNQueens(n).size() ;
    }
}
class SOLVE_51 {
    private List<List<String>> answer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] Board = new char[n][n];
        for (char[] ch : Board)
            Arrays.fill(ch, '.');
//        for (char[] ch : Board)
//            System.out.println(Arrays.toString(ch));
        Fill(0, n, Board);
        return answer;
    }

    private void Fill(int col, int n, char[][] Board) {
        if (col == n) {
            List<String> layout = new ArrayList<>();
            for (char[] ch : Board){
                String str = new String(ch);
                layout.add(str);
            }
            answer.add(new ArrayList<>(layout));
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(i,col , Board)) {
                Board[i][col] = 'Q';
                Fill(col + 1, n, Board);
                Board[i][col] = '.';
            }
        }
    }

    private Boolean isSafe(int i, int j, char[][] Board) {
        int store_row = i;
        int store_col = j;

        while (i >= 0 && j >= 0) {
            if (Board[i][j] == 'Q')
                return false;
            i --;
            j --;
        }

        i = store_row;
        j = store_col;
        while (j >= 0) {
            if (Board[i][j] == 'Q')
                return false;
            j --;
        }

        i = store_row;
        j = store_col;
        while (i < Board.length && j >= 0) {
            if (Board[i][j] == 'Q')
                return false;
            i ++;
            j --;
        }

        return true;
    }
}
