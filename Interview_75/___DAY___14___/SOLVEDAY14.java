import java.util.Arrays;
import java.util.Set ;
import java.util.HashSet ;
import java.util.Map ;
import java.util.HashMap ;

public class SOLVEDAY14 {
    // QUES 3 . Longest Sub String w/o repetation :::
    public int lengthOfLongestSubstring(String s) {
        int MaxLength = Integer.MIN_VALUE ;
        int Index = 0 ;
        int ForwardIndex = 0 ;
        int Length = s.length() ;
        Set<Character> set = new HashSet<>() ;
        while (ForwardIndex < Length) {
            if (!set.contains(s.charAt(ForwardIndex))) {
                set.add(s.charAt(ForwardIndex)) ;
                ForwardIndex ++ ;
                //System.out.println("added : "+set);
                MaxLength = Math.max(MaxLength , set.size()) ;
            }
            else {
                set.remove(s.charAt(Index)) ;
                Index ++ ;
                //System.out.println("removed : "+set);
            }
        }
        return MaxLength ;
    }
    // QUES 16 . 3 Sum Closet :::
    // Brute Force :::
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1] ;
        Arrays.sort(nums) ;

        for (int i = 0 ; i < nums.length-2 ; i ++) {
            int s = i+1 ;
            int e = nums.length-1 ;

            while (s < e) {
                int CurrentSum = nums[i]+nums[s]+nums[e] ;
                if (CurrentSum < target)
                    s++ ;
                else
                    e-- ;
                if(Math.abs(CurrentSum-target) < Math.abs(result-target))
                    result = CurrentSum ;
            }
        }
        return result ;
    }
    // QUES 76 . Minimum Window Sub String ::: Hard
    public String minWindow(String s, String t) {
        int start = 0 ;
        int end = 0 ;
        int MinSize = Integer.MAX_VALUE ;
        Map<Character,Integer> need = new HashMap<>() ;
        for (char ch : t.toCharArray())
            need.put(ch,need.getOrDefault(ch,0)+1) ;
        int needCount = need.size() ;
        System.out.println("Initially need : "+need+"\nneedCount : "+needCount);

        for (int i = 0 ; i < s.length() ; i ++) {
            if (need.containsKey(s.charAt(i))) {
                need.put(s.charAt(i), need.get(s.charAt(i)) - 1);
                if (need.get(s.charAt(i)) == 0)
                    needCount-- ;
            }
            while (end <= i && needCount == 0) {
                if (MinSize > i - end + 1) {
                    MinSize = i - end + 1 ;
                    start = end ;
                }
                if (need.containsKey(s.charAt(end))) {
                    need.put(s.charAt(end) , need.get(s.charAt(end)) + 1) ;
                    if (need.get(s.charAt(end)) > 0)
                        needCount++ ;
                }
                end++ ;
            }
        }
        return (MinSize == Integer.MAX_VALUE) ? "" : s.substring(start,start+MinSize) ;
    }
}
