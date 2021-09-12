package Arrays;

public class LeadersInArray {

    // simple
    static void leaders(int[] array, int n){
        for (int i=0; i<n; i++){
            int j;
            for (j=i+1; j<n; j++){
                if (array[i] <= array[j])
                    break;
            }
            if (j==n) { // the loop didn't break
                System.out.print(array[i] + " ");
            }
        }
    }

    // better
    static void leaders(int[] array){
        int n = array.length;
        int max = array[n-1];
        System.out.print(max + " ");
        for (int i=n-2; i>=0; i--){
            if (max < array[i]){
                max = array[i];
                System.out.print(max + " ");
            }
        }
    }

    public static void main(String[] args){
        int[] array = {16,17,4,3,5,2};
        leaders(array);
    }
}
