import java.util.* ;
public class _14_Longest_Common_Prefix {
    public static void main(String[] args) {
        solutionS14 object = new solutionS14() ;
        System.out.println("Longest Common Prefix " +object.lcm(new String[]{
                "FLIGHT" , // 6
                "FLOW"   , // 4
                "FLY"    , // 3
                "FRIEND" , // 6
                "FLOWER"   // 6
        }) );
        System.out.println("Longest Common Prefix " + object.longestCommonPrefix(new String[]{
                "FLIGHT" , // 6
                "FLOW"   , // 4
                "FLY"    , // 3
                "FRIEND" , // 6
                "FLOWER"   // 6
        }) );
    }
}
class solutionS14{
    private String NULLSTRING = "" ;
    // Brute-Force Approach O(NlogN + length of minimum element of string array)
    // can be optimized further by avoiding sorting operation , solved below -->
    public String longestCommonPrefix(String[] strs) {
        if ( strs.length == 0 )
            return NULLSTRING;
        return GetCommonPrefix(strs , 0) ;
    }

    private String GetCommonPrefix(String[] strs , int i) {
        Arrays.sort( strs ) ;
        while ( i < strs[0].length() ) {
            if ( strs[0].charAt(i) == strs[strs.length-1].charAt(i) )
                i ++ ;
            else
                break ;
        }

        return strs[0].substring( 0, i ) ;
    }
    // O(Length Of String Array * Length Of first String)
    public String lcm(String[] strs){
        if (strs.length == 0) {
            return NULLSTRING;
        }
        // if S.indexof(sub) == 0 means S is consists of sub .
        // if S.indexof(sub) != 0 means S doesn't consist of sub .
        // if doesn't contain sub , then will have to trim it until it fits totally inside S .
        String StringMatcher = strs[0] ;
        for ( int i = 0 ; i < strs.length ; i ++) {
            while ( strs[i].indexOf(StringMatcher) != 0 ) {
                StringMatcher = StringMatcher.substring(0 , StringMatcher.length() - 1) ;
                if ( StringMatcher.length() == 0 ) return NULLSTRING;
            }
        }
        return StringMatcher ;
    }
}
