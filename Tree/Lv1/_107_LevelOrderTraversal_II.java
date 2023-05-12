package Lv1;

import java.util.* ;
public class _107_LevelOrderTraversal_II {
    public static void main(String[] args) {
        SOLVE107 object = new SOLVE107() ;
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        root.ShowByLevel(root);
        object.levelOrderBottom(root) ;
    }
}
class SOLVE107{
    public void levelOrderBottom(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ; // indicates completion of level

        while (!queue.isEmpty()){
            TreeNode temp = queue.peek() ;
            queue.poll() ;

            if(temp == null){
                System.out.println() ;
                if(!queue.isEmpty())
                    queue.add(null) ; // indicates completion of level
            }else{
                System.out.print(temp.data+" ") ;
                if(temp.left != null)
                    queue.add(temp.left) ;
                if(temp.right != null)
                    queue.add(temp.right) ;
            }
        }
    }
}
