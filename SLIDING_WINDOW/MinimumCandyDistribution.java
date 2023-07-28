import java.util.* ;
public class MinimumCandyDistribution {
    public static void main(String[] args) {
        __solve__ object = new __solve__() ;
        List<Integer> list = new ArrayList<>() ;
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(12);
        System.out.println(object.minimumDifference(8 , 5 ,
                list));
    }
}
class __solve__{
    public int minimumDifference(int N , int M , List<Integer> candies){
        int minimum = Integer.MAX_VALUE ;
        Collections.sort(candies) ;
        int s = 0 ;
        int e = M-1 ;
        while (e < N){
            int difference = candies.get(e) - candies.get(s);
            minimum = Math.min(minimum , difference) ;
            e ++ ;
            s ++ ;
        }
        return minimum ;
    }
}