package Problems;

public class _258_addDigits {
    public int addDigits(int num) {
        if(num <= 0)
            return 0 ;
        if(num < 10)
            return num ;
        return addDigits(num/10 + num%10) ;
    }
}
