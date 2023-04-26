public class BINARYSEARCH {
    public int Target ;
    public BINARYSEARCH(int Target) {
        this.Target = Target ;
    }

    public int FIND(int[] nums , int src , int end){
        while (src <= end) {
            int mid = src + (end - src)/2 ;
            if (nums[mid] == Target) return mid ;
            else {
                if (Target < nums[mid]) end = mid - 1 ;
                else
                    src = mid + 1 ;
            }
        }
        return -1 ;
    }

    public int FINDPIVOT(int[] nums) {
        int s = 0 ;
        int l = nums.length - 1 ;

        while (s < l) {
            int mid = s + (l-s)/2 ;
            if (nums[mid] >= nums[0])
                s = mid + 1 ;
            else
                l = mid ;
        }
        return s ;
    }
}
