import java.util.*;

public class open_locks {
    public static void main(String[] args) {
        solutionG26 object = new solutionG26() ;
        System.out.println("Minimum turns to unlock the lock =>"+object.openLock(new String[]{
                "0201","0101","0102","1212","2002"
        } , "0202"));
    }
}
class solutionG26{
    public int openLock(String[] deadends, String target) {
        int Steps = 0 ;
        HashSet<String> visited   = new HashSet<>() ;
        HashSet<String> DeadLocks = new HashSet<>() ;
        for(String DL : deadends)
            DeadLocks.add(DL) ;
        Queue<String> queue = new LinkedList<>() ;
        queue.add("0000") ;
        while (!queue.isEmpty()){
            int size = queue.size() ;
            while (size-->0){
                String front = queue.remove() ;
                if(DeadLocks.contains(front))
                    continue ;
                if(target.equals(front))
                    return Steps ;
                for (int i = 0 ; i < front.length() ; i++){
                    String upward = moveUp(front , i) ;
                    if(!visited.contains(upward)){
                        visited.add(upward) ;
                        queue.add(upward) ;
                    }
                    String downWard = moveDown(front , i) ;
                    if(!visited.contains(downWard)){
                        visited.add(downWard) ;
                        queue.add(downWard) ;
                    }
                }
            }
            Steps++ ;
        }
        return -1 ;
    }

    private String moveDown(String front, int i) {
        char[] ch = front.toCharArray() ;
        if (ch[i] == '0')
            ch[i] = '9' ;
        else
            ch[i] -= 1 ;
        return String.valueOf(ch);
    }

    private String moveUp(String front, int i) {
        char[] ch = front.toCharArray() ;
        if (ch[i] == '9')
            ch[i] = '0' ;
        else
            ch[i] += 1 ;
        return String.valueOf(ch);
    }
}
