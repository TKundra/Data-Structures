package Extras;
import java.util.Arrays;

public class Questions {

    /* automobile company manufactures both 2 & 4 wheelers and want to make production according to
    given data.
        * (two wheeler + four wheeler) = v
        * total number of wheels = w
            (input) v=200, w=540
            (output) TW=130, FW=70 as 70*4 + 130*2 = 540 */

    static void found(int v, int w) {
        float result = ((4 * v) - w) / 2;
        /// wheels >= 2 && wheels%2 == 0 && vehicles<wheels
        if (w >= 2 && (w % 2 == 0) && v < w){
            System.out.println("res" + result);
            System.out.println("TW= " + (int) (result) + " FW= " + (int) (v - result));
        }else
            System.out.println("invalid input");
    }

    /* given string consists of '*' & '#'
    find minimum number of '*' & '#' to make the string valid
    i.e number of '*' = number of '$' */

    static void countData(){
        String data = "###***";
        int s=0, h=0;
        for (int i=0; i<data.length(); i++){
            if (data.charAt(i) == '#')
                h++;
            else if (data.charAt(i) == '*')
                s++;
        }
        System.out.println(s-h);
    }

    /* push empty packets of chocolates at end of conveyor belt */
    static void pushAtEnd(){
        int[] array = {4,5,0,1,9,0,5,0};
        int count = 0;
        for (int i=0; i< array.length; i++){
            if (array[i]!=0)
                array[count++] = array[i];
        }
        System.out.println("count " + count);
        for (int i= array.length-1; i>=count; i--)
            array[i] = 0;
        System.out.println(Arrays.toString(array));
    }

    /* count number of sundays from given data
        * start day of month - monday
        * number of days from start of month - 13
            total sundays - 2 */
    static void countDay(){
        String[] days = {"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
        String startDay = "mon";
        int daysFromDay = 13;
        int i=0;
        for (i=0; i<days.length; i++){
            if (days[i].equals(startDay))
                break;
        }
        int res = 1;
        int remainingDays = 6-i;
        System.out.println("rem " + remainingDays);
        daysFromDay -= remainingDays;
        System.out.println("daysFromDay " + daysFromDay);
        if (daysFromDay>0)
            res += daysFromDay/7;
        System.out.println(res);
    }

    /* maximum number of guests on ship */
    static void maxGuest(){
        int T = 5;
        int[] entries = {7,0,5,1,3};
        int[] exits = {1,2,1,3,4};
        int max = 0, result = 0;
        for (int i=0; i<T; i++){
            result = result + entries[i] - exits[i];
            if (result >= max)
                max = result;
        }
        System.out.println(max);
    }

    /* find color of balloons present odd number of balloons */
    static void oddBalloons(){
        char[] balloons = {'r','g','b','b','g','y','y'};
        int[] counts = new int[26];
        for (char balloon : balloons) {
            counts[balloon-'a']++;
        }
        for (int i=0; i<counts.length; i++) {
            if (counts[i] == 1)
                System.out.println((char)(i+'a'));
        }
        System.out.println(Arrays.toString(counts));
    }

    /* product of all digits in N */
    static void productN(){
        int N = 5244;
        int result = 1;
        while (N>0){
            result *= (N%10);
            N /= 10;
        }
        System.out.println(result);
    }

    /* encrypt */
    static void encrypt(){
        String data = "word";
        String result = "";
        for (int i=0; i<data.length(); i++){
            if (data.charAt(i)<='u')
                result += (char)(data.charAt(i)+5);
            else
                result += (char)(data.charAt(i)-'v'+'a');
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        countDay();
    }
}
