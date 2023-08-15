package TrieUtils;

public class Utils {
    private static final Trie trie = new Trie() ;
    public static void main(String[] args) {

        trie.Add("CAR");
        trie.Add("RACE");
        trie.Add("SHOTGUN");

        trie.Search("GUN") ;
        trie.Remove("GUN");
        trie.Search("G") ;
        trie.Search("GU") ;
        trie.Search("GUN") ;
        trie.Add("GUN");
        trie.Search("G") ;
        trie.Search("GU") ;
        trie.Search("GUN") ;
        trie.StartsWith("SH") ;
        trie.StartsWith("SO") ;
    }
}
