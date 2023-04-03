import java.util.Arrays;

public class _flood_fill_ {
    public static void main(String[] args) {
        Solution solution = new Solution() ;
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}} ;
        image = solution.floodFill(image , 1, 1, 2) ;
        for (int i = 0 ; i < image.length ; i++)
            System.out.println(Arrays.toString(image[i]));
    }
}
class Solution{
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial_color = image[sr][sc] ;
        int[] delRow = new int[]{-1, 0 , 1 ,  0} ;
        int[] delCol = new int[]{ 0, 1 , 0 , -1} ;
        if(initial_color != color)
            _fill_by_dfs_(sr,sc,image,initial_color,color,delRow , delCol);
    return image ;
    }
    private void _fill_by_dfs_(int sr,int sc,int[][] image,
                               int initial_color,int color,
                               int[] delRow,int[] delCol){
        if(image[sr][sc] == initial_color) {
            image[sr][sc] = color;
            int R = image.length;
            int C = image[0].length;
            for (int i = 0; i < 4; i++) {
                int row = sr + delRow[i];
                int col = sc + delCol[i];
                if (row >= 0 && row < R && col >= 0 && col < C)
                    _fill_by_dfs_(row, col, image, initial_color, color, delRow, delCol);
            }
        }
    }
}
