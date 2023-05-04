package Lv1;
public class _1372_LongestZigZagLength {
    public static void main(String[] args) {

    }
}
class SOLVE1372 {
    private int MaxSize ;
    public int longestZigZag(TreeNode root) {
        MaxSize = Integer.MIN_VALUE ;
        getLength(root , false , 0);
        return MaxSize ;
    }
    private void getLength(TreeNode root , boolean Left , int length) {
        if(root == null) {
            MaxSize = Math.max(MaxSize , length-1) ; // as 0 for 1 node :::
            return ;
        }
        if (!Left) {
            getLength(root.left , true , length+1);
            getLength(root.right, false, 1);
        }
        else {
            getLength(root.right, false, length+1);
            getLength(root.left , true , 1);
        }
    }
}
