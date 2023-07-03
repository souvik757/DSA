package TrieUtils;

// Dictionary implementation using trie data structure
public class TrieNode {
    public char ch ;
    public int ChildCount ;
    public TrieNode[] children ;
    public boolean IsTerminal ;

    public TrieNode(char ch) {
        this.ch = ch;
        this.ChildCount = 0 ;
        children = new TrieNode[26] ;
        for (int i = 0 ; i < 26 ; i++)
            children[i] = null ;
        this.IsTerminal = false ;
    }

}
