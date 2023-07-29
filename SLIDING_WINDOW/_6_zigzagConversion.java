import java.util.Arrays;

public class _6_zigzagConversion {
    public static void main(String[] args) {
        solve_6 object = new solve_6() ;
        System.out.println(object.convert("PAYPALISHIRING" , 3));
        System.out.println(object.convert("PAYPALISHIRING" , 4));
        System.out.println(object.convert("P" , 1));
    }
}
class solve_6 {
    public String convert(String s, int numRows) {

        StringBuilder answer = new StringBuilder() ;
        char[][] ch = new char[numRows][s.length()/2] ;
        for (char[] arr : ch)
            Arrays.fill(arr , ' ');
        int i = 0 ;
        int j = 0 ;
        boolean down = true ;
        for (char c : s.toCharArray()){
            if(down){
                if(ifValid(i,j,ch)){
                    ch[i][j] = c ;
                    if(i == numRows-1)
                    {
                        down = false ;
                        i -- ;
                        j ++ ;
                    }
                    else
                        i = i + 1 ;
                }
            }
            else {
                if(ifValid(i,j,ch)){
                    ch[i][j] = c ;
                    if(i == 0){
                        down = true ;
                        i ++ ;
                    }
                    else {
                        i--;
                        j++;
                    }
                }
            }
        }

        for (int rindex = 0 ; rindex < ch.length ; rindex++){
            String str = "" ;
            for (int cindex = 0 ; cindex < ch[0].length ; cindex++){
                if(ch[rindex][cindex] != ' ')
                    str = str + ch[rindex][cindex] ;
            }
            answer.append(str) ;
        }

        return (numRows <= 1) ? s : new String(answer) ;
    }
    private boolean ifValid(int i , int j , char[][] ch){
        return i>=0 && j>=0 && i<ch.length && j<ch[0].length ;
    }
}