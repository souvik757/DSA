package Questions;

public class countBitsFlip {
    public int countFlips(int a , int b){
        int xorRes = a ^ b ;
        int c = 0 ;
        while (xorRes != 0){
            if((xorRes & 1) == 1)
                c ++ ;
            xorRes >>= 1 ;
        }

        return c ;
    }
}
