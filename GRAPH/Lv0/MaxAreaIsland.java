public class MaxAreaIsland {
    public static void main(String[] args) {
        _solution_ object = new _solution_() ;
        int[][] grid = new int[][]{ {1,1,0,1} , {0,1,0,0} , {0,1,0,1} , {0,0,0,1}} ;
        System.out.println(object.maxAreaOfIsland(grid));
    }
}
class _solution_ {

    int maxi=0;

    private boolean issafe(int i,int j,int[][]board,boolean[][]visited){

        return (i >= 0 && i < board.length) && (j >= 0 && j < board[0].length) && board[i][j] == 1 && !visited[i][j];

    }

    private int dfs(int i,int j,int[][]board,boolean[][]visited,int count){

        visited[i][j]=true;

        if(issafe(i+1,j,board,visited)){
            count+=1;
            count=dfs(i+1,j,board,visited,count);
        }
        if(issafe(i-1,j,board,visited)){
            count+=1;
            count=dfs(i-1,j,board,visited,count);
        }
        if(issafe(i,j+1,board,visited)){
            count+=1;
            count=dfs(i,j+1,board,visited,count);
        }
        if(issafe(i,j-1,board,visited)){
            count+=1;
            count=dfs(i,j-1,board,visited,count);
        }

        return count;

    }


    public int maxAreaOfIsland(int[][] grid) {

        boolean[][]visited=new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    maxi=Math.max(dfs(i,j,grid,visited,1),maxi);
                }
            }
        }

        return maxi;
    }
}
