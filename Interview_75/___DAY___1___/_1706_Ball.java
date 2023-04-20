import java.util.Arrays;

public class _1706_Ball {
    public static void main(String[] args) {
        SOLVEDAY1 object = new SOLVEDAY1() ;
        System.out.println(Arrays.toString(object.findBall(new int[][]
                {
                        { 1,  1,  1, -1, -1} ,
                        { 1,  1,  1, -1, -1} ,
                        {-1, -1, -1,  1,  1} ,
                        { 1,  1,  1,  1, -1} ,
                        {-1, -1, -1, -1, -1}
                })));
        System.out.println(Arrays.toString(object.findBall(new int[][]
                {
                        { 1,  1,  1,  1, -1, -1} ,
                        {-1,  1,  1,  1, -1,  1} ,
                        { 1, -1, -1, -1,  1,  1} ,
                        {-1, -1, -1,  1, -1, -1} ,
                        {-1,  1,  1, -1, -1, -1}
                })));
    }
}
