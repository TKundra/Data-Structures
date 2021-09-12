package Graph;
import java.util.ArrayList;
import java.util.Collections;

public class JobSequence {

    /*  each job has unique id,
        profit and deadline */
    char id;
    int deadline, profit;
    JobSequence(){}
    JobSequence(char id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    /*  function to schedule the jobs take two arguments
        (jobs, number of jobs to schedule) */
    void jobScheduling(ArrayList<JobSequence> jobSequences, int toSchedule){
        int n = jobSequences.size();
        /* sort all jobs according to decreasing order of profit */
        jobSequences.sort((o1, o2) -> o2.profit - o1.profit);
        /* keep track of free time slot */
        boolean[] result = new boolean[toSchedule];
        /* to store result (sequence of job) */
        char[] job = new char[toSchedule];

        for (int i=0; i<n; i++){
            for (int j=Math.min(toSchedule-1, jobSequences.get(i).deadline-1); j>=0; j--){
                // free slot found
                if (!result[j]){
                    result[j] = true;
                    job[j] = jobSequences.get(i).id;
                    break;
                }
            }
        }

        /* print sequence */
        for (char js : job)
            System.out.print(js+" ");
        System.out.println();

    }

    public static void main(String[] args){
        ArrayList<JobSequence> jobs = new ArrayList<>();
        jobs.add(new JobSequence('a', 2, 100));
        jobs.add(new JobSequence('b', 1, 19));
        jobs.add(new JobSequence('c', 2, 27));
        jobs.add(new JobSequence('d', 1, 25));
        jobs.add(new JobSequence('e', 3, 15));
        JobSequence sequence = new JobSequence();
        sequence.jobScheduling(jobs, 3);
    }
}
