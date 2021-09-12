package Arrays;

public class SortArray012 {

    static void sort(int[] array, int n){
        int count0=0, count1=0, count2=0, i;
        for (i=0; i<n; i++){
            switch (array[i]){
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }
        // update array
        i=0;
        // sort all 0
        while (count0>0){
            array[i] = 0;
            i++;
            count0--;
        }
        // sort all 1
        while (count1>0){
            array[i] = 1;
            i++;
            count1--;
        }
        // sort all 2
        while (count2>0){
            array[i] = 2;
            i++;
            count2--;
        }
        // print
        for (int k : array) {
            System.out.print(k + " ");
        }
    }

    public static void main(String[] args){
        int[] array = {0,1,1,0,1,2,1,2,0,0,0,1};
        sort(array, array.length);
    }
}
