public class NumberOfClsedIslands {
    public static void main(String[] args) {
        Solution001 object = new Solution001() ;
        System.out.println(object.closedIsland(new int[][]{
                {0,0,1,0},
                {1,0,1,0},
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,1},
                {0,0,1,0}}));
    }
}
class Solution001 {
    public int closedIsland(int[][] grid) {
        int count = 0 ;
        boolean[][] visited = new boolean[grid.length][grid[0].length] ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 0 && !visited[i][j]) {
                    if (_is_closed_(i, j, grid,visited)) {
                        count++;
                    }
                }
            }
        }
        return count ;
    }
    private boolean _is_closed_(int i , int j ,int[][] grid, boolean[][] visited){
        if(i>=grid.length||j>=grid[0].length||i<0||j<0)return false;
        if(grid[i][j]==1||visited[i][j])return true;

        visited[i][j]=true;
        boolean down = _is_closed_(i+1,j,grid,visited);
        boolean right = _is_closed_(i,j+1,grid,visited);
        boolean left = _is_closed_(i,j-1,grid,visited);
        boolean up = _is_closed_(i-1,j,grid,visited);

        return up && down && left && right ;
    }
}
