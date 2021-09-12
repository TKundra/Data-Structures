package Arrays;

// dynamic approach
public class KadaneAlgorithm {
    static int maxSubArraySum(int[] array){
        int max = array[0];
        int curr_max = array[0];
        for (int i=1; i<array.length; i++){
            curr_max = Math.max(array[i], curr_max+array[i]);
            max = Math.max(max, curr_max);
        }
        return max;
    }
    public static void main(String[] args){
        int[] array = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubArraySum(array));
    }
}
