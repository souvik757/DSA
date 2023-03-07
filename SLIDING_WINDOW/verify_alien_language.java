import java.util.HashMap;
import java.util.Map;

public class verify_alien_language {
    public static void main(String[] args) {
        verify _ver_ = new verify() ;
        System.out.println(_ver_.isAlienSorted(new String[]{"apple" , "app"} ,
                "abcdefghijklmnopqrstuvwxyz"));
    }
}
class verify{
    public boolean _isValid_(String[] words){
        for(int i = 0 ; i < words.length ; i++){
            for(int j = i+1 ; j < words.length ; j++){
                if(words[j].length() < words[i].length())
                    return false ;
            }
        }
        return true ;
    }
    public boolean isAlienSorted(String[] words, String order) {
            // key - value
            Map<Character, Integer> _order_ = new HashMap<>();
            for (int i = 0; i < order.length(); i++) {
                _order_.put(order.charAt(i), i);
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (_Check_(words[i], words[j], _order_) > 0)
                        return false;
                }
            }
            return true;
    }
    public int _Check_(String a , String b , Map<Character , Integer> _order_){
        int i = 0 ;
        int j = 0 ;
        int indicator = 0 ;
        while(i<a.length() || j<b.length()){
            if(i > j)
                indicator++ ;
            char _ch_a_ = a.charAt(i) ;
            char _ch_b_ = b.charAt(j) ;
            int _num_a_ = _order_.get(_ch_a_) ;
            int _num_b_ = _order_.get(_ch_b_) ;
            if(_num_a_ != _num_b_){
                if(_num_a_ > _num_b_)
                    indicator++ ;
                else
                    indicator-- ;
            }
            i++ ;
            j++ ;
        }
        return indicator ;
    }
}
