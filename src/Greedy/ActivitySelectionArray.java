package Greedy;

public class ActivitySelectionArray {
    static void printMaxActivities(int[] start, int[] end, int n){
        int i,j;
        // first always get selected
        i=0;
        System.out.print(i + " ");
        for (j=1; j<n; j++){
            // if start time > end, then select it
            if (start[j]>=end[i]){
                System.out.print(j + " ");
                i=j;
            }
        }
    }
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        printMaxActivities(start, end, start.length);
    }
}
