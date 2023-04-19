package Lv1;

import java.util.* ;

public class Tree_from_IN_POST {
    public static void main(String[] args) {
        solutionT106 object = new solutionT106() ;
        int[] post_order = new int[]{9,15,7,20,3} ;
        int[] in_order   = new int[]{9,3,15,20,7} ;
        TreeNode root = object.buildTree(post_order, in_order) ;
        System.out.print("pre order : ") ;
        root.ShowPreOrder(root) ;
        System.out.println() ;
        root.ShowByLevel(root) ;
    }
}
class solutionT106{
    private Map<Integer,Integer> get_index = new HashMap<>();
    public TreeNode buildTree(int[] postOrder, int[] inorder) {
        int size = inorder.length ;
        for(int i = 0 ; i < inorder.length ; i++)
            get_index.put(inorder[i] , i) ;

        return build(postOrder, 0, size-1 , 0, size-1) ;
    }

    private TreeNode build(int[] post_order, int postorder_start, int postorder_end,
                           int inorder_start, int inorder_end) {
        if(postorder_start > postorder_end || inorder_start > inorder_end)
            return null ;
        TreeNode root = new TreeNode(post_order[postorder_end]) ;
        int rootIndex = get_index.get(post_order[postorder_end]) ;
        int num_at_left = rootIndex - inorder_start ;

        root.left = build(post_order , postorder_start , postorder_start+num_at_left-1 ,
                inorder_start , rootIndex - 1) ;
        root.right = build(post_order , postorder_start+num_at_left , postorder_end-1 ,
                rootIndex+1 , inorder_end) ;

        return root ;
    }
}
