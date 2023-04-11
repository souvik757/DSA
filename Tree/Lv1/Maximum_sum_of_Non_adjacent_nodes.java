package Lv1;

public class Maximum_sum_of_Non_adjacent_nodes {
    public static void main(String[] args) {
        solution_ object = new solution_() ;
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(null) ;
        root.ShowByLevel(root);
        System.out.println("Max sum : "+object.maxSum(root)) ;
    }
}
class solution_{
    public int maxSum(TreeNode root){
        if(root == null) return -1 ;
        int a = _f_(root).first ;
        int b = _f_(root).second ;
        return Math.max(a,b) ;
    }
    public pairs<Integer,Integer> _f_(TreeNode root){
        if(root == null)
            return new pairs<>(0,0) ;

        pairs<Integer,Integer> pair1 = _f_(root.left) ;
        pairs<Integer,Integer> pair2 = _f_(root.right) ;

        int a = root.data + pair1.second + pair2.second ;
        int b = Math.max(pair1.first,pair1.second) + Math.max(pair2.first,pair2.second) ;
        pairs<Integer,Integer> answer = new pairs<>(a,b) ;

        return answer ;
    }
}
class pairs<K,V>{
    K first ;
    V second ;

    public pairs() {
    }

    public pairs(K first, V second) {
        this.first = first;
        this.second = second;
    }
}
