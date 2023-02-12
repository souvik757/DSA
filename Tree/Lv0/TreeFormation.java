package Lv0;

/*

  : Tree Formation and Level Order Traversal :

               root
              .   .
             .     .
            .       .
          left     right


  Node formTree(Node root){
  int val = sc.nextInt() ;
  root.left = formTree(root.left) ;
  root.right = formTree(root.right) ;
  }

  Input should be given with an order as follows -->
  1
  3
  7
  13
  -1
  -1
  -1
  11
  -1
  -1
  5
  17
  -1
  -1
  -1

  // '-1' for : null entry

  Tree should be printed as -->

  1
  3 5
  7 11 17
  13

               root
                1       -->   level 0
               . .
              .   .
             3     5    -->   level 1
            . .    .
           .   .   .
          7    11  17   -->   level 2
         .
        .
       13               -->   level 3

--> Max Depth of this binary tree : 4
LevelOrder(level-wise) : 1 3 5 7 11 17 13
PreOrder(VLR)   : 1 3 7 13 11 5 17
InOrder(LVR)    : 13 7 3 11 1 17 5
PostOrder(LRV)  : 13 7 11 3 17 5 1
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TreeFormation {
    static Scanner sc = new Scanner(System.in) ;
    public static class TreeNode{
        public int data ;
        public TreeNode left ;
        public TreeNode right ;

        public TreeNode(int data){
            this.data = data ;
            left = null ;
            right = null ;
        }
    }

// Form tree by level wise :
   public static TreeNode formTreeByLevel(TreeNode root){
       Queue<TreeNode> queue = new LinkedList<>() ;
       System.out.print("Enter data for root : ");
       int data ;
       data = sc.nextInt() ;
       root = new TreeNode(data) ;
       queue.add(root) ;

       while (!queue.isEmpty()){
           TreeNode temp = queue.peek() ;
           queue.poll() ;

           System.out.print("Enter data for left node of "+temp.data+" : ") ;
           int LeftData = sc.nextInt() ;

           if(LeftData != -1){
               temp.left = new TreeNode(LeftData) ;
               queue.add(temp.left) ;
           }


           System.out.print("Enter data for right node of "+temp.data+" : ");
           int RightData = sc.nextInt() ;

           if(RightData != -1){
               temp.right = new TreeNode(RightData) ;
               queue.add(temp.right) ;
           }
           LevelOrderTraversal(root);
       }
       return root ;
   }





// Form tree by recursion :
    public static TreeNode formTree(TreeNode root){
        System.out.print("Enter value : ") ;
        int val = sc.nextInt() ;
        System.out.println() ;
        root = new TreeNode(val) ;
        if(root.data == -1)
            return null ;
         // Value for left node :
        System.out.println("Enter value of left node : ") ;
        root.left = formTree(root.left) ;
        // Value for right node :
        System.out.println("Enter value of right node : ") ;
        root.right = formTree(root.right) ;

        return root ;
    }


    // Reverse Level Order :
    public static void ReverseLevelOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>() ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;

        while(!queue.isEmpty()){
            TreeNode temp = queue.peek() ;
            queue.poll() ;
            stack.push(temp) ;


            if(temp.left != null)
                queue.add(temp.left) ;
            if(temp.right != null)
                queue.add(temp.right) ;

        }

        while (!stack.isEmpty()){
            TreeNode temp = stack.peek() ;
            System.out.println(temp.data+" ");
            stack.pop() ;
        }
    }


    // Level Order :
    public static void LevelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        queue.add(null) ;

        while (!queue.isEmpty()){
            TreeNode temp = queue.peek() ;
            queue.poll() ;

            if(temp == null){
                System.out.println() ;
                if(!queue.isEmpty())
                    queue.add(null) ;
            }else{
                System.out.print(temp.data+" ") ;
                if(temp.left != null)
                    queue.add(temp.left) ;
                if(temp.right != null)
                    queue.add(temp.right) ;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = null ;
        //root = formTree(root) ;

        root = formTreeByLevel(root);
        System.out.println("Tree actual : ") ;
        LevelOrderTraversal(root) ;

        System.out.println("Reverse Tree : ") ;
        ReverseLevelOrder(root) ;
    }
}