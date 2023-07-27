public class _151_reverse_words_in_sentence {
    public static void main(String[] args){
        solve_151 object = new solve_151() ;
        System.out.println(object.reverseWords("Hi , how are ya ?"));
    }
}
class solve_151 {
    public String reverseWords(String s) {
        int size = s.length() ;
        s = s.trim() ;
        String str = "" ;
        StringBuilder answer = new StringBuilder() ;
        for (int i = size-1 ; i >= 0 ; i --){
            if(s.charAt(i) == ' '){
                str = reverseString(str) ;
                answer.append(str) ;
                answer.append(' ') ;
                str = "" ;
            }
            else{
                str = str + s.charAt(i) ;
            }
        }
        str = reverseString(str) ;
        answer.append(str) ;

        return new String(answer) ;
    }
    public String reverseString(String s) {
        int len = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char temp = ch[len - i - 1];
            ch[len - i - 1] = ch[i];
            ch[i] = temp;
        }

        return new String(ch);
    }

}
