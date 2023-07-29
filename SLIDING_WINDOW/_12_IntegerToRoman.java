import java.util.HashMap;
import java.util.Map;

public class _12_IntegerToRoman {
    public static void main(String[] args) {
        solve_12_13 object = new solve_12_13() ;
        System.out.println(object.intToRoman(2853));
        System.out.println(object.intToRoman(16));
        System.out.println(object.intToRoman(15));

        System.out.println(object.romanToInteger("MMDCCCLIII"));
        System.out.println(object.romanToInteger("XVI"));
        System.out.println(object.romanToInteger("VIIX"));

    }
}
class solve_12_13 {
    private Map<Character,Integer> strVal = new HashMap<>() ;
    private String[][] strMap ;

    public solve_12_13() {
        strVal.put('I' , 1) ;
        strVal.put('V' , 5) ;
        strVal.put('X' , 10) ;
        strVal.put('L' , 50) ;
        strVal.put('C' , 100) ;
        strVal.put('D' , 500) ;
        strVal.put('M' , 1000) ;

        strMap = new String[][]{
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"},
        } ;
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
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder() ;

        int firstDigit = (num) % 10 ;
        int secondDigit = (num/10) % 10 ;
        int thirdDigit = (num/100) % 10 ;
        int forthDigit = (num/1000) % 10 ;

        ans.append(strMap[3][forthDigit]) ;
        ans.append(strMap[2][thirdDigit]) ;
        ans.append(strMap[1][secondDigit]) ;
        ans.append(strMap[0][firstDigit]) ;

        return new String(ans) ;
    }
}