import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
//Input
//        ["LockingTree", "lock", "unlock", "unlock", "lock", "upgrade", "lock"]
//        [[[-1 0 0 1 1 2 2]], [2, 2], [2, 3], [2, 2], [4, 5], [0, 1], [0, 1]]
//Output
//        [null, true, false, true, true, true, false]
public class Main {
    public static void main(String[] args) {
        System.out.println("2 <= n <= 2000");
        System.out.println("0 <= parent[i] <= n - 1 for i != 0\n"+"parent[0] == -1");
        System.out.println("\n" +
                "lock(int num, int user)\n" +
                "unlock(int num, int user)\n" +
                "upgrade(int num, int user)");
        int n = new Scanner(System.in).nextInt() ;
        int num ;
        int user ;
        int[] parent = new int[n] ;
        for (int i = 0 ; i < n ; i++)
            parent[i] = new Scanner(System.in).nextInt() ;
        System.out.println(Arrays.toString(parent));
        LockingTree obj = new LockingTree(parent);

        String operation = "" ;
        while (!operation.equals("stop")){
            System.out.print("-> ");
            operation = new Scanner(System.in).next() ;
            switch (operation) {
                case "lock()" -> {
                    System.out.print("num ");
                    num = new Scanner(System.in).nextInt();
                    System.out.print("user ");
                    user = new Scanner(System.in).nextInt();
                    boolean param_1 = obj.lock(num, user);
                    System.out.println(param_1);
                }
                case "unlock()" -> {
                    System.out.print("num ");
                    num = new Scanner(System.in).nextInt();
                    System.out.print("user ");
                    user = new Scanner(System.in).nextInt();
                    boolean param_2 = obj.unlock(num, user);
                    System.out.println(param_2);
                }
                case "upgrade()" -> {
                    System.out.println("Not functional !!");
                    num = new Scanner(System.in).nextInt();
                    System.out.print("user ");
                    user = new Scanner(System.in).nextInt();
                    boolean param_3 = obj.upgrade(num, user);
                    System.out.println(param_3);
                }
                default -> System.exit(0);
            }
        }
    }
}
// JUSPAY HACK ROUND 1 :::
// Tree Of Space :::
class LockingTree{
    int[] parent ;
    int[] locked ;
    List<Integer>[] child ;

    public LockingTree(int[] parent) {
        this.parent = parent ;
        this.locked = new int[parent.length] ;
        this.child = new ArrayList[parent.length] ;

        for (int i = 0 ; i < parent.length ; i ++)
            child[i] = new ArrayList<>() ;

        for (int i = 1 ; i < parent.length ; i ++)
            child[parent[i]].add(i) ;
    }

    public boolean lock(int num, int user) {
        if(locked[num] == 0)// if unlocked
        {
            locked[num] = user ;
            return true ;
        }
        return false ;
    }

    public boolean unlock(int num, int user) {
        if(locked[num] == user)// if locked by user
        {
            locked[num] = 0;
            return true ;
        }
        return false ;
    }

    public boolean upgrade(int num, int user) {
        if(locked[num] != 0 || !HasAnyUnlockedParent(num) || !HasLockedChild(num))
            return false ;
        UnlockAll(num);
        locked[num] = user ;
        return true ;
    }
    private boolean HasAnyUnlockedParent(int num){
        int ancester = parent[num] ;
        while (ancester != -1){
            if(locked[ancester] != 0)
                return false ;
            ancester = parent[ancester] ;
        }
        return true ;
    }
    private boolean HasLockedChild(int num){
        if(locked[num] != 0)
            return true ;
        for(int children : child[num]){
            if(HasLockedChild(children))
                return true ;
        }
        return false ;
    }
    private void UnlockAll(int num){
        locked[num] = 0 ;
        for (int descendant : child[num])
            UnlockAll(descendant) ;
    }
}
