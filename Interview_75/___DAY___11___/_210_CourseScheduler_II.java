import java.util.Arrays;

public class _210_CourseScheduler_II {
    public static void main(String[] args) {
        SOLVEDAY11 object = new SOLVEDAY11() ;
        int[] arr = object.findOrder(2,
                new int[][]{{1, 0}}
        ) ;// [0 , 1]
        System.out.println(Arrays.toString(arr));
        int[] ans = object.findOrder(4,
                new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}
        ) ;// [0, 2, 1, 3]
        System.out.println(Arrays.toString(ans));
        int[] ANS = object.findOrder(2,
                new int[][]{}
        ) ;// [0]
        System.out.println(Arrays.toString(ANS));
        int[] ANSWER = object.findOrder(2 , new int[][]{
                {0 , 1}
        }) ;
        System.out.println(Arrays.toString(ANSWER));
    }
}
