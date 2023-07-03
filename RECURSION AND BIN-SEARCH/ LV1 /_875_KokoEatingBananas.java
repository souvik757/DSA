public class _875_KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(SOLVE_875.minEatingSpeed(
                new int[]{3,6,7,11} ,8
        ));
        System.out.println(SOLVE_875.minEatingSpeed(
                new int[]{30,11,23,4,20} ,5
        ));
        System.out.println(SOLVE_875.minEatingSpeed(
                new int[]{30,11,23,4,20} ,6
        ));

    }
}
class SOLVE_875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int s = 0 ;
        int e = Max(piles) ;
        while (s <= e) {
            int mid = s + (e-s)/2 ;
            int hours = GetHours(piles , mid) ;
            if (hours <= h)
                e = mid - 1 ;
            else
                s = mid + 1 ;
        }

        return s ;
    }
    private static int Max(int[] arr){
        int largest = arr[0] ;
        for (int val : arr) {
            if (val > largest)
                largest = val ;
        }
        return largest ;
    }
    private static int GetHours(int[] piles , int k){
        int TotalHours = 0 ;
        for (int val : piles)
            TotalHours += Math.ceil((double) val/k) ;

        return TotalHours ;
    }
}