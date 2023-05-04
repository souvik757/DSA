package Lv1;
import java.util.* ;
public class _1161_MaxLvSum {
    public static void main(String[] args) {

    }
}
class SOLVE1161{
    private int MaxSum ;
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0 ;
        MaxSum = Integer.MIN_VALUE ;
        TreeMap<Integer,Integer> map = new TreeMap<>() ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        int sum = 0 ;
        int lv = 0 ;
        Pair<Integer,Integer> pair = new Pair<>();
        queue.add(root) ;
        queue.add(null) ;
        while (!queue.isEmpty()) {
            TreeNode front = queue.remove() ;
            if (front == null) {
                if(MaxSum < sum) {
                    MaxSum = Math.max(MaxSum, sum);
                    pair.add(MaxSum , lv);
                }
                sum = 0 ;
                lv = lv + 1 ;
                if(!queue.isEmpty())
                    queue.add(null) ;
            }
            else {
                sum += front.data ;
                if(front.left != null)
                    queue.add(front.left) ;
                if(front.right != null)
                    queue.add(front.right) ;
            }
        }
        return pair.lv ;
    }
}
class Pair<K,V> {
    K sum ;
    V lv ;

    public Pair() {
    }

    public Pair(K sum, V lv) {
        this.sum = sum;
        this.lv = lv;
    }
    public void add(K sum , V lv){
        this.sum = sum ;
        this.lv = lv ;
    }
}