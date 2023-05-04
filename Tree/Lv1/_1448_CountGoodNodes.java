package Lv1;
import com.sun.source.tree.Tree;

import java.util.List ;
import java.util.ArrayList ;
public class _1448_CountGoodNodes {
    public static void main(String[] args) {

    }
}
class SOLVE1448 {
    private int count ;
    public int goodNodes(TreeNode root) {
        if (root == null)
            return -1 ;
        List<Integer> list = new ArrayList<>() ;
        count = 0 ;
        int maxSeen = Integer.MIN_VALUE ;
        count(root , maxSeen) ;
        System.gc() ;
        return count ;
    }
    private void count(TreeNode root, int maxSoFar) {
        if (root == null) {
            return;
        }
        if (root.data > maxSoFar) {
            maxSoFar = root.data;
            count++;
        }
        count(root.left, maxSoFar);
        count(root.right, maxSoFar);
    }

    private void count_brute(TreeNode root , List<Integer> list){
        if(root == null)
            return ;
        list.add(root.data) ;
        if(ishavegreater(list , root.data))
            count++ ;
        count_brute(root.left  , list) ;
        count_brute(root.right , list) ;
        list.remove(list.size()-1) ;
    }

    private boolean ishavegreater(List<Integer> list , int data) {
        if(list.size() == 1)
            return true ;
        for (int i : list) {
            if (i > data)
                return false ;
        }
        return true ;
    }
}
