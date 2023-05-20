// Disjoint Set Data Structure 2
import java.util.Map ;
import java.util.HashMap ;
public class _990_SatisfiabilityOfEqn {
    public static void main(String[] args) {
        SOLVE990 object = new SOLVE990() ;
        System.out.println(object.equationsPossible(new String[]{"a==b","b!=a"})) ;
        System.out.println(object.equationsPossible(new String[]{"a==b","b==c","b!=d","a==d"})) ;
    }
}
class SOLVE990 {
    public boolean equationsPossible(String[] equations){
        DisjointSet set = new DisjointSet() ;
        for (int i = 0 ; i < equations.length ; i ++){ // union each '==' characters
            char c1 = equations[i].charAt(0) ;
            char c2 = equations[i].charAt(1) ;
            char c3 = equations[i].charAt(2) ;
            char c4 = equations[i].charAt(3) ;
            if (c2 == '=' && c3 == '=')
                set.getUnion(c1 , c4) ;
        }
        for (int i = 0 ; i < equations.length ; i ++){ // any '!=' characters should not be connected directly or indirectly
            char c1 = equations[i].charAt(0) ;
            char c2 = equations[i].charAt(1) ;
            char c3 = equations[i].charAt(2) ;
            char c4 = equations[i].charAt(3) ;
            if (c2 == '!' && c3 == '=') {
                if(set.isConnected(c1, c4))
                    return false ;
            }
        }
        return true ;
    }
}
class DisjointSet { // -- character sets -- using Maps
    private Map<Character,Character> roots ;
    public DisjointSet() {
        roots = new HashMap<>() ;
        for (int i = 0 ; i <= 26 ; i ++)
            roots.put((char) (i+96) , (char) (i+96)) ;
    }
    public char find(char c){
        return roots.get(c) ;
    }
    public void getUnion(char a,char b){
        char root_a = roots.get(a) ;
        char root_b = roots.get(b) ;
        if (root_a != root_b) {
            for (int i = 0 ; i < roots.size() ; i ++){
                if(roots.get((char)(i+96)) == root_b)
                    roots.put((char)(i+96) , root_a) ;
            }
        }
    }
    public boolean isConnected(char a,char b){
        return roots.get(a) == roots.get(b) ;
    }
}