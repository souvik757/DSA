package Problems;

import TrieUtils.Trie;

import java.util.List;
import java.util.ArrayList;

public class _212_WordSearch_II {
    public static void main(String[] args) {
        solve_212 object = new solve_212() ;
        System.out.println(object.findWords(new char[][]{
                {'O','A','A','N'} ,
                {'E','T','A','E'} ,
                {'I','H','K','R'} ,
                {'I','F','L','V'}
        } , new String[]{
                "OATH","PEA","EAT","RAIN"
        }));
    }
}
class solve_212{
    private Trie trie ;

    public solve_212() {
        trie = new Trie() ;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> answers = new ArrayList<>() ;

        return answers ;
    }
}
