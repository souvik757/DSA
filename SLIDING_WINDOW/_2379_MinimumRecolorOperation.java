public class _2379_MinimumRecolorOperation {
    public static void main(String[] args) {
        System.out.println(SOLVE_2379.minimumRecolors("WBBWWBBWBW" , 7)) ;
        System.out.println(SOLVE_2379.minimumRecolors("WBWBBBW"    , 2)) ;
        System.out.println(SOLVE_2379.minimumRecolors("BWWWBB"     , 6)) ;
    }
}
class SOLVE_2379{
    public static int minimumRecolors(String blocks, int k) {
        int i = 0 ;
        char[] Blocks = blocks.toCharArray() ;
        int MinCounter = Integer.MAX_VALUE ;

        while (i < Blocks.length-k){
            int j = i ;
            int counter = 0 ;
            while (j < i+k){
                if(Blocks[j] == 'W')
                    counter++ ;
                j ++ ;
            }
            MinCounter = Math.min(MinCounter , counter) ;
            i ++ ;
        }

        return (MinCounter == Integer.MAX_VALUE) ? 0 : MinCounter ;
    }
}

// -- form consecutive Black Rock --

// W B B W W B B W B W           k = 7
// 0 1 2 3 4 5 6 7 8 9

// W B W B B B W                 k = 2
// 0 1 2 3 4 5 6

// B W W W B B                   k = 6
// 0 1 2 3 4 5
