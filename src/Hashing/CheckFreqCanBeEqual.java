package Hashing;
import java.util.Arrays;

public class CheckFreqCanBeEqual {
    static final int M = 26;

    // method to get index of character
    static int getIndex(char ch){
        return (ch-'a');
    }

    // returns true if all non-zero elements values are same
    static boolean allSame(int[] freq, int N){
        int same = 0;
        // get first non-zero element
        int i;
        for (i=0; i<N; i++){
            if (freq[i]>0){
                same = freq[i];
                break;
            }
        }
        // check equality of each element with variable name
        for (int j=i+1; j<N; j++){
            if (freq[j]>0 && freq[j]!=same)
                return false;
        }
        return true;
    }

    // returns true if we can make all characters frequencies same
    static boolean possible(String string){
        int length = string.length();
        // fill frequency array
        int[] freq = new int[M];
        for (int i=0; i<length; i++){
            freq[getIndex(string.charAt(i))]++;
        }
        // if all frequencies are same
        if (allSame(freq, M))
            return true;
        // try decreasing freq of all chars by one and
        // then check all equality of all non-zero frequencies
        for (char c='a'; c<='z'; c++){
            int i = getIndex(c);
            // check char only if it occurs in string
            if (freq[i]>0){
                freq[i]--;
                if (allSame(freq,M))
                    return true;
                freq[i]++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String string = "abbcc";
        if (possible(string))
            System.out.println("yes");
        else
            System.out.println("no");
    }

}
