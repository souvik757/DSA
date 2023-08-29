package Problems;

public class _1480_RunningSum1dArray {
    public int[] runningSum(int[] num) {
        int sum = 0 ;
        int[] answer = new int[num.length] ;
        for (int i = 0 ; i < num.length ; i ++){
            sum += num[i];
            answer[i] = sum ;
        }

        return answer ;
    }
}
