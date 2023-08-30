package Problems;

public class _1523_CountOddNumbersInanInterval {
    public int countOdds(int start , int end){
        int total = end - start + 1 ;
        if(start%2 != 0 && end%2 != 0)
            return total/2 + 1;
        return total/2 ;
    }
}
