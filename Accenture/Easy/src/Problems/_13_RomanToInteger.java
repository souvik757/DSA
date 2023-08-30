package Problems;

import java.util.Map ;
import java.util.HashMap ;
public class _13_RomanToInteger {
private Map<Character,Integer> strVal = new HashMap<>() ;

    public _13_RomanToInteger() {
        strVal.put('I' , 1) ;
        strVal.put('V' , 5) ;
        strVal.put('X' , 10) ;
        strVal.put('L' , 50) ;
        strVal.put('C' , 100) ;
        strVal.put('D' , 500) ;
        strVal.put('M' , 1000) ;
    }

    public int romanToInteger(String roman){
        int sum = 0 ;
        char[] ch = roman.toCharArray() ;
        for (int i = 0 ; i < ch.length ; i ++ ){
            if(ch[i] == 'I'){
                if(i+1 < ch.length){
                    if(ch[i+1] == 'V') {
                        sum += 4;
                        i ++ ;
                    }
                    else if(ch[i+1] == 'X') {
                        sum += 9;
                        i ++ ;
                    }
                    else
                        sum += 1 ;
                }
                else {
                    sum += 1 ;
                }
            }
            else if(ch[i] == 'X'){
                if(i+1 < ch.length){
                    if(ch[i+1] == 'L') {
                        sum += 40;
                        i ++ ;
                    }
                    else if(ch[i+1] == 'C') {
                        sum += 90;
                        i ++ ;
                    }
                    else
                        sum += 10 ;
                }
                else {
                    sum += 10 ;
                }
            }
            else if(ch[i] == 'C'){
                if(i+1 < ch.length){
                    if(ch[i+1] == 'D') {
                        sum += 400;
                        i ++ ;
                    }
                    else if(ch[i+1] == 'M') {
                        sum += 900;
                        i ++ ;
                    }
                    else
                        sum += 100 ;
                }
                else {
                    sum += 100 ;
                }
            }
            else
                sum += strVal.get(ch[i]) ;
        }

        return sum ;
    }
}
