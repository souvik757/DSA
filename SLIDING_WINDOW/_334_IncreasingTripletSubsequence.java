public class _334_IncreasingTripletSubsequence {
    public static void main(String[] args) {
        SOLVE334 object = new SOLVE334() ;
        System.out.println(object.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(object.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(object.increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
class SOLVE334{
    public boolean increasingTriplet(int[] nums) {
        int Smallest0 = Integer.MAX_VALUE ;
        int Smallest1 = Integer.MAX_VALUE ;
        for (int val : nums) {
            if(val <= Smallest0)
                Smallest0 = val ;
            else if(val <= Smallest1)
                Smallest1 = val ;
            else
                return true ;
        }
        return false ;
    }
}