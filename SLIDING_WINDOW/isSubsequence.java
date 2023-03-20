public class isSubsequence {
    public static void main(String[] args) {
        _solves_ solve = new _solves_() ;
        System.out.println(solve.isSubsequence("abc" , "xajnckkb"));     // false
        System.out.println(solve.isSubsequence("abc" , "bcd"));          // false
        System.out.println(solve.isSubsequence("abc" , "abc"));          // true
        System.out.println(solve.isSubsequence("abc" , "sddaqwebyuic")); // true
    }
}
class _solves_{
    public boolean isSubsequence(String s, String t) {
        boolean answer;
        int s_length = s.length() ;
        int t_length = t.length() ;
        if(s_length == 0)
            return true ;
        if(t_length == 0)
            return false ;
        if(s_length == t_length) {
            return s.equals(t) ;
        }
        else
            answer = perform(s, t);

        return answer ;
    }
    public boolean perform(String s , String t){
        int index = 0 ;
        for(int i = 0 ; i < t.length() ; i++){
            if(t.charAt(i) == s.charAt(index)) {
                index++ ;
                if(index == s.length()){
                    return true ;
                }
            }
        }
        return false ;
    }
}