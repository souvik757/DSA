package Questions;

public class _137_SingleNumber_II {
    private static final int maxInteger = 32 ;
    public int singleNumber(int[] nums) {
        int result = 0 ;
        for (int bits = 0 ; bits < maxInteger ; bits++){
            int sum = 0 ;
            int mask = (1 << bits) ;
            for (int val : nums){
                if((val & mask) != 0)
                    sum ++ ;
            }
            if(sum % 3 == 1)
                result = result | mask ;
        }

        return result ;
    }
}
