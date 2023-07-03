public class PlayerOfTheYear {
    public static void main(String[] args) {
        SOLVE_playerOfYear object = new SOLVE_playerOfYear() ;
        System.out.println(object.Player(3 , 4 , new int[][]{
                {9 , 3 , 4 , 6} ,
                {6 , 2 , 1 , 7} ,
                {1 , 4 , 5 , 7}
        }));
    }
}
class SOLVE_playerOfYear{
    private int player = -404 ;
    public int Player(int N , int M , int[][] linearGraph){
        int max = Integer.MIN_VALUE ;
        for (int i = 0 ; i < N ; i ++){ // O(N*M*N) ~ O(M*N^2)
            int count = 0 ;
            for (int j = 0 ; j < M ; j++){
                if (IsGreater(i,j,linearGraph))
                    count++ ;
            }
//            System.out.println((i+1)+" row -> "+count);
            if (count > max) {
                max = count;
                player = i ;
            }
        }
        return player+1 ;
    }
//  In a 2D graph , I need to know if value of a certain cell is greater than each cell in that same column .
    private boolean IsGreater(int i ,int j ,int[][] G) {
        int val = G[i][j] ;
        for (int index = 0 ; index < G.length ; index ++){
            if (G[index][j] < val){
                return false ;
            }
        }

        return true ;
    }
}