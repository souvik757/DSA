package Questions;

public class BinaryToDecimal {
    /**
     * except using Integer.parseInt("binary string" , digit)
     * @param bin binary number
     * @return decimal representation
     */
    public int toDecimal(int bin){
        int i = 0 ;
        int decimal = 0 ;
        while (true){
            if(bin == 0)
                break ;
            else {
                int temp = bin % 10 ;
                decimal += (int) (temp * Math.pow(2,i));
                bin = bin/10 ;
                i ++ ;
            }
        }
        return decimal ;
    }
}
