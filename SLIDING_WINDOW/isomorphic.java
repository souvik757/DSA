import java.util.*;

public class isomorphic {
    public static void main(String[] args) {
        solves result = new solves() ;
        System.out.println(result.isIsomorphic("badc","baba"));
    }
}
class solves{
    public boolean isIsomorphic(String s ,String  t){
        boolean answer = true ;
        Map<Character,Character> _map_ = new HashMap<>() ;
        Map<Character,Boolean> _map_2 = new HashMap<>() ;
        if(s.length() == t.length()){
            // write code here -->
            for(int i = 0 ; i < s.length() ; i++){
                if(_map_.containsKey(s.charAt(i))){
                    if(!_map_.get(s.charAt(i)).equals(t.charAt(i)))
                        answer = false ;
                }
                else
                {
                    if(_map_2.containsKey(t.charAt(i))){
                        if (_map_2.get(t.charAt(i)))
                            return false;
                    }
                    else
                        _map_2.put(t.charAt(i) , true) ;

                    _map_.put(s.charAt(i) , t.charAt(i)) ;
                }
            }
        }else return false ;
        System.out.println(_map_);
        return answer ;
    }
}
