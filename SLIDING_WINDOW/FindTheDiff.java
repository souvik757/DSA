import java.util.Arrays;

public class FindTheDiff {
    public static void main(String[] args) {
        System.out.println(findTheDifference("xabcdef" , "abcdef"));
    }
    public static char findTheDifference(String s, String t) {
        int i = 0 ;
        int j = 0 ;
        char[] sch = s.toCharArray() ;
        char[] tch = t.toCharArray() ;
        Arrays.sort(sch) ;
        Arrays.sort(tch) ;
        while(i < sch.length && j < tch.length){
            if(sch[i] != tch[j]){
                if(sch[i] == tch[j+1])
                    return tch[j] ;
                else
                    return  sch[i] ;
            }
            i++ ;
            j++ ;
        }
        return (i == sch.length) ? tch[t.length()-1] : sch[s.length()-1] ;
    }
}
