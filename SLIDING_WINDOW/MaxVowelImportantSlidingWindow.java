public class MaxVowelImportantSlidingWindow {
    public static void main(String[] args) {
        SOLVE object = new SOLVE() ;
        System.out.println(object.maxVowels("leetcode" ,2));
    }
}
class SOLVE{
    public int maxVowels(String s, int k) {
        int MaxCount = 0 ;
        int left = 0 ;
        int right = 0 ;
        int count = 0 ;
        while(right < s.length()) {
            if(IsVowel(s,right))
                count += 1 ;
            if(right-left+1 < k)
                right = right + 1 ;
            else if(right - left + 1 == k){
                MaxCount = Math.max(MaxCount ,count) ;
                if(IsVowel(s,left))
                    count -= 1 ;
                left++ ;
                right++ ;
            }
        }
        return MaxCount ;
    }
    private boolean IsVowel(String s , int i){
        return s.charAt(i) == 'a' ||
                s.charAt(i) == 'e' ||
                s.charAt(i) == 'i' ||
                s.charAt(i) == 'o' ||
                s.charAt(i) == 'u' ;
    }
}
