package TrieUtils;

import java.util.Scanner;

public class Trie {
    public TrieNode root ;

    public Trie() {
        root = new TrieNode('\0') ;
    }

    private void InsertUtils(TrieNode root , String word)  {
        if (word.isEmpty()){
            root.IsTerminal = true ;
            return;
        }
        int index = word.charAt(0) - 'A' ; // 'word' should be always an uppercase word
        TrieNode newEntry ;
        if (root.children[index] != null)
            newEntry = root.children[index] ;
        else {
            newEntry = new TrieNode(word.charAt(0)) ;
            root.ChildCount++ ;
            root.children[index] = newEntry  ;
        }

        InsertUtils(newEntry , word.substring(1));
    }
    private boolean SearchUtils(TrieNode root , String word)   {
        if (word.isEmpty())
            return root.IsTerminal;
        int index = word.charAt(0) - 'A' ;// 'word' should be always an uppercase word
        TrieNode newEntry ;
        if (root.children[index] != null)
            newEntry = root.children[index] ;
        else
            return false ;
        return SearchUtils(newEntry , word.substring(1)) ;
    }
    private void    RemoveUtils(TrieNode root,String word)     {
        if (word.isEmpty()) {
            root.IsTerminal = false;
            return ;
        }
        int index = word.charAt(0) - 'A' ;// 'word' should be always an uppercase word
        TrieNode newEntry ;
        if (root.children[index] != null)
            newEntry = root.children[index] ;
        else
            return ;
        RemoveUtils(newEntry, word.substring(1));
    }
    private boolean StartWithUtils(TrieNode root , String word){
        if (word.isEmpty())
            return true ;

        int index = word.charAt(0)-'A' ;
        TrieNode newEntry ;
        if (root.children[index] != null)
            newEntry = root.children[index] ;
        else
            return false ;

        return StartWithUtils(newEntry,word.substring(1)) ;
    }
    private boolean advancedSearch(TrieNode root , String word , int index){
        if(index == word.length())
            return root.IsTerminal ;
        char ch = word.charAt(index) ;
        if(ch == '.'){
            for (int i = 0 ; i < 26 ; i ++){
                if (root.children[i] != null && advancedSearch(root.children[i], word , index+1))
                    return true ;
            }
            return false ;
        }
        else {
            if(root.children[ch-'a'] != null)
                return advancedSearch(root.children[ch-'a'] , word , index+1) ;
            else
                return false ;
        }
    }

    public void    Add(String word ){
        System.out.println(word+" added into trie !");
        InsertUtils(root , word);
    }
    public boolean searchFor(String word){
        return advancedSearch(root , word , 0) ;
    }
    public boolean Search(String word){
        boolean answer = SearchUtils(root,word) ;
        if (!answer) {
            String choice = "" ;
            System.out.println(word + " is not in trie yet ,\nDo you want to add it ?");
            choice = new Scanner(System.in).nextLine() ;
            if (choice.equals("yes"))
                Add(word);
            else
                return false ;

        }
        System.out.println(word+" is found in trie !");
        return true ;
    }
    public void    Remove(String word){
        System.out.println(word+" has been removed from trie !");
        RemoveUtils(root,word) ;
    }
    public boolean StartsWith(String prefix) {
        if(StartWithUtils(root,prefix)){
            System.out.println("✔ words are there in trie starts with "+prefix);
            return true ;
        }
        System.out.println("❌ No words in trie starts with "+prefix);
        return false ;
    }
    public void lcp(String _str_ , StringBuilder answer) {
        for (char ch : _str_.toCharArray()){
            if (!root.IsTerminal) {
                if (root.ChildCount == 1) {
                    answer.append(ch);
                    int index = ch - 'a';
                    root = root.children[index];
                } else {
                    break;
                }
            }
            else
                break ;
        }
    }
}
