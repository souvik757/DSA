package Lv1;

import Lv0.TreeFormation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _avarage_of_levels_ {
    public static void main(String[] args) {
        helper _helper_ = new helper() ;
        TreeFormation.TreeNode root = TreeFormation.formTreeByLevel(null) ;
        System.out.println(_helper_._FindAvg_(root));
    }

}
class helper{
    List<Integer> avarage = new ArrayList<>() ;
    public List<Integer> _FindAvg_(TreeFormation.TreeNode root){
        if(root==null)
            return avarage ;
        Queue<TreeFormation.TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;

        while (!queue.isEmpty()){
            int _size_ = queue.size() ;
            int sum = 0 ;
            for(int i = 0 ; i < _size_ ; i++){
                TreeFormation.TreeNode temp = queue.poll() ;
                sum += temp.data ;
                if(temp.left != null)
                    queue.add(temp.left) ;
                if(temp.right != null)
                    queue.add(temp.right) ;
            }
            avarage.add(sum/_size_) ;
        }
        return avarage ;
    }
}
