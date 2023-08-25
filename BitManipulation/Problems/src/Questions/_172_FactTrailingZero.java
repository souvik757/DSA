package Questions;

public class _172_FactTrailingZero {
    /**
     * Number of trailing zero's at the end of n! can be calculated as summation of
     * => n/5^i
     * where , i ranges from 1 to log(5)n .
     * if we break it ,
     * ---> n/5 + n/5^2 + n/5^3 + n/5^4 + . . . . + n/n , as 5^log(5)n = n
     * so , clearly end term is 1 , each term has to be > 1 .(condition driven in while loop)
     * @param n
     * @return no. of trailing 0's at the end of n!
     */
    public int trailingZeroes(int n){
        int sum = 0 ;
        while (n > 0){
            n = n/5 ;
            sum = sum + n ;
        }

        return sum ;
    }
}
