// Disjoint Set Data Structure 3
import java.util.Scanner;
public class _1061_SmallestLexString {
    public static void main(String[] args) {
        String _s1_ = "" ;
        String _s2_ = "" ;
        String base = "" ;
        SOLVE1061 object = new SOLVE1061() ;
        _s1_ = new Scanner(System.in).next() ;
        _s2_ = new Scanner(System.in).next() ;
        base = new Scanner(System.in).next() ;
        System.out.println(object.smallestEquivalentString(_s1_,_s2_,base));
    }
}
class SOLVE1061{
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int N = s1.length();
        String answer = "" ;
        DisjointSetLex object = new DisjointSetLex();
        for (int i = 0 ; i < N ; i ++){
            object.getUnion(s1.charAt(i)-'a' , s2.charAt(i)-'a');
        }
        for (char c : baseStr.toCharArray()){
            answer += (char)(object.find(c-'a')+'a') ;
        }
        return answer ;
    }
}
class DisjointSetLex { // -- character sets -- without using Maps
    private int[] root = new int[26] ; ;
    public DisjointSetLex() {
        for (int i = 0 ; i < 26 ; i ++)
            root[i] = i ;
    }
    public int find(int c){
        return (c == root[c]) ? c : (root[c] = find(root[c]));
    }
    public void getUnion(int a,int b){
        a = find(a) ;
        b = find(b) ;
        if (a != b) {
            if(a < b)
                root[b] = a ;
            else
                root[a] = b ;
        }
        return ;
    }
    public boolean isConnected(int a,int b){
        return root[a] == root[b] ;
    }
}
/*
parker
morris
parser
 *///--> o/p
/*
leetcode
programs
sourcecode
 *///--> o/p
