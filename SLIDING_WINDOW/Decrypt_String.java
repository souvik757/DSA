import java.util.Arrays;
import java.util.HashMap;

public class Decrypt_String {
    public static void main(String[] args) {
        Decrypt_String result = new Decrypt_String() ;
        System.out.println(result.freqAlphabets("10#11#12"));
        System.out.println(result.freqAlphabets(""));
        System.out.println(result.freqAlphabets("11#12"));
        // 10#11#12
        // 01234567 8 8 -2 = 6
    }
    public String freqAlphabets(String s) {
        if(s.isEmpty())
            return new String() ;
        HashMap <Character , Character> mapCH = aTOi() ;
        HashMap <String , Character> mapSTR = jTOz() ;
        char[] sch = s.toCharArray() ;
        char[] answer = new char[s.length()] ;
        int index = 0 ;
        int i = 0 ;
        while (i < sch.length - 2){
            if(sch[i+2] == '#'){
                String key = String.valueOf(Arrays.copyOfRange(sch , i , i+3)) ;
                i += 3;
                answer[index] = mapSTR.get(key) ;
            }
            else
            {
                answer[index] = mapCH.get(sch[i]) ;
                i++ ;
            }
            index++ ;
        }
        if(i != sch.length){
            for(int j = i ; j < sch.length ; j++){
                answer[index] = mapCH.get(sch[j]) ;
                index++ ;
            }
        }
        return new String(answer).trim() ;
    }
    public HashMap<Character , Character> aTOi(){
        HashMap<Character , Character> map = new HashMap<>() ;
        map.put('1' , 'a') ;
        map.put('2' , 'b') ;
        map.put('3' , 'c') ;
        map.put('4' , 'd') ;
        map.put('5' , 'e') ;
        map.put('6' , 'f') ;
        map.put('7' , 'g') ;
        map.put('8' , 'h') ;
        map.put('9' , 'i') ;
        return map ;
    }
    public HashMap<String , Character> jTOz(){
        HashMap<String , Character> map = new HashMap<>() ;
        map.put("10#" , 'j') ;
        map.put("11#" , 'k') ;
        map.put("12#" , 'l') ;
        map.put("13#" , 'm') ;
        map.put("14#" , 'n') ;
        map.put("15#" , 'o') ;
        map.put("16#" , 'p') ;
        map.put("17#" , 'q') ;
        map.put("18#" , 'r') ;
        map.put("19#" , 's') ;
        map.put("20#" , 't') ;
        map.put("21#" , 'u') ;
        map.put("22#" , 'v') ;
        map.put("23#" , 'w') ;
        map.put("24#" , 'x') ;
        map.put("25#" , 'y') ;
        map.put("26#" , 'z') ;
        return map ;
    }
}
