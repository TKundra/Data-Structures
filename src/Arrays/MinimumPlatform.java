package Arrays;
import java.util.Arrays;

public class MinimumPlatform {

    static int findPlatform(int[] arrival, int[] departure, int n){
        int platform_needed = 1, // indicated platform needed at a time
        result = 1, i = 1, j = 0;
        for (i=0; i<n; i++){
            platform_needed = 1; // min platform
            for (j=i+1; j<n; j++){
                if ((arrival[i]>arrival[j] && arrival[i]<=departure[j])
                || arrival[j]>=arrival[i] && arrival[j]<=departure[i]){
                    platform_needed++;
                }
            }
            result = Math.max(result,platform_needed);
        }
        return result;
    }

    // better
    static int findPlatform(int[] arrival, int[] departure){
        // sort arrival and departure
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int platform_needed = 1, // indicated platform needed at a time
        result = 1, i = 1, j = 0, n = arrival.length;
        while (i<n && j<n){
            // if next event in sorted is arrival
            if (arrival[i]<=departure[j]){
                platform_needed++;
                i++;
            }else if (arrival[i]>departure[j]) { // dec count of platform needed
                platform_needed--;
                j++;
            }
            // update result
            if (platform_needed > result)
                result = platform_needed;
        }
        return result;
    }

    public static void main(String[] args){
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arrival,departure));
    }
}
