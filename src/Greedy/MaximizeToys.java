package Greedy;
import java.util.Arrays;

public class MaximizeToys {
    static int maxToys(int[] cost, int n, int k){
        int count=0, sum=0;
        // sort array
        Arrays.sort(cost);
        for (int i=0; i<n; i++){
            if (sum+cost[i]<=k){
                sum += cost[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int k = 50;
        int[] cost = {1,12,5,111,200,1000,10,9,12,15};
        System.out.println(maxToys(cost, cost.length, k));
    }
}
