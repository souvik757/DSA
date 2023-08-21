import Questions.BinaryToDecimal;
import Questions.DecimalToBinary;
import Questions.count1bits;

public class Main {
    public static void main(String[] args) {
        Objects objects = new Objects() ;
        objects.showOutput() ;
    }
}
class Objects{
    private final DecimalToBinary object1 = new DecimalToBinary() ;
    private final BinaryToDecimal object2 = new BinaryToDecimal() ;
    private final count1bits object3 = new count1bits() ;
    public void showOutput(){
        System.out.println(object1.toBinary(24)) ;
        System.out.println(object2.toDecimal(11010));
        System.out.println(object3.setBits(24));
    }
}