import java.util.List;

public class _54_Spiral_Matrix {
    public static void main(String[] args) {
        SOLVEDAY1 object = new SOLVEDAY1() ;
        List<Integer> answer = object.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }) ;
        System.out.println(answer);
    }
}
