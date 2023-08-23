package Questions;

import java.util.Arrays;

public class _338_CountingBits {
    public int[] countBits(int n){
        DecimalToBinary object = new DecimalToBinary() ;
        int[] answer = new int[n+1] ;
        for (int i = 0 ; i <= n ; i ++) {
            String binStr = object.toBinary(i) ;
            String convertedString = binStr.replaceAll("0" , "") ;
            answer[i] = convertedString.length() ;
        }
        return answer ;
    }
}
