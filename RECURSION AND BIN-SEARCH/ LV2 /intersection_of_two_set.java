import java.util.Arrays;

/*
 * num1[] = {1, 2, 3, 4}
 * num2[] = {2, 3, 3, 2}
 * set[] = {2, 3}
 */

public class intersection_of_two_set {
    // :: BINARY SEARCH FUNCTION ::
    static boolean binary_search(int[] nums, int target){
        int s = 0;
        int l = nums.length - 1;
        while(s <= l){
            int mid = s +(l-s)/2;
            if(target == nums[mid])
               return true;
            if(target < nums[mid])
            {
                l = mid -1 ;
            }
            else
            {
                s = mid + 1 ;
            }
        }
        return false;
    }
    // :: FUNCTION FOR PRINTING ::
    static void print(int[] num){
        for(int i:num)
            System.out.print(i+" ");
    }
    // :: CHECK FOR INTERSECT ELEMENT AND STORE TO ANOTHER ARRAY ::
    static void intersection(int[] num1 , int[] num2){
        if(num2.length == 0)
           print(num1);
        if(num1.length == 0)
           print(num2);
        Arrays.sort(num1);
        int[] temp = new int[num1.length+num2.length];
        int index = 0;
        for(int i:num2)
        {
            if(binary_search(num1, i))
            {
                temp[index] = i;
                index++;
            }
        }
        System.out.print("Intersection : ");
        for(int i = 0 ; i < index ; i++)
        {
            System.out.print(temp[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{3,4,5,5,6,6,6,6,6,1};
        intersection(nums1, nums2);
    }
}
