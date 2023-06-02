import java.util.List ;
import java.util.ArrayList ;
public class _54_Spiral_Matrix {
    SOLVE_54 object = new SOLVE_54() ;

}
class SOLVE_54{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>() ;
        int row = matrix.length ;
        int col = matrix[0].length ;

        int top = 0 , bottom = row - 1 ;
        int left = 0 , right = col - 1 ;

        while (top <= bottom && left <= right){
            // right
            for (int i = left ; i <= right ; i ++){
                ans.add(matrix[top][i]) ;
            }
            top++ ;
            // down
            for (int i = top ; i <= bottom ; i ++){
                ans.add(matrix[i][right]) ;
            }
            right-- ;
            // left
            if(top <= bottom){
                for (int i = right ; i >= left ; i --){
                    ans.add(matrix[bottom][i]) ;
                }
                bottom-- ;
            }
            // up
            if(left <= right){
                for (int i = bottom ; i >= top ; i --){
                    ans.add(matrix[i][left]) ;
                }
                // go for next spiral
                left++ ;
            }
        }
        return ans ;
    }
}