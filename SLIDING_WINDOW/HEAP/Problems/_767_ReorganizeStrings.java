package HEAP.Problems;

import java.util.*;

public class _767_ReorganizeStrings {
    public static void main(String[] args) {
        solve_767 object = new solve_767() ;
        String input = "" ;
        int a ;
        System.out.println(" 1 : add\n-1 : exit");
        while (!input.equals("@#$$")){
            System.out.print("i/p -> ");
            a = new Scanner(System.in).nextInt() ;
            if(a == 1) {
                System.out.print("s -> ");
                input = new Scanner(System.in).nextLine() ;
                System.out.println(object.reorganizeString(input));
            }
            if(a == -1)
                System.exit(0) ;
        }
    }
}
class solve_767 {
    public String reorganizeString(String s) {

        char extra = '\0' ;
        StringBuilder runningStr = new StringBuilder() ;
        Map<Character,Integer> freqCount = new HashMap<>() ;
        Queue<Character> maxHeap = new PriorityQueue<>((a,b)->freqCount.get(b)-freqCount.get(a)) ;

        for (char ch : s.toCharArray())
            freqCount.put(ch , freqCount.getOrDefault(ch,0)+1) ;
        for (char ch : freqCount.keySet())
            maxHeap.offer(ch) ;

        while (!maxHeap.isEmpty()){
            char top = maxHeap.remove() ;
            int count = freqCount.get(top) - 1 ;
            freqCount.put(top , count) ;
            runningStr.append(top) ;
            if(extra != '\0')
                maxHeap.offer(extra) ;
            if(count > 0)
                extra = top ;
            else
                extra = '\0' ;
        }

        return (extra == '\0') ? new String(runningStr) : "" ;
    }
}