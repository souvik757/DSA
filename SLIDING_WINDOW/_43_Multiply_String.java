import java.math.BigInteger;

public class _43_Multiply_String {
    public static void main(String[] args) {
        solutionS43 object = new solutionS43() ;
        System.out.println(object.multiply("123" , "456")) ;
        System.out.println(object.multiply("2"   , "3"  )) ;
    }
}
class solutionS43{
    public String multiply(String num1, String num2) {
        BigInteger A = new BigInteger(num1) ;
        BigInteger B = new BigInteger(num2) ;
        BigInteger ANSWER = A.multiply(B) ;
        return ANSWER.toString() ;
    }
}
