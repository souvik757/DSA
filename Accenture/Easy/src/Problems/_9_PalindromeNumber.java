package Problems;

public class _9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        return String.valueOf(x).equals(String.valueOf(new StringBuilder(String.valueOf(x)).reverse())) ;
    }
}
