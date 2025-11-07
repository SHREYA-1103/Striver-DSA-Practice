// -------------------------------- Ques --------------------------------
// Given n process, each assumed to have arrived at 0 and having a burst time (cpu running time) given by burstTime[i], schedule them using shortest job first algorithm and find the average waiting time.
// ----------------------------------------------------------------------


import java.util.*;

public class ShortestJobFirst {

    // Optimal - O(n log n), O(1)
    public static int avgWT(int burstTime[]){
        int n = burstTime.length;
        
        Arrays.sort(burstTime);

        int time = 0;
        int wt = 0;

        int i = 0;

        while(i < n){
            wt += time;
            time += burstTime[i];
            i++;
        }

        return wt/n;
    }
    
    public static void main(String args[]){
        int burstTime[] = {4,3,7,1,2};

        System.out.println(avgWT(burstTime));
    }
}
