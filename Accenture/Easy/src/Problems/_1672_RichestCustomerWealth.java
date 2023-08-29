package Problems;

public class _1672_RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxSum = Integer.MIN_VALUE ;
        for (int[] row : accounts){
            int sum = getRowSum(row) ;
            maxSum = Math.max(maxSum , sum) ;
        }
        return maxSum ;
    }
    private int getRowSum(int[] row){
        int sum = 0 ;
        for (int val : row)
            sum += val ;
        return sum ;
    }
}
