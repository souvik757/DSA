import java.util.* ;
public class _68_TextJustification {
    public static void main(String[] args) {
        solve_68 object = new solve_68() ;
        List<String> answer = new ArrayList<>() ;
        answer = object.fullJustify(new String[]{

                "What", "must", "be",
                "acknowledgment",
                "shall", "be"}

                , 16) ;
        for (String str : answer)
            System.out.println(str);
        System.out.println();
        answer = object.fullJustify(new String[]{

                "Science", "is", "what", "we",
                "understand", "well",
                "enough", "to", "explain", "to",
                "a", "computer.", "Art", "is",
                "everything", "else", "we",
                "do"} 

                , 20) ;
        for (String str : answer)
            System.out.println(str);
    }
}
class solve_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>() ;
        int size = words.length ;
        int length = 0 ;
        int s = 0 ;
        int i = 0 ;
        while (i < size){
            length += (words[i].length()+1) ;
            if(length-1 >= maxWidth || (i == size-1)){
                if(length-1 == maxWidth){
                    answer.add(formString(s,i,maxWidth,words)) ;
                    s = i +1;
                    length = 0 ;
                }
                else if(length-1 > maxWidth){
                    answer.add(formString(s,i-1,maxWidth ,words));
                    s = i ;
                    length = 0 ;
                    continue ;
                }
                else {
                    answer.add(formString(s,i,maxWidth,words));
                    s = 0 ;
                    length = 0 ;
                }
            }
            i ++ ;
        }
        return answer ;
    }
    private String formString(int s , int i , int maxWidth, String[] words){
        int totalChars = 0 ;
        String spaces = "" ;
        for (int index = s ; index <= i ; index ++){
            totalChars += words[index].length() ;
        }
        int restWidth = maxWidth - totalChars ;
        int spacesToPlace = i - s ;
        if(spacesToPlace == 0){
            for (int index = 0 ; index < restWidth ; index++)
                spaces = spaces +" " ;
            return words[i]+spaces ;
        }
        int numSpaces = restWidth/spacesToPlace ;
        for (int index = 0 ; index < numSpaces ; index++)
            spaces = spaces +" " ;
        StringBuilder answer = new StringBuilder() ;
        for (int index = s ; index <= i ; index ++){
            answer.append(words[index]) ;
            if(index < i)
                answer.append(spaces) ;
        }
        return new String(answer) ;
    }
}