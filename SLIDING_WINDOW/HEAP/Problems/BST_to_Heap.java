package HEAP.Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class BST_to_Heap {
    public static void main(String[] args) {
        SOLVE_BST_TO_HEAP obj = new SOLVE_BST_TO_HEAP() ;
        TreeNode BstRoot = new TreeNode(-1) ;
        BstRoot = BstRoot.CreateByLevel(BstRoot) ;
        BstRoot.ShowByLevel(BstRoot) ;
        System.out.print("-> maxheap\n-> minheap\n");
        System.out.print("Choice  : ");
        String choice = "" ;
        choice = new Scanner(System.in).nextLine() ;
        switch (choice){
            case "minheap" :
                BstRoot =  obj.minHeap(BstRoot) ;
                BstRoot.ShowByLevel(BstRoot) ;
                break ;
            case "maxheap" :
                BstRoot =  obj.maxHeap(BstRoot) ;
                BstRoot.ShowByLevel(BstRoot) ;
                break ;
            case "stop" :
                System.exit(0);
                break ;
            default :
                System.out.println("error !");
                break ;
        }
    }
}
class SOLVE_BST_TO_HEAP {
    public TreeNode minHeap(TreeNode bst_root){
        List<Integer> _inorder_ = INORDER(bst_root) ;
        System.out.println(_inorder_);
        bst_root =  to_minheap(bst_root , _inorder_ , new AtomicInteger(0)) ;
        return bst_root ;
    }
    public TreeNode maxHeap(TreeNode bst_root){
        List<Integer> _inorder_ = INORDER(bst_root) ;
        int index = _inorder_.size() - 1 ;
        to_maxheap(bst_root , _inorder_ , new AtomicInteger(index));
        return bst_root ;
    }
    private TreeNode to_minheap(TreeNode root , List<Integer> inorder , AtomicInteger index){
        if(root == null)
            return null ;
        root.val = inorder.get(index.getAndIncrement()) ;

        root.left =  to_minheap(root.left  , inorder , index);
        root.right =  to_minheap(root.right , inorder , index);

        return root ;
    }
    private void to_maxheap(TreeNode root , List<Integer> inorder , AtomicInteger index){
        if(root == null)
            return ;
        root.val = inorder.get(index.getAndDecrement()) ;
        to_maxheap(root.left  , inorder , index);
        to_maxheap(root.right , inorder , index);
    }
    private List<Integer> INORDER(TreeNode root){
        List<Integer> answer = new ArrayList<>() ;
        if(root == null)
            return answer ;
        Stack<TreeNode> stack = new Stack<>() ;
        TreeNode current = root ;
        while (current != null || !stack.isEmpty()){
            while(current != null){
                stack.add(current) ;
                current = current.left ;
            }
            current = stack.pop() ;
            answer.add(current.val);
            current = current.right ;
        }
        return answer ;
    }
}