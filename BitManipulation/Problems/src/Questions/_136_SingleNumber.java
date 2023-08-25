package Questions;

public class _136_SingleNumber {
    /**
     * xor property allows
     * a xor a = 0 and
     * a xor 0 = a
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int answer = 0 ;
        for (int val : nums)
            answer ^= val ;
        return answer ;
    }
}
