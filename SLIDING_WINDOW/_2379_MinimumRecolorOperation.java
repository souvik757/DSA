public class _2379_MinimumRecolorOperation {
    public static void main(String[] args) {
        System.out.println(SOLVE_2379.minimumRecolors("WBBWWBBWBW" , 7)) ;
        System.out.println(SOLVE_2379.minimumRecolors("WBWBBBW"    , 2)) ;
        System.out.println(SOLVE_2379.minimumRecolors("BWWWBB"     , 6)) ;
        System.out.println(SOLVE_2379.minimumRecolors("WWBBBWBBBBBWWBWWWB"     , 16)) ;
    }
}

class SOLVE_2379{
    public static int minimumRecolors(String blocks, int K) {
        int right = 0 ;
        int left  = 0 ;
        int count = 0 ;
        int k = K - 1 ;
        int max = Integer.MAX_VALUE ;

        while( right < blocks.length() ) {
            if ( blocks.charAt(right) == 'W' )
                count++ ;
            if ( right == left + k ){
                max = Math.min(count,max);
                if( blocks.charAt(left) == 'W' ) // sliding towards right , if left point has W block then minus it .
                    count--;
                left++;
            }
            right++;
        }

        return max;
    }
}

// -- form consecutive Black Rock --

// W B B W W B B W B W           k = 7
// 0 1 2 3 4 5 6 7 8 9

// W B W B B B W                 k = 2
// 0 1 2 3 4 5 6

// B W W W B B                   k = 6
// 0 1 2 3 4 5

// i
// W W B B B W B B B B  B  W  W  B  W  W  W  B      k = 16 -> 15
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17          18
// j   2
// j == i + k - 1

//        int j = i ;
//        int counter = 0 ;
//        while (j < Blocks.length - k){
//            if(j == i + k){
//                MinCounter = Math.min(MinCounter , counter) ;
//                i = j ;
//                counter = 0 ;
//            }
//            if(blocks.charAt(j) == 'W')
//                counter++ ;
//            j++ ;
//        }