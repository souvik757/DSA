package SumPair;

import java.util.* ;
public class _15_3sum {
    public static void main(String[] args) {
        solve_15 obj = new solve_15() ;

        List<List<Integer>> answer ;
        answer = obj.threeSum(new int[]{-1,0,1,2,-1,-4}) ;

        System.out.println(answer);
    }
}
class solve_15 {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0 ; i < num.length-2 ; i ++){
            if(i == 0 || (i > 0 && num[i] != num[i-1])){
                int low = i +1 ;
                int high= num.length-1;
                int sum = -num[i];
                while (low < high){
                    List<Integer> output = new ArrayList<>() ;
                    if(num[low] + num[high] == sum){
                        output.add(num[i]);
                        output.add(num[low]);
                        output.add(num[high]);
                        answer.add(new ArrayList<>(output));
                        while (low<high && num[low] == num[low+1])
                            low++ ;
                        while (low<high && num[high] == num[high-1])
                            high-- ;
                        low++ ;
                        high-- ;
                    }
                    else if(num[low]+num[high] < sum)
                        low++ ;
                    else
                        high-- ;
                }
            }
        }

        return answer ;
    }
}