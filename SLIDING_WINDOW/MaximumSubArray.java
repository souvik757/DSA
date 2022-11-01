public class MaximumSubArray {
    public static void main(String[] args) {
        int[] numbs = new int[]{5 , 4 , -1 , 7 , 8} ;
        System.out.println("By brute-force approach : "+BruteForceMax(numbs));
        System.out.println("-----------------------------------------------");
        System.out.println("By Optimized approach"+OptimizedApproach(numbs));
        System.out.println("-----------------------------------------------");
        System.out.println("By Kadane's algorithm : "+KadaneProcess(numbs));
    }
    //------------------------------------------------------------------------------
// Kadane's Algorithm --> T.C : O(n)
    private static int  OptimizedApproach(int[] numbs)
    {
        int sum ;
        int maxSum = Integer.MIN_VALUE ;
        for(int i = 0 ; i < numbs.length ; i++)
        {
            sum = 0 ;
            for(int j = 0 ; j < numbs.length ; j++)
            {
                sum += numbs[j];
                System.out.println("Summation : "+sum);
            }
            maxSum = Math.max(maxSum , sum) ;
            System.out.println("Maximum Summation : "+maxSum);
            System.out.println();
        }
        return maxSum ;
    }
//------------------------------------------------------------------------------







//------------------------------------------------------------------------------
// Kadane's Algorithm --> T.C : O(n)
    private static int  KadaneProcess(int[] numbs)
    {
        int sum = 0 ;
        int maxSum = Integer.MIN_VALUE ;
        for(int i = 0 ; i < numbs.length ; i++)
        {
            sum += numbs[i] ;
            if(sum < 0)
                sum = 0 ;
            maxSum = Math.max(maxSum , sum) ;
        }

        return maxSum ;
    }
//-------------------------------------------------------------------------------







// ------------------------------------------------------------------------------
// Brute-Force Approach --> T.C : O(n^3)
    private static int BruteForceMax(int[] numbs)
    {
        int sum ;
        int maxSum = Integer.MIN_VALUE ;


        for(int i = 0 ; i < numbs.length ; i++)
        {
            for(int j = i ; j < numbs.length ; j++)
            {
                sum = 0 ;
                for(int k = i ; k <= j ; k++)
                {
                    sum += numbs[k];
                    System.out.println("summation : "+sum);
                }
                maxSum = Math.max(maxSum , sum) ;
                System.out.println("Maximum Summation : "+maxSum);
                System.out.println();
            }
        }
        return maxSum ;
    }
// ------------------------------------------------------------------------------
}
