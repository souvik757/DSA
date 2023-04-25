import java.util.ArrayList;
import java.util.List;

public class SOLVEDAY7 {
    // QUES 543 . Diameter Of Binary Tree :::
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0 ;
        //return _GetDiameter_(root,0).diameter ;
        return GetDiameter(root).diameter ;
    }
    private Pair<Integer,Integer> GetDiameter(TreeNode root) { // O(n)
        if (root == null) return new Pair<>(0,0) ;
        Pair<Integer,Integer> LeftSubTree  = GetDiameter(root.left ) ;
        Pair<Integer,Integer> RightSubTree = GetDiameter(root.right) ;

        int LeftDiameter  = LeftSubTree.diameter ;
        int RightDiameter = RightSubTree.diameter ;
        int SelfDiameter  = LeftSubTree.height + RightSubTree.height + 1 ;

        int diameter = Math.max(LeftDiameter , Math.max(RightDiameter,SelfDiameter))  ;
        int height   = Math.max(LeftSubTree.height,RightSubTree.height) + 1 ;

        return new Pair<>(diameter,height) ;
    }
    private Pair<Integer,Integer> _GetDiameter_(TreeNode root,int max) { // O(n)
        if (root == null)
            return new Pair<>(0,0) ;
        int Left  = _GetDiameter_(root.left,max).height ;
        int Right = _GetDiameter_(root.right,max).height;
        return new Pair<>(Math.max(max,Left+Right) , Math.max(Left,Right)+1) ;
    }
    // QUES 437 . Path Sum III
    private Integer count = 0 ;
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> _list_ = new ArrayList<>() ;
        _GetSum_(root,_list_,targetSum) ;
        return count ;
    }
    private void _GetSum_(TreeNode root, List<Integer> path, int targetSum) {
        if (root == null) return ;
        path.add(root.val) ;
        _GetSum_(root.left,path,targetSum) ;
        _GetSum_(root.right,path,targetSum) ;
        int SIZE = path.size() ;
        System.out.println("Path : "+path);
        long sum = 0 ;
        for (int i = SIZE -1  ; i >= 0 ; i --) {
            sum += path.get(i) ;
            if (sum == targetSum)
                count++ ;
        }
        System.out.println("Removing : "+path.get(SIZE-1));
        path.remove(SIZE-1) ;
    }
}
