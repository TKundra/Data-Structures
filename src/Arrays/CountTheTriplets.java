package Arrays;

public class CountTheTriplets {
    static int countTriplets(int[] array){
        int n = array.length;
        int[] freq = new int[100];

        // loop to count frequency
        for (int i=0; i<array.length; i++) {
            freq[array[i]]++;
        }

        int count = 0;
        // loop to count triplets
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (freq[array[i]+array[j]]>0){
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args){
        int[] array = {1,5,3,2};
        System.out.println(countTriplets(array));
    }
}
