package Lv1;

import java.util.*;

public class _427_Construct_QuadTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.print("row : ");
        int m = sc.nextInt() ;
        System.out.print("col : ");
        int n = sc.nextInt() ;
        int[][] grid = new int[m][n] ;
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j ++){
                grid[i][j] = sc.nextInt() ;
            }
        }
        SOLVE_427 obj = new SOLVE_427() ;
        QuadNode root = obj.construct(grid) ;
        root.levelOrderTraversalQuadtree(root);
    }
}
class SOLVE_427 {
    public QuadNode construct(int[][] grid) {
        return func(grid,0,0,grid.length) ;
    }

    private QuadNode func(int[][] grid, int row, int col, int length) {
        if(allSame(grid,row,col,length))
            return new QuadNode(grid[row][col] == 1, true) ;

        QuadNode node = new QuadNode(true , false) ;
        node.topLeft     = func(grid , row , col , length/2) ;
        node.topRight    = func(grid , row , col + length/2 , length/2) ;
        node.bottomLeft  = func(grid , row + length/2 , col , length/2) ;
        node.bottomRight = func(grid , row + length/2, col + length/2 , length/2) ;
        return node;
    }

    private boolean allSame(int[][] grid ,int r ,int c, int length){
        for (int i = r ; i < r + length ; i ++){
            for (int j = c ; j < c + length ; j ++){
                if(grid[i][j] != grid[r][c])
                    return false ;
            }
        }
        return true ;
    }
}
class QuadNode {
    public boolean val;
    public boolean isLeaf;
    public QuadNode topLeft;
    public QuadNode topRight;
    public QuadNode bottomLeft;
    public QuadNode bottomRight;


    public QuadNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf, QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public void levelOrderTraversalQuadtree(QuadNode root) {
        List<int[]> list = new ArrayList<>() ;
        Queue<QuadNode> queue = new LinkedList<>() ;
        QuadNode temp = root ;
        queue.add(temp) ;
        while (!queue.isEmpty()) {
            QuadNode top = queue.poll() ;
            list.add(new int[]{(top.isLeaf) ? 1 : 0 ,(top.val) ? 1 : 0}) ;
            if(top.topLeft != null)
                queue.add(top.topLeft) ;
            if(top.topRight != null)
                queue.add(top.topRight) ;
            if(top.bottomLeft != null)
                queue.add(top.bottomLeft) ;
            if(top.bottomRight != null)
                queue.add(top.bottomRight) ;
        }
        for (int[] arr : list)
            System.out.println(Arrays.toString(arr));
    }
}