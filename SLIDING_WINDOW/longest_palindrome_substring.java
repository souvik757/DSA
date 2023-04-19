public class longest_palindrome_substring {
    public static void main(String[] args) {
        solutionS5 object = new solutionS5() ;
        System.out.println(object.longestPalindrome("abcdfggfhjioiuuytrrty"));
    }
}
class solutionS5{
    private int _length_;
    private int start ;
    private int end   ;
    private int MaxLength ;
    public int longestPalindrome(String s) {
        char[] Sch = s.toCharArray() ;
        end = -1 ;
        MaxLength = Integer.MIN_VALUE ;
        for (int i = 0 ; i < Sch.length - 1 ; i++){
            _length_ = 0 ;
            start = end + 1 ;
            int last = i + 1 ;
            boolean check = is_palindrome(Sch, start, last) ;
            if(check){
                System.out.println("TRUE");
                _length_ = last - start + 1 ;
                end = last + 1 ;
            }
            System.out.println(i);
            MaxLength = Math.max(MaxLength , _length_) ;
        }
        return MaxLength ;
    }
    private boolean is_palindrome(char[] data , int s , int l){
        int i = s ;
        while (i <= l){
            if (data[i] != data[l-i+1])
                return false ;
            i++ ;
        }
        return true ;
    }
}
// aba     0 1 2
// abaaba  0 1 2 3 4 5