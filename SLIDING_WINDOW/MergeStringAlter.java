public class MergeStringAlter {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcdef" , "xyzs"));
    }
    public static String mergeAlternately(String word1 , String word2){
        char[] xch = word1.toCharArray() ;
        char[] ych = word2.toCharArray() ;
        char[] answer = new char[word1.length()+word2.length()] ;
        int i = 0 ;
        int j = 0 ;
        int index = 0 ;
        while((i < xch.length || j < ych.length) && index < (word1.length()+word2.length())){
            if(index % 2 == 0) {
                if(i == xch.length)
                {
                    for(int copy = j ; copy < ych.length ; copy++) {
                        answer[index] = ych[copy];
                        index++ ;
                    }
                }
                else {
                    answer[index] = xch[i];
                    i++;
                }
            }
            else {
                if(j == ych.length)
                {
                    // copy everything from word1 to answer
                    for(int copy = i ; copy < xch.length ; copy++) {
                        answer[index] = xch[copy];
                        index++ ;
                    }
                }
                else {
                    answer[index] = ych[j];
                    j++;
                }
            }
            index++ ;
        }
        return new String(answer) ;
    }
}
