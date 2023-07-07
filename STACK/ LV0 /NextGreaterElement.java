import java.util.Arrays;
import java.util.Stack ;
public class NextGreaterElement {
    public static void main(String[] args) {
        Solution_739 object = new Solution_739() ;
        System.out.println(Arrays.toString(object.nextGreater(new int[]{
                73,74,75,71,69,72,76,73
        })));
        System.out.println(Arrays.toString(object.nextGreater(new int[]{
                30,40,50,60
        })));
        System.out.println(Arrays.toString(object.nextGreater(new int[]{
                30,60,90
        })));
    }
}
class Solution_739 {
    private class node<K,V> {
        K index ;
        V val ;
        public node(K index, V val) {
            this.index = index;
            this.val = val;
        }

    }
    private final node<Integer,Integer> cap  = new node<>(0,Integer.MAX_VALUE) ;
    public int[] nextGreater(int[] numbs) {
        int[] answer = new int[numbs.length] ;
        Stack<node<Integer,Integer>> stack = new Stack<>() ;
        stack.push(cap) ;
        for (int i = numbs.length-1 ; i>=0 ; i--){
            int current = numbs[i] ;
            while (stack.peek().val <= current)
                stack.pop() ;
            answer[i] = (stack.peek().index == 0) ? 0 : stack.peek().index - i ;
            stack.push(new node<>(i,current)) ;
        }

        return answer ;
    }
}