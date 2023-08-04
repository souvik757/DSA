import java.util.* ;
public class _30_Substring_with_Concatenation {
    public static void main(String[] args) {
        solve_30 object = new solve_30() ;
        System.out.println(object.findSubstring("barfoothefoobarman" , new String[]{"foo" , "bar"})) ;
    }
}
class solve_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>() ;
        Map<String,Integer> wordsMap = new HashMap<>() ;
        Arrays.stream(words).
                forEach(word ->
                        wordsMap.put(word , wordsMap.getOrDefault(word,0)+1));
        int wordLength = words[0].length() ;
        int count = words.length ;
        for (int index = 0 ; index <= s.length() - wordLength*count ; index ++){
            if(containsAllWords(wordsMap , s.substring(index,index+ count*wordLength),wordLength))
                answer.add(index) ;
        }
        return answer ;
    }

    private boolean containsAllWords(Map<String, Integer> wordsMap, String substring, int wordLength) {
        Map<String,Integer> subStrWordsMap = new HashMap<>() ;
        for (int i = 0 ; i < substring.length() ; i += wordLength){
            String searchWord = substring.substring(i,i+wordLength) ;
            subStrWordsMap.put(searchWord , subStrWordsMap.getOrDefault(searchWord,0)+1) ;
            if(subStrWordsMap.get(searchWord) > wordsMap.getOrDefault(searchWord,0))
                return false ;
        }
        return true ;
    }
}