package Lv1;
import java.util.* ;

public class Tree_from_IN_PRE {
    public static void main(String[] args) {
        solutionT105 object = new solutionT105() ;
        int[] pre_order = new int[]{3,9,20,15,7} ;
        int[] in_order  = new int[]{9,3,15,20,7} ;
        TreeNode root   = object.buildTree(pre_order, in_order) ;
        System.out.print("post order : ");
        root.ShowPostOrder(root) ;
        System.out.println();
        root.ShowByLevel(root) ;
    }
}
class solutionT105 {
    private int preOrderIndex = 0 ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> get_index = new HashMap<>() ;
        for(int i = 0 ; i < inorder.length ; i++)
            get_index.put(inorder[i] , i) ;

        return build(preorder, 0, inorder.length-1 , get_index) ;
    }
    private TreeNode build(int[] preorder, int inorder_start, int inorder_end, Map<Integer, Integer> get_index) {
        if(preOrderIndex == preorder.length || inorder_start > inorder_end)
            return null ;
        int val = preorder[preOrderIndex++] ;
        TreeNode root = new TreeNode(val) ;
        int split = get_index.get(val) ;
        // go for left subtree in Inorder =>
        root.left = build(preorder,inorder_start, split - 1, get_index);
        // go for right subtree in Inorder =>
        root.right = build(preorder, split + 1, inorder_end, get_index);

        return root ;
    }
}
