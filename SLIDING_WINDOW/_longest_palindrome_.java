import java.util.*;

public class _longest_palindrome_ {
}
class _solve_{
    public int longestPalindrome(String s) {
        HashSet<Character> _list_ = new HashSet<>() ;
        int _length_ = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(_list_.contains(s.charAt(i))){
                _length_ += 2 ; // as an instance : 'aa' , length of this palindrome = 2 .
                _list_.remove(s.charAt(i)) ;// remove duplicate entry from list .
            }
            else
                _list_.add(s.charAt(i)) ;// insert a new entry every time .
        }
        // after coming out from the for loop , the list should contain only unique chars.
        // if there is even 1 such unique char , we can add that char to our palindrome string .
        // such as palindrome =  'acca' and list[]{'d' , 's'}
        // we can add one such unique chars to the palindrome 'acdca'
        return (_list_.size() > 0) ? _length_+1 : _length_ ;
    }
}