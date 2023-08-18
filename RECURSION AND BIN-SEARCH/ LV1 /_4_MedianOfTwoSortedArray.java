import java.util.Arrays;

public class _4_MedianOfTwoSortedArray {
    public static void main(String[] args) {
        solve_4 obj = new solve_4() ;
        System.out.println(obj.findMedianSortedArrays(
                new int[]{1,3} ,
                new int[]{2}
        ));
        System.out.println(obj.findMedianSortedArrays(
                new int[]{1,2} ,
                new int[]{3,4}
        ));

        solve_4_brute object = new solve_4_brute() ;
        System.out.println(object.findMedianSortedArrays(
                new int[]{1,3} ,
                new int[]{2}
        ));
        System.out.println(object.findMedianSortedArrays(
                new int[]{1,2} ,
                new int[]{3,4}
        ));
    }
}
class solve_4{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length ;
        int m = nums2.length ;
        boolean even = (n + m) % 2 == 0 ;
        if(m < n)
            return findMedianSortedArrays(nums2,nums1) ;
        int low = 0 ;
        int high = n ;
        while (low <= high){
            int cut1 = low + (high-low)/2 ;
            int cut2 = ((n + m + 1)/2) - cut1 ;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1];

            int r1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1] ;
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2] ;

            if(l1 <= r2 && l2 <= r1){
                if(even)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1,l2) ;
            }
            else if(l1 > r2){
                high = cut1 - 1 ;
            }
            else {
                low = cut1 + 1 ;
            }
        }
        return 0.0 ;
    }
}
class solve_4_brute extends solve_4{
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr ;
        int index = 0 ;

        int n = nums1.length ;
        int m = nums2.length ;
        int total = n + m ;
        int mid = (total-1)/2 ;
        arr = new int[total] ;

        int i = 0 , j = 0 ;
        while (i < n && j < m){
            if(nums1[i] <= nums2[j]){
                arr[index++] = nums1[i++];
            }
            else {
                arr[index++] = nums2[j++];
            }
        }
        while (i < n && index < total){
            arr[index++] = nums1[i++] ;
        }
        while (j < m && index < total){
            arr[index++] = nums2[j++] ;
        }
        System.out.println(Arrays.toString(arr)) ;

        double answer = 0.0 ;
        answer = (total%2==0)?(double)(arr[mid]+arr[mid+1])/2:(double)arr[mid] ;

        return answer ;
    }
}