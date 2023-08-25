package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _66_PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1 ;
        int lastIdx = digits.length ;
        List<Integer> list = new ArrayList<>() ;
        for (int i = lastIdx - 1 ; i >= 0 ; i --){
            int result = digits[i] + carry ;
            carry = result/10 ;
            list.add(result % 10) ;
        }
        if(carry == 1)
            list.add(1) ;
        Collections.reverse(list) ;
        int[] answer = new int[list.size()] ;
        int index = 0 ;
        for(int val : list){
            answer[index++] = val ;
        }

        return answer ;
    }
}
