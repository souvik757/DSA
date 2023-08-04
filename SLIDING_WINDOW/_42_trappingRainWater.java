public class _42_trappingRainWater {
    public static void main(String[] args) {
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1} ;
        solve_42 object = new solve_42() ;
        solve_42_optimized objectOpt = new solve_42_optimized() ;
        System.out.println(object.trap(heights));
        System.out.println(objectOpt.trap(heights));
    }
}
// formula : maximum rain a cell can hold can be calculated as
//         : f(w) = min(leftHeight,rightHeight) - height of current cell
class solve_42 {
    public int trap(int[] height) {
        int maxTrappedWater = 0 ;

        int[] prefixMax = new int[height.length];
        setPrefix(prefixMax,height) ;
        int[] postfixMax = new int[height.length];
        setPostfix(postfixMax,height);

        for (int i = 0 ; i < height.length ; i ++){
            maxTrappedWater += Math.min(prefixMax[i], postfixMax[i]) - height[i] ;
        }

        return maxTrappedWater ;
    }
    private void setPrefix(int[] prefixMax , int[] height){
        int index = 0 ;
        int max = height[index] ;
        for (int val : height){
            if(val > max) {
                max = val ;
            }
            prefixMax[index++] = max ;
        }
    }
    private void setPostfix(int[] postfixMax , int[] height){
        int n = height.length ;
        int index = n-1 ;
        int max = height[n-1] ;
        for (int i = n-1 ; i >= 0 ; i --){
            if(height[i] > max){
                max = height[i] ;
            }
            postfixMax[index--] = max ;
        }
    }
}
class solve_42_optimized extends solve_42{
    @Override
    public int trap(int[] height) {
        int maxTrappedWater = 0 ;
        int n = height.length ;
        int left = 0 ;
        int right = n - 1 ;
        int leftMax = 0 , rightMax = 0 ;
        while (left <= right){
            if(height[left] <= height[right]){
                if(height[left] > leftMax)
                    leftMax = height[left] ;
                else
                    maxTrappedWater += leftMax - height[left] ;
                left ++ ;
            }
            else{
                if(height[right] > rightMax)
                    rightMax = height[right] ;
                else
                    maxTrappedWater += rightMax - height[right] ;
                right -- ;
            }
        }
        return maxTrappedWater ;
    }
}