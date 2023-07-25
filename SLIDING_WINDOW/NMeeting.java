import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NMeeting {
    public static void main(String[] args) {
        solve_numberOfMeeting object1 = new solve_numberOfMeeting() ;
        solve_meetings object2 = new solve_meetings() ;
        System.out.println(object1.minMeeting(new int[]{1,3,0,5,8,5} , new int[]{2,4,6,7,9,9})) ;
        System.out.println(object2.minMeeting(new int[]{1,3,0,5,8,5} , new int[]{2,4,6,7,9,9})) ;
    }
}
class solve_numberOfMeeting {
    public int minMeeting(int[] arrival , int[] end){
        int count = 1 ; // as first meeting will be held no matter what .
        int size = arrival.length ;
        int[][] pairs = new int[size][2] ;
        for (int i = 0 ; i < size ; i ++){
            pairs[i][0] = arrival[i] ;
            pairs[i][1] = end[i] ;
        }
        Arrays.sort(pairs , (a,b)->a[1]-b[1]) ; // sort acc to second value that is ending time .
        int prevEnd = pairs[0][1] ;
        for (int i = 1 ; i < size ; i ++){
            int[] val = pairs[i] ;
            if(val[0] > prevEnd){
                count ++ ;
                prevEnd = val[1] ;
            }
        }
        return count ;
    }
}
class solve_meetings {
    public List<Integer> minMeeting(int[] arrival , int[] end){
        List<Integer> list = new ArrayList<>() ;
        int size = arrival.length ;
        int[][] pairs = new int[size][2] ;
        for (int i = 0 ; i < size ; i ++){
            pairs[i][0] = arrival[i] ;
            pairs[i][1] = end[i] ;
        }
        Arrays.sort(pairs , (a,b)->a[1]-b[1]) ;
        int prevEnd = pairs[0][1] ;
        list.add(1) ;
        for (int i = 1 ; i < size ; i ++){
            int[] val = pairs[i] ;
            if(val[0] > prevEnd){
                list.add(i+1);
                prevEnd = val[1] ;
            }
        }
        return list ;
    }
}