public class SOLVEDAY8 {
    private int Target ;
    private BINARYSEARCH object ;
    // QUES 74 . Search a 2D matrix :::
    public boolean searchMatrix(int[][] matrix, int target) {
        Target = target ;
        object = new BINARYSEARCH(Target) ;
        for (int i = 0 ; i < matrix.length ; i ++) {
            int foundit = object.FIND(matrix[i], 0,matrix[0].length - 1) ;
            if (foundit > -1) return true ;
        }
        return false ;
    }
    // QUES 33 . Search in a rotated sorted array :::
    public int search(int[] nums, int target) {
        Target = target ;
        object = new BINARYSEARCH(Target) ;
        int _pivot_ = object.FINDPIVOT(nums) ;
        if (nums[0] >= nums[nums.length-1]){
            if (Target>=nums[_pivot_] && Target<=nums[nums.length-1])
                return object.FIND(nums, _pivot_, nums.length-1) ;
            else
                return object.FIND(nums, 0, _pivot_-1) ;
        }
        return object.FIND(nums , 0, nums.length-1) ;
    }
}
