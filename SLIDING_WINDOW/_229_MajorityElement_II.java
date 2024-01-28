import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _229_MajorityElement_II {
    public static void main(String[] args) {
        solve_229 obj = new solve_229() ;
        List<Integer> answer = new ArrayList<>() ;
        answer = obj.majorityElement(new int[]{1,0,0,-1,0,-2,2}) ;
        System.out.println(answer);// 0
    }
}
class solve_229 {
    public List<Integer> majorityElement(int[] num) {
        int range = (int)Math.floor(num.length/3) ;
        List<Integer> answer = new ArrayList<>() ;
        Map<Integer,Integer> freqMap = new HashMap<>() ;
        for (int val : num){
            freqMap.put(val , freqMap.getOrDefault(val,0)+1) ;
        }
        for (Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            int key = entry.getKey() ;
            int val = entry.getValue() ;
            if(val > range)
                answer.add(key) ;
        }

        return answer ;
    }
}