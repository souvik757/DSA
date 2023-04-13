import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue ;

// Every Amazing problem has an Amazing solution . . . here it is for this one !
public class _01_matrix {
    public static void main(String[] args) {
        solutionG10 object = new solutionG10() ;
        int[][] answer = object.updateMatrix(new int[][]{
                {0,0,0} ,
                {0,1,0} ,
                {1,1,1}
        }) ;
        for(int[] i : answer)
            System.out.println(Arrays.toString(i)) ;
    }
}
class solutionG10{
    public int[][] updateMatrix(int[][] mat){
        boolean[][] visited = new boolean[mat.length][mat[0].length] ;
        Queue<pairs<Integer , Integer , Integer>> queue = new LinkedList<>() ;
        int[][] answer = new int[mat.length][mat[0].length] ;
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 0){
                    queue.add(new pairs<>(i,j,0)) ;
                    visited[i][j] = true ;
                }
            }
        }

        while(!queue.isEmpty()){
            int row = queue.peek().row ;
            int col = queue.peek().column ;
            int val = queue.poll().distance ;
            answer[row][col] = val ;
            int[] delRow = new int[]{-1,0,1,0} ;
            int[] delCol = new int[]{0,1,0,-1} ;
            for(int i = 0 ; i < 4 ; i++){
                int R = row+delRow[i] ;
                int C = col+delCol[i] ;

                if(R >= 0 && R < mat.length && C >= 0 && C < mat[0].length && !visited[R][C]) {
                    visited[R][C] = true;
                    queue.add(new pairs<>(R, C, val + 1));
                }
            }

        }

        return answer ;
    }
}
class pairs<K,V,D>{
    K row ;
    V column ;
    D distance ;

    public pairs() {
    }

    public pairs(K row, V column, D distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }

    public void add(K row , V column , D distance){
        this.row = row ;
        this.column = column ;
        this.distance = distance ;
    }
}
