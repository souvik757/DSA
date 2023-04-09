import java.util.LinkedList;
import java.util.Queue;

public class Minimum_visited_cell {
    public static void main(String[] args) {
        solutionWEEKLY object = new solutionWEEKLY() ;
        System.out.println(object.shortestPathBinaryMatrix(new int[][]{
                {3,4,2,1},
                {4,2,3,1},
                {2,1,0,0},
                {2,4,0,0}
        }));
        System.out.println(object.shortestPathBinaryMatrix(new int[][]{
                {2,1,0},
                {1,0,0}
        }));
    }
}
class solutionWEEKLY{
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] visited = new int[grid.length][grid.length] ;
        int[][] distance = new int[grid.length][grid.length] ;
        Queue<pairs<Integer,Integer,Integer>> queue = new LinkedList<>() ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                distance[i][j] = (int) 1e9 ;
            }
        }
        distance[0][0] = 0 ;
        queue.add(new pairs<>(0,0,0)) ;
        while(!queue.isEmpty()){
            int row = queue.peek().row ;
            int col = queue.peek().column ;
            int dist = queue.peek().distance ;
            queue.remove() ;
            int[] delRow = new int[row+grid[row][col]] ;
            int[] delCol = new int[col+grid[row][col]] ;
            int Rindex = 0 ;
            int Cindex = 0 ;
            for(int rowIndex = row+1 ; rowIndex <= row+grid[row][col] ; rowIndex++)
                delRow[Rindex++] = row + rowIndex ;
            for(int colIndex = col+1 ; colIndex <= col+grid[row][col] ; colIndex++)
                delCol[Cindex++] = col + colIndex ;
            Pair<Integer, int[]> R = new Pair<>(row,delCol) ;
            Pair<int[], Integer> C = new Pair<>(delRow,col) ;
            int nRow , nCol ;
            int _c_index = 0 , _r_index = 0 ;
            for(int i = 0 ; i < 2 ; i ++){
                if(i == 0)
                {
                    while (_r_index < delCol.length){
                        nRow = R.getRow() ;
                        nCol = R.getColumn()[_r_index++] ;
                        if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid.length && visited[nRow][nCol] == 0
                                && dist+1 < distance[nRow][nCol]){
                            visited[nRow][nCol] = 1 ;
                            if(nRow == grid.length-1 && nCol == grid.length-1) return dist+1+1 ;
                            distance[nRow][nCol] = dist + 1 ;
                            queue.add(new pairs<>(nRow,nCol,dist+1)) ;
                        }
                    }
                }
                if(i == 1)
                {
                    while (_c_index < delRow.length){
                        nRow = C.getRow()[_c_index++];
                        nCol = C.getColumn();
                        if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid.length && visited[nRow][nCol] == 0
                                && dist+1 < distance[nRow][nCol]){
                            visited[nRow][nCol] = 1 ;
                            if(nRow == grid.length-1 && nCol == grid.length-1) return dist+1+1 ;
                            distance[nRow][nCol] = dist + 1 ;
                            queue.add(new pairs<>(nRow,nCol,dist+1)) ;
                        }
                    }
                }
            }
        }
        return -1 ;
    }
}
