package Questions;

public class DecimalToBinary {
    /**
     * except using Integer.toBinaryString(decimal)
     * @param decimal number
     * @return binary representation
     */
    public String toBinary(int decimal){
        if(decimal == 0)
            return "0" ;
        StringBuilder answer = new StringBuilder() ;
        while (decimal > 0){
            answer.append(decimal%2) ;
            decimal = decimal/2 ;
        }
        answer.reverse() ;

        return new String(answer) ;
    }
}