import java.util.* ;
/*
 you can buy 1 candy form storage and get k candies for free .
 return [min max]
 where ,
        min - minimum amount to grab maximum candy
        max - maximum amount to grab maximum candy
 */
public class NCandiesGreedy {
    public static void main(String[] args) {
        solve_ object = new solve_() ;
        System.out.println(Arrays.toString(object.candyStore(new int[]{3,2,1,4} , 4 , 2)));
    }
}
class solve_{
    public int[] candyStore(int[] candies , int N , int k) {
        Arrays.sort(candies) ;
        int minimum = 0 , maximum = 0 , buy, free;
        // minimum amount
        buy = 0 ;
        free = N-1 ;
        while (buy <= free){
            minimum += candies[buy] ;
            buy ++ ;
            free -= k ;
        }
        // maximum amount
        buy = N-1 ;
        free = 0 ;
        while (free <= buy){
            maximum += candies[buy] ;
            buy -- ;
            free += k ;
        }

        return new int[]{minimum,maximum} ;
    }
}