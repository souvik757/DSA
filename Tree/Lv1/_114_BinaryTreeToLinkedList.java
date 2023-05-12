package Lv1;

import Lv0.TreeFormation;

public class _114_BinaryTreeToLinkedList {
    public static void main(String[] args) {

    }
}
class SOLVE114 {
    public void flatten(TreeNode root) {
        TreeNode temp = root ;

        while (temp != null){
            if(temp.left == null){
                temp = temp.right ;
            }
            else{
                TreeNode prev = temp.left ;
                while (prev.right != null){
                    prev = prev.right ;
                }
                prev.right = temp.right ;
                temp.right = temp.left ;
                temp.left = null ;
            }
        }
    }
}
