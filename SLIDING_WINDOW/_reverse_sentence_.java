import java.util.ArrayList;
import java.util.Arrays;

public class _reverse_sentence_ {
    static Solution sol = new Solution() ;

    public static void main(String[] args) {
        System.out.println("'"+sol.reverseWords("  the      sky is    blue  ")+"'");
    }
}
class Solution {
    public String reverseWords(String s) {
        System.out.println("Given sentence -> "+s);
        s = s.replaceAll("\\s{2,}", " ").trim(); ;
        ArrayList<String> _ans_ = new ArrayList<>();
        int _last_space_index_ = -1 ;
        int start ;
        int end ;
        int j = 1 ;
        while(j < s.length()){
            if((s.charAt(j) == ' ' && s.charAt(j-1) != ' ') || (j == s.length() - 1)){
                start = _last_space_index_ + 1 ;
                end = j ;
                if(j != s.length() -1 )
                    _ans_.add(s.substring(start , end)) ;
                else
                    _ans_.add(s.substring(start , s.length())) ;
                _last_space_index_ = j ;
            }
            j++ ;
        }
        String[] ANS = new String[_ans_.size()] ;
        int index = 0 ;
        for(int i = _ans_.size()-1 ; i>=0 ; i--)
        {
            ANS[index] = _ans_.get(i) ;
            index++ ;
        }
        String x = "" ;
        for(int i = 0 ; i < index ; i++){
            if(i == index-1)
                x = x+ANS[i] ;
            else
                x = x+ANS[i]+" " ;
        }
        return x;
    }
}
