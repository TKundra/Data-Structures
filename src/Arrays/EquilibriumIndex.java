package Arrays;

public class EquilibriumIndex {

    // simple but inefficient
    static int index(int[] array, int n){
        int i, j;
        int leftSum, rightSum;
        for (i=0; i<n; i++){
            // get left sum
            leftSum = 0;
            for (j=i; j<n; j++){
                leftSum += array[j];
            }
            // get right sum
            rightSum = 0;
            for (j=i+1; j<n; j++){
                rightSum += array[j];
            }
            // if they are equal return index
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }

    // efficient
    static int index(int[] array){
        int n = array.length;
        int sum = 0, leftSum = 0;
        for (int i=0; i<n; i++){
            sum += array[i];
        }
        for (int i=0; i<n; i++){
            sum -= array[i]; // sum is now right sum of index i
            if (leftSum == sum)
                return i;
            leftSum += array[i];
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = {-7,1,5,2,-4,3,0};
        System.out.println(index(array, array.length));
        System.out.println("first equilibrium index: " + index(array));
    }
}
