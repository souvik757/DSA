package Lv1;
import java.util.*;


public class Kth_ancestor {
	public static void main(String[] args){
		TreeNode root = new TreeNode() ;
		root = root.FormTreeByLevel(null) ;
		root.ShowByLevel(root) ;
		System.out.print("NODE : ") ;
		int _NODE_ = new Scanner(System.in).nextInt() ;
		System.out.print("K : ") ;
		int _K_ = new Scanner(System.in).nextInt() ;
		solutionOPTIMIZED object = new solutionOPTIMIZED(_K_) ;
		if(object._Kth_ancestor_(root,_NODE_))
			System.out.println("Doesn't exist !") ;
		else
			System.out.print(" is "+_K_+" ancestor of "+_NODE_);

		solutionBRUTEFORCE _object_ = new solutionBRUTEFORCE(_K_) ;
		System.out.println(_object_._Kth_ancestor_(root,_NODE_)) ;
	}
}
class TreeNode{	// FormTreeByLevel(root) ShowByLevel(root)
	int data ;
	TreeNode left ;
	TreeNode right ;
	public TreeNode(){
		left = null ;
		right = null ;
	}
	public TreeNode(int data){
		this.data = data ;
		left = null ;
		right = null ;
	}
	public TreeNode FormTreeByLevel(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>() ;
		System.out.print("Enter value of root : ") ;
		int val = new Scanner(System.in).nextInt() ;
		root = new TreeNode(val);
		queue.add(root) ;
		
		while(!queue.isEmpty()){
			TreeNode front = queue.poll() ; // retrieves & removes front node from queue 
			
			System.out.print("Enter value for left node of "+front.data+" :") ;
			int LEFT = new Scanner(System.in).nextInt() ;
			if(LEFT != -1){
				front.left = new TreeNode(LEFT) ;
				queue.add(front.left) ;
			}
			System.out.print("Enter value for right node of "+front.data+" :") ;
			int RIGHT = new Scanner(System.in).nextInt() ;
			if(RIGHT != -1){
				front.right = new TreeNode(RIGHT) ;
				queue.add(front.right) ;
			}
		}
		return root;
	}
	public void ShowByLevel(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>() ;
		queue.add(root) ;
		queue.add(null) ;
		
		while(!queue.isEmpty()){
			TreeNode front = queue.poll() ;
			if(front == null){
				System.out.println() ;
				if(!queue.isEmpty())
					queue.add(null) ;
			}
			else{
				System.out.print("->"+front.data) ;
				if(front.left != null)
					queue.add(front.left) ;
				if(front.right != null)
					queue.add(front.right) ;
			}
		}
	}
	public void ShowInorder(TreeNode root){// L V R
		if(root == null) return ;

		ShowInorder(root.left) ;
		System.out.print("-> "+root.data) ;
		ShowInorder(root.right) ;
	}
	public void ShowPreOrder(TreeNode root){ // V L R
		if(root == null) return ;

		System.out.print("-> "+root.data) ;
		ShowInorder(root.left) ;
		ShowInorder(root.right) ;
	}
	public void ShowPostOrder(TreeNode root){ // L R V
		if(root == null) return ;

		ShowInorder(root.left) ;
		ShowInorder(root.right) ;
		System.out.print("-> "+root.data) ;
	}
}

class solutionOPTIMIZED{// _Kth_ancestor_(root,NODE,K)
    private int K ;
	public solutionOPTIMIZED(int K){
		this.K = K ;
	}
	public boolean _Kth_ancestor_(TreeNode root,int NODE){
		// base case 
		if(root == null)
			return false ;
		if(root.data == NODE){
			K = K - 1 ;
			return true ;
		}
		else{
			boolean LEFT = _Kth_ancestor_(root.left,NODE) ;
			if(LEFT){
				if(K == 0){
					System.out.print(root.data);
					return false ;
				}
				K = K - 1 ;
				return true ;
			}
			boolean RIGHT = _Kth_ancestor_(root.right,NODE) ;
			if(RIGHT){
				if(K == 0){
					System.out.print(root.data);
					return false ;
				}
				K = K - 1 ;
				return true ;
			}
		}
		
		return false ;
	}
}
class solutionBRUTEFORCE{
	private int K ;
	private List<List<Integer>> answer ;
	private List<Integer> _list_ ;
	public solutionBRUTEFORCE(int K){
		this.K = K ;
	}
	public int _Kth_ancestor_(TreeNode root, int NODE){
		_list_ = new ArrayList<>() ;
		answer = new ArrayList<>() ;
		_make_path_(root , NODE) ;
		System.out.println();
		System.out.println(answer);
		List<Integer> list = new ArrayList<>(answer.get(0)) ;
		list.remove(list.size()-1) ;
		int n = list.size()-1 ;
		int i = n - K ;


		return list.get(i);

	}
	private void _make_path_(TreeNode root, int NODE){
		if(root == null)
			return ;
		if(root.data == NODE) {
			_list_.add(root.data) ;
			answer.add(new ArrayList<>(_list_));
			return ;
		}
		_list_.add(root.data) ;
		_make_path_(root.left , NODE) ;
		_make_path_(root.right , NODE) ;
		_list_.remove(_list_.size() - 1) ;
	}
}