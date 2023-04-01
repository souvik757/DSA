import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _backspace_string_compare_ {
    static _backspace_string_compare_ result = new _backspace_string_compare_() ;
    public static void main(String[] args) {
        System.out.print("s ->") ;
        String s = new Scanner(System.in).next() ;
        System.out.print("t ->");
        String t = new Scanner(System.in).next() ;
        System.out.println(result.backspaceCompare(s,t)) ;
    }
    // Brute - force -- >
    public boolean backspaceCompare(String s, String t) {
        List<Character> S_list = new ArrayList<>() ;
        List<Character> T_list = new ArrayList<>() ;
        fill(s, S_list) ;
        fill(t, T_list) ;
        if(S_list.size() != T_list.size())
            return false ;
        for(int i = 0 ; i < S_list.size() ; i++){
            if(S_list.get(i) != T_list.get(i))
                return false ;
        }
        return  true ;
    }

    private void fill(String s, List<Character> list) {
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != '#')
                list.add(s.charAt(i)) ;
            else{
                if(!list.isEmpty())
                    list.remove(list.size() - 1) ;
            }
        }
        System.out.println(list);
    }
}
