public class _74_search2DMatrix {
    public static void main(String[] args) {
        SOLVEDAY8 object = new SOLVEDAY8() ;
        System.out.println(object.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        } , 3));
        System.out.println(object.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        } , 13));
    }
}
