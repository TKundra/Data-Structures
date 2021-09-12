package Greedy;
import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start, end;
    Activity(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class CActivity implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return a1.end-a2.end;
    }
}

public class ActivitySelectionObject {
    static void printMaxActivity(Activity[] activities){
        int n = activities.length;
        Arrays.sort(activities,new CActivity());
        int i=0;
        System.out.print("("+activities[i].start + "," + activities[i].end+"), ");
        for (int j=1; j<n; j++){
            if (activities[j].start>=activities[i].end) {
                System.out.print("(" + activities[j].start + "," + activities[j].end + "), ");
                i = j;
            }
        }
    }
    public static void main(String[] args) {
        int n = 6;
        Activity[] activities = new Activity[n];
        activities[0] = new Activity(5,9);
        activities[1] = new Activity(1,2);
        activities[2] = new Activity(3,4);
        activities[3] = new Activity(0,6);
        activities[4] = new Activity(5,7);
        activities[5] = new Activity(8,9);
        printMaxActivity(activities);
    }
}
