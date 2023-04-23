import java.util.Map     ;
import java.util.HashMap ;
public class SOLVEDAY5 {
    // QUES 2131 . Longest Palindrome By Concatenating two words :::
    public int longestPalindrome(String[] words) {
        Map<String,Integer> _map_ = new HashMap<>() ;
        int NUM   = 0 ;
        int COUNT = 0 ;
        for (String str : words) {
            String reverse = str.charAt(1)+""+str.charAt(0) ;
            if (_map_.getOrDefault(reverse,0) > 0){
                NUM ++ ;
                _map_.put(reverse , _map_.getOrDefault(reverse,0) - 1) ;
                if (reverse.equals(str))
                    COUNT -- ;
            }
            else {
                _map_.put(str , _map_.getOrDefault(str,0) + 1) ;
                if (reverse.equals(str))
                    COUNT ++ ;
            }
        }

        return 4*NUM + (COUNT!=0 ? 2 : 0) ;
    }
    // QUES 621 . Task Scheduler
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char ch: tasks)
            count[ch-'A']++;
        int max = 0;
        int C = 1;
        for (int i=0; i<26; i++) {
            if (count[i] == 0)
                continue;
            if (max < count[i]) {
                max = count[i];
                C = 1;
            }
            else if (count[i] == max)
                C++;
        }
        int space = ((n + 1) * (max - 1)) + C;
        return (space < tasks.length) ? tasks.length : space;
    }
}
