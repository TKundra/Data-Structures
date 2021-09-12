package Arrays;

public class TrappingRainWater {

    static int maxWater(int[] array, int n){
        // to store maximum water that can be stored
        int res = 0;
        // for every element of array except first and last element
        for (int i=1; i<n-1; i++){
            // find max element on its left
            int left = array[i];
            for (int j=0; j<i; j++){
                left = Math.max(left, array[j]);
            }
            // find max element on right
            int right = array[i];
            for (int j=i+1; j<n; j++){
                right = Math.max(right, array[j]);
            }
            // update maximum water value
            res += Math.min(left, right) - array[i];
        }
        return res;
    }

    // better version
    static int findWater(int[] array, int n){
        // maintain left and right
        int left = 0, right = array.length-1, water = 0;
        int maxLeft = array[left];
        int maxRight = array[right];
        while (left<right){
            if (array[left]<=array[right]){
                left++;
                maxLeft = Integer.max(maxLeft, array[left]);
                water += (maxLeft-array[left]);
            }else {
                right--;
                maxRight = Integer.max(maxRight, array[right]);
                water += (maxRight-array[right]);
            }
        }
        return water;
    }

    public static void main(String[] args){
        int[] array = {6,4,0,5};
        System.out.println(findWater(array, array.length));
    }
}
