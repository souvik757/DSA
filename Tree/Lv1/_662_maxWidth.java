package Lv1;
import java.util.LinkedList;
import java.util.Queue;

public class _662_maxWidth {
    public static void main(String[] args) {
        solve_662 object = new solve_662() ;
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        root.ShowByLevel(root) ;
        System.out.println(object.widthOfBinaryTree(root));
    }
}
class solve_662 {
    private int maxWidth = Integer.MIN_VALUE ;
    public int widthOfBinaryTree(TreeNode root) {

        Queue<pair<Integer,TreeNode>> queue = new LinkedList<>() ;
        fillIndexByLevel(queue,root) ;

        return maxWidth ;
    }

    private void fillIndexByLevel(Queue<pair<Integer,TreeNode>> queue, TreeNode root) {
        queue.offer(new pair<>(0,root)) ;
        while (!queue.isEmpty()){
            int size = queue.size() ;
            int start = 0 ;
            int end = 0 ;
            for (int i = 0 ; i < size ; i ++){
                pair<Integer,TreeNode> top = queue.poll() ;
                if(top != null) {
                    int index = top.index;
                    TreeNode treeNode = top.node;
                    if (i == 0)
                        start = index;
                    if (i == size - 1)
                        end = index;
                    if (treeNode.left != null)
                        queue.offer(new pair<>(2 * index + 1, treeNode.left));
                    if (treeNode.right != null)
                        queue.offer(new pair<>(2 * index + 2, treeNode.right));
                }
            }
            maxWidth = Math.max(maxWidth , end-start+1) ;
        }
    }
    static class pair<K,V> {
        K index ;
        V node ;

        public pair(K index, V node) {
            this.index = index;
            this.node = node;
        }
    }
}