package Questions;

import java.math.BigInteger;

public class _201_BitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int answer = right ;
        while (right > left){
            answer = right & (right-1) ;
            right = answer ;
        }
        return answer ;
    }
}
