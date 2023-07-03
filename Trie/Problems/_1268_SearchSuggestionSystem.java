package Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
// This problem is solved with trie in standard approaches :
public class _1268_SearchSuggestionSystem {
    public static void main(String[] args) {
        SOLVE_1268_BIN object = new SOLVE_1268_BIN() ;
        List<List<String>> suggestions = object.suggestedProducts(new String[]{"bags","baggage","banner","box","cloths"}
                ,"bags") ;
        System.out.println(suggestions);
    }
}
class SOLVE_1268_BIN{
    public List<List<String>> suggestedProducts(String[] products , String searchWord) {
        List<List<String>> answer = new ArrayList<>() ;
        Arrays.sort(products) ; // O(n log n)
        int s = 0 ;
        int e = products.length-1 ;

        for (int i = 0 ; i < searchWord.length() ; i++){// O(m)
            char ch = searchWord.charAt(i) ;
            while(s <= e && (i >= products[s].length() || products[s].charAt(i) != ch))
                s++;
            while(s<=e && (i >= products[e].length() || products[e].charAt(i) != ch))
                e--;
            List<String> suggestions = new ArrayList<>() ;
            int start = s ;
            int K = 3 ;
            while (start <= e && K-->0){
                suggestions.add(products[start++]);
            }
            answer.add(new ArrayList<>(suggestions));
        }

        return answer ;
    }
}