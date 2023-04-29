public class _815_BusRoutes {
    public static void main(String[] args) {
        SOLVEDAY11 object = new SOLVEDAY11() ;
        System.out.println(object.numBusesToDestination(new int[][]{
                {1, 2, 7} ,
                {3, 6, 7}
        } , 1 , 6)); // 2
        System.out.println(object.numBusesToDestination(new int[][]{
                {7, 12} ,
                {4,  5, 15} ,
                {6} ,
                {15, 19} ,
                { 9, 12, 13}
        } , 15 , 12)); // -1
    }
}
