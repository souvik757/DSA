package Lv1;
import java.util.ArrayList;
import java.util.List;
public class _872_LeafSimilarTrees {
    public static void main(String[] args) {

    }
}
class SOLVE872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // edge cases :::
        if (root1 == null && root2 == null)
            return true ;
        if (root1 == null && root2 != null)
            return false ;
        if (root1 != null && root2 == null)
            return false ;
        // edge cases :::
        List<Integer> list1 = new ArrayList<>() ;
        List<Integer> list2 = new ArrayList<>() ;
        solve(root1 , list1) ;
        solve(root2 , list2) ;
        return list1.equals(list2) ;
    }
    private void solve(TreeNode root1 , List<Integer> list1) {
        if (root1 == null)
            return ;
        if (root1.left == null && root1.right == null)
            list1.add(root1.data) ;
        solve(root1.left  , list1);
        solve(root1.right , list1);
    }
}
