package Arrays;

public class ArrayInZigZagFashion {

    static void zigZag(int[] array){
        int swap;
        for (int i=0; i<array.length-1; i++){
            if ((i%2==0) && (array[i]>array[i+1])) {
                swap = array[i];
                array[i] = array[i + 1];
                array[i+1] = swap;
            } else if ((i%2==1) && (array[i]<array[i+1])) {
                swap = array[i];
                array[i] = array[i + 1];
                array[i+1] = swap;
            }
        }
        for (int j : array)
            System.out.print(j + " ");
    }

    public static void main(String[] args){
        // 3 < 7 > 4 < 8 > 2 < 6 > 1
        int[] array = {4,3,7,8,6,2,1};
        zigZag(array);
    }

}
