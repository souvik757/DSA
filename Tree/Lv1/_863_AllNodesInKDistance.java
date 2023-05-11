package Lv1;
import java.util.* ;
public class _863_AllNodesInKDistance {
    public static void main(String[] args) {

    }
}
class SOLVE863{
    private void MakeParent(TreeNode root , Map<TreeNode , TreeNode> parent){
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;

        while (!queue.isEmpty()){
            TreeNode front = queue.remove() ;
            if(front.left != null){
                parent.put(front.left , front) ;
                queue.add(front.left) ;
            }
            if(front.right != null){
                parent.put(front.right , front) ;
                queue.add(front.right) ;
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent = new HashMap<>() ;
        Map<TreeNode , Boolean> visited = new HashMap<>() ;
        List<Integer> list = new ArrayList<>() ;
        MakeParent(root, parent) ;

        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(target) ;
        visited.put(target , true) ;

        while (!queue.isEmpty()) {
            int size = queue.size() ;
            if(k == 0)
                break ;
            k-- ;
            while (size-->0){
                TreeNode front = queue.remove() ;
                if(front.left != null && visited.get(front.left) == null){
                    queue.add(front.left) ;
                    visited.put(front.left , true) ;
                }
                if(front.right != null && visited.get(front.right) == null){
                    queue.add(front.right) ;
                    visited.put(front.right , true) ;
                }
                if(parent.get(front) != null && visited.get(parent.get(front)) == null){
                    queue.add(parent.get(front)) ;
                    visited.put(parent.get(front) , true) ;
                }
            }
        }

        while (!queue.isEmpty())
            list.add(queue.poll().data) ;

        return list ;
    }
}
