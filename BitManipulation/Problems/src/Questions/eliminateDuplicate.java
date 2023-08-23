package Questions;

public class eliminateDuplicate {
    public int[] getUnique(int[] nums){
        int x = 0  , y = 0 ;
        int xor = nums[0] ;
        for (int i = 1 ; i < nums.length ; i ++)
            xor = xor ^ nums[i] ;
        int rightBit = xor & ~(xor-1);
        for (int val : nums){
            if((val & rightBit) != 0)
                x = x ^ val ;
            else
                y = y ^ val ;
        }

        return new int[]{x,y} ;
    }
}
