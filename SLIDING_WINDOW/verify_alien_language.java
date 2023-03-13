import java.util.HashMap;
import java.util.Map;

public class verify_alien_language {
    public static void main(String[] args) {
        verify _ver_ = new verify() ;
        System.out.println(_ver_.isAlienSorted(new String[]{"hello","leetcode"} , "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(_ver_.isAlienSorted(new String[]{"apple","app"} , "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(_ver_.isAlienSorted(new String[]{"app","apple"} , "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(_ver_.isAlienSorted(new String[]{"word","world","row"} , "worldabcefghijkmnpqstuvxyz"));
    }
}
class verify{
    public boolean isAlienSorted(String[] words, String order) {
            // key - value
            Map<Character, Integer> _order_ = new HashMap<>();
            for (int i = 0; i < order.length(); i++) {
                _order_.put(order.charAt(i), i);
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (!_Check_(words[i], words[j], _order_))
                        return false;
                }
            }
            return true;
    }
    public boolean _Check_(String a , String b , Map<Character , Integer> _order_){
        boolean ans = true ;
        int i = 0 ;
        int j = 0 ;
        int indicator = 0 ;
        while(i<a.length() || j<b.length()){
            if(j == b.length() && i != a.length()) {
                ans = false;
                break;
            }
            else if(j != b.length() && i == a.length()) {
                ans = true ;
                break;
            }
            else {
                char _ch_a_ = (i != a.length()) ? a.charAt(i) : '-' ;
                char _ch_b_ = (j != a.length()) ? b.charAt(j) : '-' ;
                int _num_a_ = _order_.get(_ch_a_);
                int _num_b_ = _order_.get(_ch_b_);
                if (_num_a_ != _num_b_) {
                    if (_num_a_ > _num_b_) {
                        ans = false ;
                    }
                    else {
                        ans = true ;
                    }
                    break;
                }
            }
            i++;
            j++;
        }
        return ans ;
    }
}
