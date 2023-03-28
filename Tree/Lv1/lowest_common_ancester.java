package Lv1;

import Lv0.TreeFormation;

public class lowest_common_ancester {
    public static void main(String[] args) {
        lowest_common_ancester result = new lowest_common_ancester() ;
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        TreeFormation.TreeNode node1 = new TreeFormation.TreeNode(12) ;
        TreeFormation.TreeNode node2 = new TreeFormation.TreeNode(23) ;
        root = TreeFormation.formTreeByLevel(root) ;
        System.out.println("Lowest Common Ancester -> "+result._find_lca(root , node1 , node2).data);
    }

    public TreeFormation.TreeNode _find_lca(TreeFormation.TreeNode root , TreeFormation.TreeNode node1 , TreeFormation.TreeNode node2){
        if(root == null)
            return null ;
        if(root.data == node1.data || root.data == node2.data)
            return root ;

        TreeFormation.TreeNode LEFT = _find_lca(root.left , node1 , node2) ;
        TreeFormation.TreeNode RIGHT = _find_lca(root.right , node1 , node2) ;

        if(LEFT != null && RIGHT != null)
            return root ;
        else if (LEFT != null && RIGHT == null)
            return LEFT ;
        else if(LEFT == null && RIGHT != null)
            return RIGHT ;
        else
            return null ;
    }
}
