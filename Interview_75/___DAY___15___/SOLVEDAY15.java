import java.util.List ;
import java.util.ArrayList ;
public class SOLVEDAY15 {
    // QUES 100 . Same Tree :::
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true ;
        if ((p == null && q != null) || (p != null && q == null))
            return false ;
        boolean Left  = isSameTree(p.left  , q.left) ;
        boolean Right = isSameTree(p.right , q.right) ;
        boolean Current = (p.val == q.val) ;
        return Left && Right && Current ;
    }

    // QUES 101 . Symetric Tree :::
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true ;
        TreeNode p = root.left ;
        TreeNode q = root.right ;
        if (p == null && q == null)
            return true ;
        if((p == null && q != null) || (p != null && q == null))
            return false ;
        if (p.val == q.val)
            return solve(p,q) ;
        return false ;
    }
    private boolean solve(TreeNode p , TreeNode q) {
        // edge cases :::
        if (p == null && q == null)
            return true ;
        if((p == null && q != null) || (p != null && q == null))
            return false ;

        boolean first  = solve(p.left , q.right) ;
        boolean second = solve(p.right ,q.left ) ;
        boolean current = (p.val == q.val) ;

        return first && second && current ;
    }

    // QUES 199 . Right View :::
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>() ;
        if (root == null)
            return answer ;
        PopulateList(root , answer , 0) ;
        return  answer ;
    }

    private void PopulateList(TreeNode root, List<Integer> answer, int level) {
        if (root == null)
            return ;
        if (level == answer.size())
            answer.add(root.val) ;
        PopulateList(root.right , answer , level+1);
        PopulateList(root.left  , answer , level+1);
    }
}
