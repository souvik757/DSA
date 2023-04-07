import java.util.ArrayList;
import java.util.List;

public class pacific_atlantic_flow {
    public static void main(String[] args) {
        solutionG8 object = new solutionG8() ;
        System.out.println(object.pacificAtlantic(new int[][]{
                {1,2,2,3,5} ,
                {3,2,3,4,4} ,
                {2,4,5,3,1} ,
                {6,7,1,4,5} ,
                {5,1,1,2,4}
        }));
    }
}
class solutionG8{
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>() ;
        boolean[][] pacific = new boolean[heights.length][heights[0].length] ;
        boolean[][] atlantic = new boolean[heights.length][heights[0].length] ;


        for(int i = 0 ; i < heights.length ; i ++){
            for(int j = 0 ; j < heights[0].length ; j ++){
                if(i == 0 || j == 0)
                    verify_reach(i,j,heights,pacific,0);
                if(i == heights.length-1 || j == heights[0].length-1)
                    verify_reach(i,j,heights,atlantic,0) ;
            }
        }

        for(int i = 0 ; i < heights.length ; i++){
            for(int j = 0 ; j < heights[0].length ; j++){
                List<Integer> pairs = new ArrayList<>() ;
                boolean verify = pacific[i][j] && atlantic[i][j] ;
                if(verify) {
                    pairs.add(i);
                    pairs.add(j);
                    answer.add(new ArrayList<>(pairs)) ;
                }
            }
        }
        return answer ;
    }

    private void verify_reach(int r, int c, int[][] heights, boolean[][] ocean , int previous) {
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length ||
                ocean[r][c] || heights[r][c] <= previous)
            return ;

        ocean[r][c] = true ;

        int[] delRow = new int[]{-1,0,1,0} ;
        int[] delCol = new int[]{0,1,0,-1} ;

        for(int index = 0 ; index < 4 ; index++)
            verify_reach(r + delRow[index],c + delCol[index],heights,ocean,heights[r][c]);
    }
}
