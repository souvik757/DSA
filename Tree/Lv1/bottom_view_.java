package Lv1;

import java.util.*;

public class bottom_view_ {
    public static void main(String[] args) {
        _BOTTOM_ bottom_ = new _BOTTOM_() ;
        TreeNode root = new TreeNode() ;
        root = root.FormTreeByLevel(root) ;
        bottom_._bottom_view_traverse_(root);
    }
}
class _BOTTOM_{
    public void _bottom_view_traverse_(TreeNode root) {
        TreeMap<Integer, TreeNode> map = new TreeMap<>();
        Queue<QueueObj> queue = new LinkedList<>();
        if (root == null)
            return;
        else
            queue.add(new QueueObj(root, 0)) ;
        while (!queue.isEmpty()) {
            QueueObj temp = queue.remove() ;
            map.put(temp.hd, temp.node);
            if (temp.node.left != null)
                queue.add(new QueueObj(temp.node.left, temp.hd - 1));
            if (temp.node.right != null)
                queue.add(new QueueObj(temp.node.right, temp.hd + 1));
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            ans.add(entry.getValue().data);
        }
        System.out.println(ans);
    }
}
