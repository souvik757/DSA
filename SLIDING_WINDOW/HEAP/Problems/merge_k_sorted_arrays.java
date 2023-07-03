package HEAP.Problems;

import java.util.List ;
import java.util.Queue ;
import java.util.PriorityQueue ;
import java.util.ArrayList ;
public class merge_k_sorted_arrays {
    public static void main(String[] args) {
        SOLVE_mergekarray object = new SOLVE_mergekarray() ;
        System.out.println(object.KSortedArray(new int[][]
                        {
                                {4,5,6} ,
                                {1,2,3,4,5} ,
                                {10,12} ,
                                {0,2,3,4}
                        }
                )
        );
    }
}
class SOLVE_mergekarray {
    private class Node{
        int val ;
        int row ;
        int col ;
        public Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public List<Integer> KSortedArray(int[][] KArrays) {

        int K = KArrays.length ;
        List<Integer> answer = new ArrayList<>();
        Queue<Node> minheap = new PriorityQueue<>((a,b)->(a.val-b.val)) ;

        for (int i = 0 ; i < K ; i ++) // O(K)*O(log K)
            minheap.add(new Node(KArrays[i][0] ,i,0)) ;

        while (!minheap.isEmpty()) { // O(N) , N is the total number of elements all over the K arrays

            Node temp = minheap.poll() ;
            int size = KArrays[temp.row].length ;
            int row = temp.row ;
            int col = temp.col ;

            answer.add(temp.val); // O(log K)
            if (col+1 < size)
                minheap.add(new Node(KArrays[row][col+1] , row , col+1)) ;
        } // O(Nlog K)
        // runtime : ~ O(N log k) { >= O(k log k) }
        return answer ;
    }
}