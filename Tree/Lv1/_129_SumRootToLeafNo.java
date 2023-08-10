package Lv1;
import java.util.List ;
import java.util.ArrayList ;
public class _129_SumRootToLeafNo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        root.ShowByLevel(root) ;
        System.out.println(new solve_129().sumNumbers(root));
        System.out.println(new solve_129_opt().sumNumbers(root));
    }
}
class solve_129{
    public int sumNumbers(TreeNode root){
        int answer = 0 ;
        List<String> list = new ArrayList<>() ;
        StringBuilder stringPath = new StringBuilder() ;
        solve(root,stringPath,list) ;
        for (String str : list)
            answer += Integer.parseInt(str) ;
        return answer ;
    }
    private void solve(TreeNode treeNode , StringBuilder stringPath , List<String> list){
        if(treeNode == null)
            return ;
        if(treeNode.left == null && treeNode.right == null){
            stringPath.append(treeNode.data) ;
            list.add(new String(stringPath)) ;
            stringPath.deleteCharAt(stringPath.length()-1) ;
            return ;
        }
        stringPath.append(treeNode.data) ;
        solve(treeNode.left  , stringPath , list);
        solve(treeNode.right , stringPath , list);
        stringPath.deleteCharAt(stringPath.length()-1) ;

    }
}
class solve_129_opt extends solve_129{
    @Override
    public int sumNumbers(TreeNode root) {

        return recurrsiveSol(root , 0) ;
    }

    private int recurrsiveSol(TreeNode root, int current) {
        if(root == null)
            return 0 ;
        int result = current * 10 + root.data ;
        if(root.left == null && root.right == null)
            return result ;
        return recurrsiveSol(root.left , result)+recurrsiveSol(root.right , result);
    }
}
