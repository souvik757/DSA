import java.util.Arrays ;
public class _2300_SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(SOLVE_2300.successfulPairs(
                new int[]{3,2,4,6} ,
                new int[]{5,4,3,2,1} ,
                9
        ))) ;
        System.out.println(Arrays.toString(SOLVE_2300.successfulPairs(
                new int[]{3,8,4,2} ,
                new int[]{5,8,3,2,1} ,
                12
        ))) ;
    }
}
class SOLVE_2300 {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int index = 0 ;
        int N = spells.length ;
        Arrays.sort(potions) ;
        int[] answer = new int[N] ;

        for (int val : spells) // O(N *
            answer[index ++] = fill(val,potions,success) ;  // logM)

        return answer ;
    }// O(NlogM) , N = spells.length M = potions.length
    private static int fill(int val,int[] potions,long mul){
        int s = 0 ;
        int e = potions.length - 1 ;

        while (s <= e){
            int mid = s + (e-s)/2 ;
            if ((long)val * potions[mid] < mul) // ****
                s = mid + 1 ;
            else
                e = mid - 1 ;
        } // Logic & **variable type convention**

        return potions.length-s ;
    }
}