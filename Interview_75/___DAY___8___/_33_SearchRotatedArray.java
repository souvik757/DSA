public class _33_SearchRotatedArray {
    public static void main(String[] args) {
        SOLVEDAY8 object = new SOLVEDAY8() ;
        System.out.println(object.search(new int[]{
                4,5,6,7,0,1,2
        } , 0));
        System.out.println(object.search(new int[]{
                4,5,6,7,0,1,2
        } , 3));
    }
}
/*
                     _   _
                   _  |   | _
                 _  | |   |  | _
                  | | |   |  |  | _
                  | | |   |  |  |  |
                  0 1 2   4  5  6  7
 */
