package StringsIMP;

import StringsIMP.Questions.Qus1;
import StringsIMP.Questions.Qus2;
import StringsIMP.Questions.Qus3;

/**
    Remove Character from First String Not Present in Second String:
    4 . Given two strings, remove all characters from the first string that are not present in the second string.

    Longest Repeating Substring:
    6 . Find the longest substring that occurs more than once in a given string.

    Reverse String with Recursion:
    7 . Implement a function to reverse a string using recursion.

    All Permutations of a String:
    8 . Generate all possible permutations of the characters in a given string.

    Anagram of Strings:
    9 . Check if two strings are anagrams of each other. Anagrams are words or phrases formed by rearranging the letters of another.

    Convert String to Integer:
    10 . Convert a string representation of an integer to an actual integer value.

    Count the Number of Words in a String:
    11 . Count and return the number of words in a given string. Words are typically separated by spaces.

    Valid Parentheses:
    12 . Check if a given string of parentheses is valid, i.e., if the parentheses are properly balanced and nested.
 */

public class IMP {
    public static void main(String[] args) {
        System.out.println(Qus1.getChar("soouvvikkkkk")) ;
        System.out.println(Qus2.getString("soouvvikkkkk")) ;
        Qus3.duplicateChars("soouvvikkkkk");
    }
}
