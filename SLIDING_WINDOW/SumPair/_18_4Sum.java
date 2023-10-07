package SumPair;

import java.util.Arrays;
import java.util.List ;
import java.util.ArrayList ;
public class _18_4Sum {
    public static void main(String[] args) {
        solve_18 obj = new solve_18() ;
        List<List<Integer>> answer = new ArrayList<>() ;
        answer = obj.fourSum(new int[]{1,0,-1,0,-2,2} , 0) ;
        System.out.println(answer) ;
        answer = obj.fourSum(new int[]{2,2,2,2,2} , 8) ;
        System.out.println(answer) ;
    }
}
class solve_18{
    public List<List<Integer>> fourSum(int[] num,int target){
        Arrays.sort(num) ;
        List<List<Integer>> answer = new ArrayList<>() ;
        for (int i = 0 ; i < num.length - 3 ; i ++){
            if(i>0 && num[i] == num[i-1]) continue ;
            for (int j = i + 1 ; j < num.length - 2 ; j ++){
                if(j>i+1 && num[j] == num[j-1]) continue ;
                int k = j + 1 ;
                int l = num.length - 1;
                while (k < l){
                    long sum = (long) num[i] + num[j] + num[k] + num[l];
                    if (sum == target){
                        List<Integer> list = new ArrayList<>() ;
                        list.add(num[i]) ;
                        list.add(num[j]) ;
                        list.add(num[k]) ;
                        list.add(num[l]) ;
                        answer.add(new ArrayList<>(list)) ;
                        k ++ ;
                        l -- ;
                        while (k < l && num[k] == num[k-1])
                            k++ ;
                        while (k < l && num[l] == num[l+1])
                            l-- ;
                    } else if (sum < target)
                        k ++ ;
                    else l-- ;
                }
            }
        }

        return answer ;
    }
}