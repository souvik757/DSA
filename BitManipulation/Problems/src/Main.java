import Questions.*;

import java.util.Arrays;

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
    private final _338_CountingBits object4 = new _338_CountingBits() ;
    private final eliminateDuplicate object5 = new eliminateDuplicate() ;
    private final countBitsFlip object6 = new countBitsFlip() ;
    private final _201_BitwiseAnd object7 = new _201_BitwiseAnd() ;
    private final _172_FactTrailingZero object8 = new _172_FactTrailingZero() ;
    private final _149_MaxPointsOnALine object9 = new _149_MaxPointsOnALine() ;
    public void showOutput(){
        System.out.println(object1.toBinary(14)) ;
        System.out.println(object2.toDecimal(11010));
        System.out.println(object3.setBits(24));
        System.out.println(Arrays.toString(object4.countBits(5))) ;
        System.out.println(Arrays.toString(object5.getUnique(new int[]{1,1,2,2,3,4,4,5})));
        System.out.println(object6.countFlips(20,25));
        System.out.println(object7.rangeBitwiseAnd(5,2147483647));
        System.out.println("no. of 0's : "+object8.trailingZeroes(13));
        System.out.println(object9.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
    }
}