import java.util.List ;
import java.util.Stack ;
import java.util.ArrayList ;
public class SOLVEDAY9 {
    // QUES 108 . Sorted Array to BST :::
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return new TreeNode() ;

        return formBST(nums,0,nums.length-1) ;
    }
    private TreeNode formBST(int[] nums , int src ,int end) {
        if (src > end)
            return null ;
        int mid = src + (end - src)/2 ;
        TreeNode root = new TreeNode(nums[mid]) ;
        root.left = formBST(nums , src , mid-1) ;
        root.right = formBST(nums , mid+1, end) ;

        return root ;
    }
    // QUES 230 . Kth Smallest Element in BST

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1 ;
        K = k ;
        FindkthSmallest(root) ;
        return val ;
    }

    // Using Global variable :::
    private int val = 0 ;
    private int K   = 0 ;

    private void FindkthSmallest(TreeNode root) {
        if (root == null)
            return ;
        FindkthSmallest(root.left) ;
        K = K - 1 ;
        if (K == 0) {
            val = root.val;
            return;
        }
        FindkthSmallest(root.right) ;
    }

    // Using List ::
    private int FindKthSmallest(TreeNode root, int k) {
        List<Integer> _list_ = new ArrayList<>() ;
        FillList(root,_list_) ;
        return _list_.get(k-1) ;
    }

    private void FillList(TreeNode root, List<Integer> _list_) {
        if (root == null)
            return ;
        FillList(root.left , _list_ ) ;
        _list_.add(root.val) ;
        FillList(root.right , _list_) ;
    }

    // Using Stack ::: Approach naive
    private int _FindKthSmallest_(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>() ;
        FillStack(root,stack) ;

        while (stack.size() > k)
            stack.pop() ;
        return stack.peek() ;
    }

    private void FillStack(TreeNode root, Stack<Integer> stack) {
        if (root == null)
            return ;
        FillStack(root.left , stack) ;
        stack.push(root.val) ;
        FillStack(root.right, stack) ;
    }

    // Using Stack ::: Approach Optimal
    private int KthSMallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>() ;

        while (root != null){
            stack.push(root) ;
            root = root.left ;
        }

        while (k != 0) {
            TreeNode top = stack.pop() ;
            k = k - 1 ;
            if (k == 0)
                return top.val ;
            TreeNode TopRight = top.right ;
            while (TopRight != null){
                stack.push(TopRight) ;
                TopRight = TopRight.left ;
            }
        }
        return -1 ;
    }
}
