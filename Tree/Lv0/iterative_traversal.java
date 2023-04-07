package Lv0;

import java.util.Stack;

public class iterative_traversal {
    public static void main(String[] args) {
        helper object = new helper() ;
        TreeFormation.TreeNode root = new TreeFormation.TreeNode() ;
        root = TreeFormation.formTreeByLevel(root) ;
        System.out.print("In-order   : ");
        object._INORDER_(root) ;
        System.out.println();
        System.out.print("Pre-order  : ");
        object._PREORDER_(root) ;
        System.out.println();
        System.out.print("Post-order : ");
        object._POSTORDER_(root) ;
    }
}
class helper{
    public void _INORDER_(TreeFormation.TreeNode root){
        if(root == null)
            return ;
        Stack<TreeFormation.TreeNode> stack = new Stack<>() ;
        TreeFormation.TreeNode current = root ;
        while (current != null || !stack.isEmpty()){
            while(current != null){
                stack.add(current) ;
                current = current.left ;         // Left child
            }
            current = stack.peek() ;
            stack.pop() ;
            System.out.print("->"+current.data); // Visit root
            current = current.right ;            // Right child
        }
    }
    public void _PREORDER_(TreeFormation.TreeNode root){
        if(root == null)
            return ;
        Stack<TreeFormation.TreeNode> stack = new Stack<>() ;
        TreeFormation.TreeNode current = root ;
        while (current != null || !stack.isEmpty()){
            while(current != null){
                System.out.print("->"+current.data); // Visit root
                stack.add(current) ;
                current = current.left ;         // Left child
            }
            current = stack.peek() ;
            stack.pop() ;
            current = current.right ;            // Right child
        }
    }
    public void _POSTORDER_(TreeFormation.TreeNode root){
        Stack<TreeFormation.TreeNode> stack1 = new Stack<>() ;
        Stack<TreeFormation.TreeNode> stack2 = new Stack<>() ;
        if(root == null)
            return ;
        stack1.push(root) ;
        while(!stack1.isEmpty()){
            TreeFormation.TreeNode temp = stack1.pop() ;
            stack2.push(temp) ;
            if(temp.left != null)
                stack1.push(temp.left) ;     // Left child
            if(temp.right != null)
                stack1.push(temp.right) ;    // Right child
        }
        while (!stack2.isEmpty()){
            int val = stack2.pop().data ;
            System.out.print("->"+val) ;
        }
    }
}
