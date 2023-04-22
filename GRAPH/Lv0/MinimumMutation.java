import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

// Yet to be solved !
public class MinimumMutation {
    public static void main(String[] args) {
        solutionG25 object = new solutionG25() ;
        System.out.println(object.minMutation("AACCGGTT" ,"AAACGGTA" ,
                new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }
}
class solutionG25{
    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean Valid = false ;
        for ( String str : bank ) {
            if (str.equals(endGene)) {
                Valid = true;
                break;
            }
        }
        if(!Valid) return -1 ;
        Set<String> _set_ = new HashSet<>() ;
        Queue<String> queue = new LinkedList<>() ;
        queue.add(startGene) ;
        _set_.add(startGene) ;
        int mutations = 0 ;
        while (!queue.isEmpty()) {
            mutations++ ;
            int SIZE = queue.size() ;
            for (int index = 0 ; index < SIZE ; index ++) {
                String FRONT = queue.remove() ;
                for (int i = 0 ; i < bank.length ; i++) {
                    if(!_set_.contains(bank[i])) {
                        if(CanTransformInOneMove(FRONT , bank[i])) {
                            if(bank[i].equals(endGene))
                                return mutations   ;
                            _set_.add(bank[index]) ;
                            queue.add(bank[i])     ;
                        }
                    }
                }
            }
        }

        return -1 ;
    }
    private boolean CanTransformInOneMove(String a,String b) {
        int moves = 0 ;
        for ( int i = 0 ; i < a.length() ; i ++ ) {
            if ( a.charAt(i) != b.charAt(i) )
                moves++ ;
        }
        return moves == 1 ;
    }
}
