package StringsIMP.Questions;

// Remove duplicate characters from a string, leaving only one occurrence of each character.

public class Qus2 {
    public static String getString(String s){
        StringBuilder strBld = new StringBuilder() ;
        strBld.append(s.charAt(0)) ;
        for (int i = 1 ; i < s.length() ; i ++){
            if(s.charAt(i-1) != s.charAt(i))
                strBld.append(s.charAt(i)) ;
        }

        return new String(strBld) ;
    }
    // T.C : O(n)
    // S.C : O(Maximum of unique char's)
}