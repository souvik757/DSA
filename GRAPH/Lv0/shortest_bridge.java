import java.util.LinkedList;
import java.util.Queue;

public class shortest_bridge {
    public static void main(String[] args) {
        solutionG11 object = new solutionG11() ;
        System.out.println(object.shortestBridge(new int[][]{
                {0,1,0,0} ,
                {0,1,0,0} ,
                {0,1,0,0} ,
                {1,1,0,0} ,
                {0,0,0,1} ,
                {0,0,1,1}
        }));
        System.out.println(object.shortestBridge(new int[][]{
                {1,1,1,1,1} ,
                {1,0,0,0,1} ,
                {1,0,1,0,1} ,
                {1,0,0,0,1} ,
                {1,1,1,1,1}
        }));
    }
}
class solutionG11{
    private int[] delRow = new int[]{-1,0,1,0} ;
    private int[] delCol = new int[]{0,1,0,-1} ;
    public int shortestBridge(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        boolean indicate = false ;
        boolean[][] visited = new boolean[n][m] ;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            if(indicate) break ;
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    _dfs_(i,j,grid,visited,queue) ;
                    indicate = true ;
                    break ;
                }
            }
        }
        int nodesToalter = 0 ;
        while(!queue.isEmpty()){
            int length = queue.size() ;
            while(length-->0){
                int row = queue.peek().row ;
                int col = queue.peek().column ;
                queue.remove() ;
                for(int i = 0 ; i < 4 ; i++){
                    int R = row + delRow[i] ;
                    int C = col + delCol[i] ;
                    if(R>=0&&R<n&&C>=0&&C<m){
                        if(!visited[R][C] && grid[R][C] == 1)
                            return nodesToalter ;
                        else if(!visited[R][C] && grid[R][C] == 0)
                        {
                            queue.add(new Pair<>(R,C)) ;
                            visited[R][C] = true ;
                        }
                    }
                }
            }
            nodesToalter++ ;
        }
        return -1 ;
    }

    private void _dfs_(int i, int j, int[][] grid, boolean[][] visited, Queue<Pair<Integer, Integer>> queue) {
        if(i<0||i>= grid.length||j<0||j>= grid[0].length) return ;
        if(!visited[i][j] && grid[i][j] == 1)
            queue.add(new Pair<>(i,j)) ;
        else
            return ;
        visited[i][j] = true ;
        for(int index = 0 ; index < 4 ; index++){
            int row = i + delRow[index] ;
            int col = j + delCol[index] ;
            _dfs_(row,col,grid,visited,queue) ;
        }
    }
}
class Pair<K,V>{
    K row ;
    V column ;

    public Pair() {
    }

    public Pair(K row, V column) {
        this.row = row;
        this.column = column;
    }

    public K getRow() {
        return row;
    }

    public void setRow(K row) {
        this.row = row;
    }

    public V getColumn() {
        return column;
    }

    public void setColumn(V column) {
        this.column = column;
    }
}
