import java.util.Scanner;

/*
You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is.
When your friend makes a guess, you provide a hint with the following info:

    The number of "bulls", which are digits in the guess that are in the correct position.
    The number of "cows", which are digits in the guess that are in your secret number
    but are located in the wrong position.
    Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.

Given the secret number and your friend's guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB",
where x is the number of bulls and y is the number of cows.
Note that both secret and guess may contain duplicate digits.
 */
public class _find_the_hint_ {
    static _find_the_hint_ result = new _find_the_hint_() ;
    public static void main(String[] args) {
        String s1 = new Scanner(System.in).nextLine() ;
        System.out.println("-----");
        String s2 = new Scanner(System.in).nextLine() ;
        System.out.println(result.getHint(s1 , s2));
    }
    public String getHint(String secret, String guess) {
        int bull = 0 ;
        int cow = 0 ;
        int[] freq = new int[10] ;
        for(int i = 0 ; i < secret.length() ; i++){
            int s = Character.getNumericValue(secret.charAt(i)) ;
            int g = Character.getNumericValue(guess.charAt(i)) ;
            if(s == g)
                bull++ ;
            else{
                if (freq[s] < 0 ) cow++ ;
                if (freq[g] > 0 ) cow++ ;
                freq[s]++ ;
                freq[g]-- ;
            }
        }
    return bull+"A"+cow+"B" ;
    }
}
