package Problems;

public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] str){
        if(str.length == 0)
            return "" ;
        String answer = str[0] ;
        for (String strs : str){
            while (strs.indexOf(answer) != 0){
                answer = answer.substring(0 , answer.length() - 1) ;
                if(answer.isEmpty())
                    return "" ;
            }
        }

        return answer ;
    }
}
