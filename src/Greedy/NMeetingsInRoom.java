package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Meeting {
    int start;
    int end;
    int position; // position of meeting
    Meeting(int start, int end, int position){
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class MCEnding implements Comparator<Meeting>{
    @Override
    public int compare(Meeting m1, Meeting m2) {
        // asc
        if (m1.end > m2.end)
            return 1;
        else if (m1.end < m2.end)
            return -1;
        return 0;
    }
}

public class NMeetingsInRoom {
    static void maxMeetings(ArrayList<Meeting> meetings, int n){
        ArrayList<Integer> resultMeetings = new ArrayList<>();
        int time_limit = 0;

        // sort meeting according to finish time
        MCEnding mcEnding = new MCEnding();
        Collections.sort(meetings, mcEnding);

        // initially select first meeting
        resultMeetings.add(meetings.get(0).position);

        // time to check whether new meeting conducted or not
        time_limit = meetings.get(0).end;

        // check for all meetings
        for (int i=1; i<meetings.size(); i++){
            if (meetings.get(i).start>time_limit){
                // add selected meeting
                resultMeetings.add(meetings.get(i).position);
                // update time
                time_limit = meetings.get(i).end;
            }
        }

        // print final selected meetings
        for (int i=0; i<resultMeetings.size(); i++)
            System.out.print(resultMeetings.get(i)+1 + " ");
    }
    public static void main(String[] args) {
        // starting time
        int[] starting_time = {1,3,0,5,8,5};
        // ending time
        int[] ending_time = {2,4,6,7,9,9};
        // define array of meeting type
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i=0; i<starting_time.length; i++){
            meetings.add(new Meeting(starting_time[i],ending_time[i],i));
        }
        maxMeetings(meetings, meetings.size());
    }
}
