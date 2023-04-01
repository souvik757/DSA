import java.util.Stack;

public class Decode_string {
    static Decode_string answer =  new Decode_string() ;
    public static void main(String[] args) {
        System.out.println("Decoded String : "+answer.decodeString("10[a2[c]]")) ;
        System.out.println("Decoded String : "+answer._DECODE_("10[a2[c]]")) ;
    }
    int index = 0 ;
    // Using recursion -> 'There has to be a recursive solution as Stack uses recursion within memory' -
    private String _DECODE_(String s){
        StringBuilder answer = new StringBuilder() ;
        while(index < s.length() && s.charAt(index)!=']'){
            if(!Character.isDigit(s.charAt(index)))
                answer.append(s.charAt(index++)) ;
            else {
                int number = 0 ;
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    number = number * 10 + Character.getNumericValue(s.charAt(index++)) ;
                index++ ; // ignore opening [
                String X = _DECODE_(s) ;
                index++ ; // ignore opening ]
                while (number-->0)
                    answer.append(X) ;
            }
        }
        return answer.toString() ;
    }




    // Using Stack ->
    public String decodeString(String s) {
        Stack<String> word = new Stack<>() ;
        StringBuilder result = new StringBuilder() ;
        Stack<Integer> iterations = new Stack<>();
        int number = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i) ;
            if(Character.isDigit(c))
                number = number * 10 + Character.getNumericValue(c) ; // it forms numbers consecutively .
            else if(Character.isLetter(c)) {
                result.append(c);
                System.out.println("Encounter letter : "+result);
            }
            else if(c == '['){
                iterations.push(number) ;
                word.push(result.toString()) ;
                System.out.println(word.peek());
                System.out.println("Encounter [ : "+result);
                number = 0 ;// when we encounter a '[' , we want to reform the number as previous number indicates iteration of string under '[]' .
                result = new StringBuilder() ;
            }
            else{
                StringBuilder X = new StringBuilder(word.pop()) ;
                int T = iterations.pop() ;
                System.out.println("encounter ] : "+T);
                while (T-->0){
                    X.append(result) ;
                }
                result = X ;
                System.out.println("encounter ] : "+result);
            }
        }
        return result.toString() ;
    }
}
/*
2[abc]3[cd]ef
 */
