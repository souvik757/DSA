import java.util.Arrays;

public class _135_candy {
    public static void main(String[] args) {
        solve_135 object = new solve_135() ;
        System.out.println(object.candy(new int[]{1,2,1,0,5}));
        System.out.println(object.candy(new int[]{1,0,2}));
        System.out.println(object.candy(new int[]{1,2,3,4,5}));
        System.out.println(object.candy(new int[]{1,3,4,5,2}));
    }
}
class solve_135 {
    public int candy(int[] ratings) {
        int minCandy = 0 ;
        int n = ratings.length ;
        int[] candies = new int[n] ;
        Arrays.fill(candies , 1) ;
        System.out.println("Initialize : "+Arrays.toString(candies));
        for (int i = 1 ; i < n ; i ++){
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1 ;
        }
        System.out.println("-> : "+Arrays.toString(candies));
        for (int i = n-2 ; i >= 0 ; i --){
            if(ratings[i] > ratings[i+1]){
                if(candies[i] <= candies[i+1])
                    candies[i] = candies[i+1] + 1 ;
            }
        }
        System.out.println("<- : "+Arrays.toString(candies));
        for (int val : candies)
            minCandy += val ;
        return minCandy ;
    }
}