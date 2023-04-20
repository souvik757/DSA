import java.math.BigInteger;

public class SOLVEDAY2 {
    // QUES 14 Longest Common Prefix
    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0) {
            return "";
        }
        String StringMatcher = strs[0] ;
        for ( int i = 0 ; i < strs.length ; i ++) {
            while ( strs[i].indexOf(StringMatcher) != 0 ) {
                StringMatcher = StringMatcher.substring(0 , StringMatcher.length() - 1) ;
                if ( StringMatcher.length() == 0 ) return "";
            }
        }
        return StringMatcher ;
    }
    // QUES 43 Multiply String
    public String multiply(String num1, String num2) {
        BigInteger A = new BigInteger(num1) ;
        BigInteger B = new BigInteger(num2) ;
        BigInteger ANSWER = A.multiply(B) ;
        return ANSWER.toString() ;
    }
}
