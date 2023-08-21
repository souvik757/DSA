package Questions;

public class count1bits {
    /**
     *
     * @param N decimal number
     * @return number of 1 bit in binary representation
     */
    public int setBits(int N){
        int count = 0 ;
        while (N != 0){
            int bit = N & 1 ;
            if(bit == 1)
                count ++ ;
            N = N >> 1 ;
        }
        return count ;
    }
}