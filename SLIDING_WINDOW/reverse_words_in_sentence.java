import java.util.Scanner ;
public class reverse_words_in_sentence {
    public static void main(String[] args){
        String _sen_ = new Scanner(System.in).nextLine() ;
        char[] ch = _sen_.toCharArray() ;
        System.out.println(_sen_);
        int j = 0 ;
        int _last_space_found_ = -1, _start_ , end ;
        while(j < _sen_.length()){
            if((j==_sen_.length()-1) || (ch[j]==' '))
            {
                _start_ = _last_space_found_ + 1 ;
                if(j == ch.length - 1)
                    end = j ;
                else
                    end = j - 1;
                while(_start_ < end) {
                    char temp = ch[_start_];
                    ch[_start_++] = ch[end];
                    ch[end--] = temp;
                }
                _last_space_found_ = j ;
            }
            j++ ;
        }
        System.out.println(new String(ch));

    }
}
