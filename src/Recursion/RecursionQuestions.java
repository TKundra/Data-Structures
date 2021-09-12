package Recursion;

import java.util.HashSet;

public class RecursionQuestions {

    static void towerOfHanoi(int n, String source, String handler, String destination){
        if (n==1){
            System.out.println("transferring " + n + " from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n-1, source, destination, handler);
        System.out.println("transferring " + n + " from " + source + " to " + destination);
        towerOfHanoi(n-1, handler, source, destination);
    }

    static void printInReverse(String str, int index){
        if (index == 0){
            System.out.print(str.charAt(index));
            return;
        }
        System.out.print(str.charAt(index));
        printInReverse(str, index-1);
    }

    static int first = -1;
    static int last = -1;
    static void firstAndLastOccurrence(String str, int index, char element){
        if (index == str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char current = str.charAt(index);
        if (element == current){
            if (first == -1){
                first = index;
            }else {
                last = index;
            }
        }
        firstAndLastOccurrence(str, index+1, element);
    }

    static boolean isSortedInStrictlyIncreasing(int[] array, int index){
        if (index == array.length-1)
            return true;
        if (array[index] < array[index+1])
            return isSortedInStrictlyIncreasing(array, index+1);
        return false;
    }

    static void moveAllX(String str, int index, int count, String newString){
        if (index == str.length()-1){
            for (int i=0; i<count; i++){
                newString += 'x'; // add x in newString
            }
            System.out.println(newString);
            return;
        }
        char current = str.charAt(index);
        if (current == 'x'){
            count++; // count x
            moveAllX(str, index+1, count, newString);
        }else {
            newString += current; // else save non x chars
            moveAllX(str, index+1, count, newString);
        }
    }

    static boolean[] map = new boolean[26]; // 26 alphabets
    static void removeDuplicated(String str, int index, String newString){
        if (index == str.length()){
            System.out.println(newString);
            return;
        }
        char curr = str.charAt(index);
        if (map[curr - 'a']){ // if char already visited, call function again
            removeDuplicated(str, index+1, newString);
        }else { // that char we visiting first time
            newString += curr;
            map[curr-'a'] = true; // and make it true
            removeDuplicated(str, index+1, newString);
        }
    }

    static void subSequence(String str, int index, String newString){
        if (index == str.length()){
            System.out.println(newString);
            return;
        }
        char curr = str.charAt(index);
        subSequence(str, index+1, newString+curr);
        subSequence(str, index+1, newString);
    }

    static void uniqueSubSequence(String str, int index, String newString, HashSet<String> set){
        /* new function by devT */
        if (index == str.length()){
            if (set.contains(newString)){
                return;
            }else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char curr = str.charAt(index);
        uniqueSubSequence(str, index+1, newString, set);
        uniqueSubSequence(str, index+1, newString+curr, set);
    }

    static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    static void keypadCombination(String str, int index, String combination) {
        if (index == str.length()){
            System.out.println(combination);
            return;
        }
        char curr = str.charAt(index);
        String mapping = keypad[curr-'0'];
        for (int i=0; i<mapping.length(); i++){
            keypadCombination(str, index+1, combination+mapping.charAt(i));
        }
    }

    public static void main(String[] args) {

    }

}
