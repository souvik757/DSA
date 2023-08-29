package Problems;

public class _1876_SubStrOf3DistinctChars {
    public int countGoodSubstrings(String s) {
        int count = 0 ;
        int length = s.length() - 3 ;
        for (int i = 0 ; i < length ; i ++){
            if(hasUnique(s.substring(i,i+3)))
                count ++ ;
        }

        return count ;
    }
    private boolean hasUnique(String s){
        char ch1 = s.charAt(0) ;
        char ch2 = s.charAt(1) ;
        char ch3 = s.charAt(2) ;

        return (ch1 != ch2) && (ch2 != ch3) && (ch3 != ch1) ;
    }
}
