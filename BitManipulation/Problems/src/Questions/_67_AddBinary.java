package Questions;

public class _67_AddBinary {
    /**
     * String answer = Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2)) ;
     * this approach is limited to 32bit integer , greater strings will not work here .
     * @param a
     * @param b
     * @return addition , where a & b is binary strings
     */
    public String addBinary(String a, String b) {
        int x = a.length() ;
        int y = b.length() ;
        StringBuilder answer = new StringBuilder() ;
        int carry = 0 ;
        int j = y - 1 ;

        for (int i = x-1 ; i >= 0 ; i --){
            if(a.charAt(i) == '1')
                carry ++ ;
            if(j >= 0 && b.charAt(j--) == '1')
                carry ++ ;
            if(carry % 2 == 1)
                answer.append('1') ;
            else
                answer.append('0') ;

            carry = carry / 2 ;
        }

        if(carry == 1)
            answer.append('1') ;
        answer.reverse() ;

        return (y > x) ? addBinary(b,a) : new String(answer) ;
    }
}