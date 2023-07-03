package Problems;

import TrieUtils.Trie;

public class _14_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(SOLVE_14.longestCommonPrefix(new String[]{"FLOWER","FLOW","FLIGHT"}));
    }
}
class SOLVE_14 {
    public static String longestCommonPrefix(String[] strs){
        Trie trie = new Trie() ;
        for (String str : strs)
            trie.Add(str);
        String first = strs[0] ;
        StringBuilder answer = new StringBuilder() ;
        trie.lcp(first,answer) ;

        return new String(answer) ;
    }
}